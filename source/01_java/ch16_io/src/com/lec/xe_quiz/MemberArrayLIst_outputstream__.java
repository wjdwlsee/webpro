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
			System.out.print("회원가입을 하세요 (원하지 않으면 N)");
			if (scanner.next().equalsIgnoreCase("n"))
				break;
			System.out.println("이름?");
			name = scanner.next();
			System.out.println("전화번호?");
			tel = scanner.next();

			System.out.println("생일(yyyy-mm-dd)?");// "1998-07-19"
			birthstr = scanner.next(); // "1998-07-19-10-30"/"1998-07-19"/"1998"/빈스트링/19980719
			//birth = toDate(birthstr);
			birth = toDatetodayisBirthDaycheck(name, birthstr);
			System.out.println("주소?");
			scanner.nextLine();
			address = scanner.next();
			members.add(new Member(name, tel, address, birth));
		}
		// members의 내용을 콘솔출력&파일 출력(outputStream)
		OutputStream os = null;
		try {
			os = new FileOutputStream("src\\com\\lec\\xe_quiz.txt", true);
			for (Member member : members) {
				System.out.println(member);
				os.write(member.toString().getBytes());
			}
			String msg = "          .... 이하" + members.size() + "명 가입";
			System.out.println(msg);
		} catch (IOException e) {
			System.out.println("폴더를 못찾음 예외메세지:" + e.getMessage());
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
		// 매개변수로 들어온 "1995-01-01"을 날짜 스트링을 Date형으로 변환하여 return
		Date result = null; // 잘못 넣으면 초기화
		StringTokenizer tokenizer = new StringTokenizer(birthstr, "-");
		if (tokenizer.countTokens() == 3) {
			// 생년월일 제대로 입력
			int year = Integer.parseInt(tokenizer.nextToken());
			int month = Integer.parseInt(tokenizer.nextToken()) - 1;
			int day = Integer.parseInt(tokenizer.nextToken());

			result = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			System.out.println("생일축한");
	
			String todayStr = sdf.format(today); // "07-19"
			String resultStr = sdf.format(result); // "01-01" 아래나 위방법 둘 중 하나
			resultStr = birthstr.substring(birthstr.indexOf("-") + 1);
			if(todayStr.equals(resultStr)) {
				System.out.println(name + "님 오늘이 생일이시군요 . 축하드려요 ★★★★★★");
			}
		} else {
			System.out.println("생년월일 정보가 올바르지 않아 입력되지 않았습니다.");
		}
		return result;

	}

}	