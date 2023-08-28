package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//C:\Webpro\DownLoad\01_java/bts_7.mp4
public class Ex04_filecopyStep2 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); //1970.1.1���� ���۽��������� �и�����
		//file copy ����
		InputStream is =null;
		OutputStream os =null;
		try {
		int cnt=0;
		is = new FileInputStream("C:/Webpro/DownLoad/01_java/bts_7.mp4");
		os = new FileOutputStream("C:/Webpro/DownLoad/01_java/bts_copy.mp4");
		while(true) {
			int i = is.read();//read
			if(i==-1) break;
			os.write(i);//write
			cnt++;
			if(cnt%1000000==0) {
				System.out.println(cnt+ "/7,460,545 : "+ (int)(cnt/7460545.0*100)+"% ����");

			
			}
		}
		System.out.println(cnt+"�� while�� �����Ͽ� ���缺��");
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(os!=null)os.close();
				if(is!=null)is.close();	
			}catch (IOException e) {
				System.out.println();
		}
		long end = System.currentTimeMillis();//1970.1.1 ���� �����½��������� �и�����
		System.out.println((end-start)/1000.0+"�и��� �ɸ�");
		
		}
	}
}
