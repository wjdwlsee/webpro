package com.lec.ex2_ReaderWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.filechooser.FileFilter;

public class Ex02_Filewrite {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("src/com/lec/ex2_ReaderWriter/outTest.txt", true);
//			char[] msg = { '��', '��', '!', ' ', 'H', 'i', '\n' };
//			for (char m : msg) {
//				writer.write(m);
//			}
			String msg ="�ȳ�! Hi\n�帶�� �ǰ������ϼ���\n" ;
			writer.write(msg);
			msg ="�����ֱ��� ��µ� .��� �ǼۻǼ� �Ƿη�";
					writer.write(msg);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
