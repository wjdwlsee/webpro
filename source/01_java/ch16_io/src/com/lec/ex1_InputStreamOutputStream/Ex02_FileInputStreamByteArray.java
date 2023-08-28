package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//1.파일연다 2.데이터를 읽는다(read(byte[])) 3.파일을 닫는다
public class Ex02_FileInputStreamByteArray {
	public static void main(String[] args) {
		InputStream is =null;
		try {
		is = new FileInputStream("C:/Webpro/source/01_java/ch16_io/txtFIle/inTest.txt"); //상대경로
		byte[]bs =new byte[10];
		while(true) {
			int readByteCount =is.read(bs);//bs 배열만큼 읽고 일은 byte 수를 리턴. 파일의 끝은 -1
			if(readByteCount == -1)break;
			for(int i=0; i<readByteCount; i++) {
			System.out.println((char) bs[i]);
				//	System.out.printf("%3d/", bs[i]);
			}
			//System.out.println(); //개행 );
		}
		} catch (FileNotFoundException e) {
			System.out.println("파일 못찾음, 예외메세지 :" +e.getMessage());
		}catch (IOException e) {
		}finally {
			try {
				if(is!=null)is.close();
			}catch(IOException e) {	
				System.out.println(e.getMessage());
		
			}
		}
	}
}
