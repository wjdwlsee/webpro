package com.lec.ex3person_dtoDao;

import java.util.ArrayList;
import java.util.Scanner;

public class personMng {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		Scanner scanner = new Scanner(System.in);
		String fn ;
		ArrayList<String> jobs = dao.jnameList();
		//System.out.println(jobs);
		do {
			System.out.print("1입력 :||2.직업별출력 :||3.전체출력||그외 : 종료");
			fn = scanner.next();
			switch(fn) {
			case "1" : //이름.직업명,국,영,수 입력받아 insertPerson 호출
				System.out.print("입력할 이름은?");
				String pname = scanner.next();
				System.out.print("입력할 직업명" + jobs + "은 ?");
				String jname = scanner.next();
				System.out.print("입력할 국어점수는 ?");
				int kor = scanner.nextInt();
				System.out.print("입력할 영어점수는 ?");
				int eng = scanner.nextInt();
				System.out.print("입력할 수학점수는 ?");
				int mat = scanner.nextInt();
				dao.insertPerson(new PersonDto(pname, jname, kor, eng, mat));
				System.out.print("1번 가능");
				break;
			case "2" :
				System.out.print("출력하고자 하는 직업군" +jobs + "은?");
				jname = scanner.next();
				ArrayList<PersonDto> dtos = dao.selectJname(jname);
				if(dtos.isEmpty()) {
					System.out.println(jname +"직업군의 사람이 없습니다");
				}else {
					for(PersonDto dto : dtos) {
						System.out.println(dto);
					}//for
				}//if
				break;
				
			case "3" :
				dtos = dao.selectAll();
				if(dtos.size()==0) {
					System.out.println("등록된 사람이 없습니다.");
				}else {
					for(int idx = 0; idx<dtos.size() ; idx++) {
						System.out.println(dtos.get(idx));
					}
					System.out.println("총" + dtos.size()+"명");
				}
			}
		}while(fn.equals("1")||fn.equals("2")||fn.equals("3"));
		System.out.println("bye");
	}
}
