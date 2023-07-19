package com.lec.ex4_printWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
// printWriter : OutputStream�� �⺻��Ʈ������ �ϴ� ������Ʈ������ ���(1)
// printWriter : Writer�� �⺻��Ʈ������ �ϴ� ���� ��Ʈ������ ���(2)
// printWrtier ȥ�� �⺻��Ʈ��ó�� ���(3)
public class Ex {
	public static void main(String[] args) {
		OutputStream os     = null;
		Writer       writer = null;
		PrintWriter  printWriter = null;
		try {
			// 1. PrintWriter : OutputStream�� ���� ��Ʈ��
//			os = new FileOutputStream("txtFile/outTest.txt", true); // append
//			printWriter = new PrintWriter(os);
			// 2. PrintWriter : Writer�� ������Ʈ��
//			writer = new FileWriter("txtFile/outTest.txt", true); // append
//			printWriter = new PrintWriter(writer);
			// 3. PrintWriter�� �⺻ ��Ʈ��ó�� ���
			printWriter = new PrintWriter("txtFile/outTest.txt"); // append�Ұ�
			// �ܼ� �� ���� ���
			System.out.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			printWriter.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			System.out.print("print�� �ڵ������� �ȵǿ�. �׷��� �����߰�\n");
			printWriter.print("print�� �ڵ������� �ȵǿ�. �׷��� �����߰�\n");
			System.out.printf("%s %3d %3d %5.1f\n", "ȫ�浿", 100, 100, 100.0);
			printWriter.printf("%s %3d %3d %5.1f\n", "ȫ�浿", 100, 100, 100.0);
			System.out.printf("%s %3d %3d %5.1f\n", "�ű浿", 90, 91, 90.5);
			printWriter.printf("%s %3d %3d %5.1f\n", "�ű浿", 90, 91, 90.5);
			System.out.printf("%s %3d %3d %5.1f\n", "�ڱ浿", 95, 97, 96.0);
			printWriter.printf("%s %3d %3d %5.1f\n", "�ڱ浿", 95, 97, 96.0);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(printWriter!= null) printWriter.close();
				//if(os         != null) os.close();
				//if(writer     != null) writer.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}//close
		}//try��
	}//main
}