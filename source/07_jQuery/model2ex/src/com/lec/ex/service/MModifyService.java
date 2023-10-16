package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
public class MModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024; // 사진 업로드 제한 용량 : 1M
		String mphoto = ""; // 첨부된 파일이름을 저장할 변수
		int result = MemberDao.FAIL; // 회원가입 결과를 저장할 변수
		MultipartRequest mRequest = null;
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8",
											new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames(); // 파라미터이름들
			//while(params.hasMoreElements()) {
				String param = params.nextElement();
				mphoto = mRequest.getFilesystemName(param);
			//}
			// mRequest를 이용하여 파라미터 받아와서 DB에 저장하기
			String dbMphoto = mRequest.getParameter("dbMphoto");
			String mid = mRequest.getParameter("mid");
			String oldMpw = mRequest.getParameter("oldMpw");
			String mpw = mRequest.getParameter("mpw");
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			mphoto = mphoto==null? dbMphoto : mphoto;
			String mbirthStr = mRequest.getParameter("mbirth");
			// Date mbirth = mbirthStr.equals("") ? null:Date.valueOf(mbirthStr);
			Date mbirth = null;
			if(!mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);
			}
			String maddress = mRequest.getParameter("maddress");
			MemberDao mDao = MemberDao.getInstance();
			MemberDto mDto = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
			result = mDao.modifyMember(mDto);
			if(result == MemberDao.SUCCESS) { // 가입 가능한 mid라서 회원가입진행
					HttpSession session = request.getSession();
					session.setAttribute("member", mDto);
					request.setAttribute("modifyResult", "정보수정이 완료되었습니다");
				// 회원가입
			}else { // 가입 불가한 mid
				request.setAttribute("modifyErrorMsg", "정보수정이  실패되었습니다");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			request.setAttribute("modifyErrorMsg", "첨부 파일의 용량은 1M 이내로 업로드 해주세요");
		}
		// mRequest를 이용하여 파라미터 받아와서 DB에 저장하기 로직은 위 try절에서
		// 서버에 업로드된 파일을 소스폴더로 복사
		File serverFile = new File(path + "/" + mphoto);
		if(serverFile.exists() && !mphoto.equals("NOIMG.JPG") && result==MemberDao.SUCCESS) {
			InputStream is = null;
			OutputStream os = null;
			try{
				is = new FileInputStream(serverFile); // 서버에 업로드된 파일
				os = 
				new FileOutputStream("C:/Webpro/source/07_jQuery/model2ex/WebContent/memberPhotoUp/"
							+ mphoto);
				byte[] bs = new byte[(int)serverFile.length()];
				while(true){
					int readByteCnt = is.read(bs);
					if(readByteCnt==-1) break;
					os.write(bs, 0, readByteCnt);
				}
				System.out.println(mphoto +" 복사 완료");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				}catch (IOException e) {
					System.out.println(e.getMessage());
				} // close
			} // try-catch-finally
		}// if-파일복사여부
	}// execute함수

}
