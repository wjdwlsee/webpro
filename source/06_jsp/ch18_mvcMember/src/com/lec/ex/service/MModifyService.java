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
		//첨부한 파일 저장 -> 파라미터 받아 DB 수정(현 비밀번호에 따라)-> 첨부한 파일을 소스폴더로 복사
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024*1024; //사진 업로드 제한 용량 : 1M
		String mphoto = ""; // 첨부된 파일이름을 저장한 변수
		int result = MemberDao.FAIL; //정보수정 결과를 저장할 변수
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params= mRequest.getFileNames(); //파라미터이름들
				String param = params.nextElement(); //mphoto
				mphoto = mRequest.getFilesystemName(param); //첨부할 파일명
				//mRequest를 이용하여 파라미터를 받아와서 DB에 수정 가능 
				String dbMpw = mRequest.getParameter("dbMpw");
				String dbmphoto = mRequest.getParameter("dbMphoto");
				//hidden으로 넘어온 dbMpw, dbMphoto가 없을 경우 session에서 가져오면 됨
				//HttpSession session = request.getSession();
				//String dbMpw = null, dbmphoto =null;
				//
				String mid = mRequest.getParameter("mid");
				String oldMpw = mRequest.getParameter("oldMpw");
				if(!oldMpw.equals(dbMpw)) {
					request.setAttribute("modifyErrorMsg", "현비밀번호를 확인하세요");
					return;
				}
				String mpw = mRequest.getParameter("mpw");
				if(mpw.equals("")) { //정보수정시 새비밀번호를 입력하지 않은 경우 현비밀번호
					mpw = dbMpw;
				}
				String mname = mRequest.getParameter("mname");
				String memail = mRequest.getParameter("memail");
				mphoto = mphoto==null? dbmphoto :mphoto;
				String mbirthStr = mRequest.getParameter("mbirth");
				Date mbirth = null;
				if(!mbirthStr.equals("")) {
					mbirth = Date.valueOf(mbirthStr);
				}
				String maddress =mRequest.getParameter("maddress");
				//db
				MemberDao mDao = MemberDao.getInstance();
				MemberDto mDto = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
				result = mDao.modifyMember(mDto);
				if(result == MemberDao.SUCCESS) {
					HttpSession Session = request.getSession();
					request.setAttribute("member", mDto);
					request.setAttribute("modifyResult", "회원정보 수정 성공");
				}else{
					request.setAttribute("modifyErrorMsg", "회원정보 수정 실패(정보가 길거나mid check)");
				}
				
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}//try catch
		File serverFile = new File(path + "/" + mphoto);
		if(serverFile.exists() && !mphoto.equals("NOIMG.JPG") && result == MemberDao.SUCCESS) {
			InputStream is = null;
			OutputStream os = null;
			try{
				is = new FileInputStream(serverFile); // 서버에 업로드된 파일
				os = new FileOutputStream("C:/Webpro/source/06_jsp/ch18_mvcMember/WebContent/memberPhotoUp/" +mphoto); // 소스폴더로 복사될 파일
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
				}
			}//try-catch
		}
	}//execute
} //class
