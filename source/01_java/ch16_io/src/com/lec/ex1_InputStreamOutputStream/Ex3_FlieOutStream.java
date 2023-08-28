package com.lec.ex1_InputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//������ ����(��Ʈ�� ��ü ����) -> ���� ->������ �ݴ´�
public class Ex3_FlieOutStream {
	public static void main(String[] args) {
		OutputStream os =null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true); // true: append 
												// �⺻��(false) : ������ ������ ����. ������ ������ ���      
//			byte[] bs = {'H', 'e', 'l', 'l', 'o', '\n'};
			String msg = "Hi, Java\n01234567\n�ȳ�\n";
			byte[] bs = msg.getBytes(); // ��Ʈ���� byte�迭�� �ٲٴ� �Լ�
//			for(byte b : bs) {
//				os.write(b);
//			}
			os.write(bs);
			System.out.println("���� ��� �Ϸ�");
		} catch (FileNotFoundException e) {
			System.out.println("������ �� ã��. ���� �޼��� : " + e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}//close
		}//try-catch-finally
	}//main
}