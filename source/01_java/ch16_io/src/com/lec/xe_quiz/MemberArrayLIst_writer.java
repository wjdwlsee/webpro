package com.lec.xe_quiz;

import java.util.Date;
import java.util.GregorianCalendar;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberArrayLIst_writer {

	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner scanner = new Scanner(System.in);
		String answer, name, tel, address, birthstr ;
		Date birth;
		while(true){
			System.out.println("ȸ�������� �ϼ��� (������ ������ N)");
			if(scanner.next().equalsIgnoreCase("n")) break;
			System.out.println("�̸�?");
			name= scanner.next();
			System.out.println("��ȭ��ȣ?");
			tel= scanner.next();
			System.out.println("����?");//"1998-07-19"
			birthstr= scanner.next();
			birth = toDatetodayisBirthDaycheck(name, birthstr);
			System.out.println("�ּ�?"); 
			scanner.nextLine(); // 
			address = scanner.nextLine();
			members.add(new Member(name, tel, address, birth));
		}
		//members�� ������ �ܼ����&���� ���(outputStream)
		Writer writer = null;
		try {
			writer = new FileWriter("src\\com\\lec\\xe_quiz.txt",true);
			for(Member member : members) {
				writer.write(member.toString());
			}
		
		}catch(IOException e) {
			System.out.println("������ ��ã�� ���ܸ޼���:"+e.getMessage());
		} finally {
			try {
				if(writer!=null) writer.close();
			}catch(IOException e) {
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
			
			String todayStr = sdf.format(today);
			String resultstr = sdf.format(result);
			resultstr =birthstr.substring(birthstr.indexOf("-")+1);
			if(todayStr.equals(resultstr)) {
				System.out.println(name +"�� ������ �����̽ñ���");
			}
		} else {
			System.out.println("������� ������ �ùٸ��� �ʾ� �Էµ��� �ʾҽ��ϴ�.");
		}
		return result;
		
	
	}// toDate
}
