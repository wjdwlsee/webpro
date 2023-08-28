package com.lec.ex3_butteredReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//1.��Ʈ�� ��ü ����(FileReader -> butterReader) ->�����͸� �д¤���(bufferedReader)
//2.�����͸� �д´� (butteredReader�� ���� ���پ�)
//3.��Ʈ���� �ݴ´�(butteredReader-> FileReader)
public class Ex01 {
	public static void main(String[] args) {
		Reader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("txtFile/inTest.txt");// 1.�⺻��Ʈ���� ����
			br = new BufferedReader(reader); // ���� ��Ʈ���� �⺻��Ʈ���� ���� ����
			while (true) { // 2.�����͸� ���پ� �д´� (br,readLine())
				String linedate = br.readLine();
				if (linedate == null)
					break;
				System.out.println(linedate);
			}
			System.out.println("= =���� �Է� �� ==");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(br!=null) br.close(); //��Ʈ���� ������� ���� buffer����
				if(reader!=null) reader.close();
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
