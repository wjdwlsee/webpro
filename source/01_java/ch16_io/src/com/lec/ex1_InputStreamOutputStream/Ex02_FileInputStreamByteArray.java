package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//1.���Ͽ��� 2.�����͸� �д´�(read(byte[])) 3.������ �ݴ´�
public class Ex02_FileInputStreamByteArray {
	public static void main(String[] args) {
		InputStream is =null;
		try {
		is = new FileInputStream("C:/Webpro/source/01_java/ch16_io/txtFIle/inTest.txt"); //�����
		byte[]bs =new byte[10];
		while(true) {
			int readByteCount =is.read(bs);//bs �迭��ŭ �а� ���� byte ���� ����. ������ ���� -1
			if(readByteCount == -1)break;
			for(int i=0; i<readByteCount; i++) {
			System.out.println((char) bs[i]);
				//	System.out.printf("%3d/", bs[i]);
			}
			//System.out.println(); //���� );
		}
		} catch (FileNotFoundException e) {
			System.out.println("���� ��ã��, ���ܸ޼��� :" +e.getMessage());
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
