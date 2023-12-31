package com.lec.ch12.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Service
public class FileUpService {
	private static final Logger Logger = LoggerFactory.getLogger(FileUpService.class);
	public boolean fileUp(MultipartHttpServletRequest mRequest, ModelAndView mav) {
		boolean isUpload = false;
		// mRequest에 들어온 파일을 서버에 저장(같은 파일명이면 파일명 변경) -> 소스폴더로 복사
		String uploadPath = mRequest.getRealPath("upload/");
		String backupPath = "C:/Webpro/source/09_spring/ch12_fileupload/src/main/webapp/upload/";
		String[] fileNames = new String[3]; // {null, null, null} 
		int i = 0;
		Iterator<String> params = mRequest.getFileNames(); // file1, file2, file3
		while(params.hasNext()) {
			String param = params.next();
			System.out.println(i + "번째 파라미터 이름 : " + param);
			MultipartFile mFile = mRequest.getFile(param); // 파라미터의 파일 객체
			fileNames[i] = mFile.getOriginalFilename(); // 업로그한 파일명
			System.out.println(fileNames[i]==null ? "널" : 
					fileNames[i].equals("")? "첨부안해서 빈스트링":"첨부한파일이름은 "+fileNames[i]);
			// 첨부 여부
			if(fileNames[i]!=null && !fileNames[i].equals("")) {
				// 첨부함
				if(new File(uploadPath + fileNames[i]).exists()) {
					// 첨부파일과 같은 이름의 파일이 서버에 존재 : 현재밀리세컨+파일이름
					fileNames[i] = System.currentTimeMillis() + fileNames[i];
				}// 중복된 파일명 변경
				try {
					mFile.transferTo(new File(uploadPath + fileNames[i]));// 서버에 파일 저장
					System.out.println("서버에 저장된 파일 : " + uploadPath + fileNames[i]);
					System.out.println("복사될 파일 : " + backupPath + fileNames[i]);
					isUpload = filecopy(uploadPath+fileNames[i], backupPath+fileNames[i]);
				} catch (IOException e) {
					Logger.error(e.getMessage());
				} 
			}//if
			i++;
		}//while
		mav.addObject("fileNames", fileNames);
		return isUpload;
	}

	private boolean filecopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		//복사
		InputStream  is = null;
		OutputStream os = null;
		try {
			File file = new File(serverFile);
			is = new FileInputStream(file);
			os = new FileOutputStream(backupFile);
			byte[] bs = new byte[(int)file.length()];
			while(true) {
				int mReadBytes = is.read(bs);
				if(mReadBytes == -1) break;
				os.write(bs,0,mReadBytes);
			}
			isCopy = true;
		}catch (IOException e) {
			Logger.error(e.getMessage());
		}finally {
			try {
				if(is!=null) is.close();
				if(os!=null) os.close();
			}catch (IOException e) {
				Logger.error(e.getMessage());
			}
		}
		return isCopy;
	}
}















