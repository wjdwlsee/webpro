package com.lec.xe_quiz;

import java.util.Date;
import java.util.GregorianCalendar;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberArrayLIst_outputstream__ {

	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner scanner = new Scanner(System.in);
		String answer, name, tel, address, birthstr;
		Date birth;
		while (true) {
			System.out.print("ȸ�������� �ϼ��� (������ ������ N)");
			if (scanner.next().equalsIgnoreCase("n"))
				break;
			System.out.println("�̸�?");
			name = scanner.next();
			System.out.println("��ȭ��ȣ?");
			tel = scanner.next();

			System.out.println("����(yyyy-mm-dd)?");// "1998-07-19"
			birthstr = scanner.next(); // "1998-07-19-10-30"/"1998-07-19"/"1998"/��Ʈ��/19980719
			//birth = toDate(birthstr);
			birth = toDatetodayisBirthDaycheck(name, birthstr);
			System.out.println("�ּ�?");
			scanner.nextLine();
			address = scanner.next();
			members.add(new Member(name, tel, address, birth));
		}
		// members�� ������ �ܼ����&���� ���(outputStream)
		OutputStream os = null;
		try {
			os = new FileOutputStream("src\\com\\lec\\xe_quiz.txt", true);
			for (Member member : members) {
				System.out.println(member);
				os.write(member.toString().getBytes());
			}
			String msg = "          .... ����" + members.size() + "�� ����";
			System.out.println(msg);
		} catch (IOException e) {
			System.out.println("������ ��ã�� ���ܸ޼���:" + e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}


	private static Date toDatetodayisBirthDaycheck(String name, String birthstr) {
		// �Ű������� ���� "1995-01-01"�� ��¥ ��Ʈ���� Date������ ��ȯ�Ͽ� return
		Date result = null; // �߸� ������ �ʱ�ȭ
		StringTokenizer tokenizer = new StringTokenizer(birthstr, "-");
		if (tokenizer.countTokens() == 3) {
			// ������� ����� �Է�
			int year = Integer.parseInt(tokenizer.nextToken());
			int month = Integer.parseInt(tokenizer.nextToken()) - 1;
			int day = Integer.parseInt(tokenizer.nextToken());

			result = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			System.out.println("��������");
	
			String todayStr = sdf.format(today); // "07-19"
			String resultStr = sdf.format(result); // "01-01" �Ʒ��� ����� �� �� �ϳ�
			resultStr = birthstr.substring(birthstr.indexOf("-") + 1);
			if(todayStr.equals(resultStr)) {
				System.out.println(name + "�� ������ �����̽ñ��� . ���ϵ���� �ڡڡڡڡڡ�");
			}
		} else {
			System.out.println("������� ������ �ùٸ��� �ʾ� �Էµ��� �ʾҽ��ϴ�.");
		}
		return result;

	}

}	