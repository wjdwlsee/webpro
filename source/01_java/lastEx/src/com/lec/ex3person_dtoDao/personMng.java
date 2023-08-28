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
			System.out.print("1�Է� :||2.��������� :||3.��ü���||�׿� : ����");
			fn = scanner.next();
			switch(fn) {
			case "1" : //�̸�.������,��,��,�� �Է¹޾� insertPerson ȣ��
				System.out.print("�Է��� �̸���?");
				String pname = scanner.next();
				System.out.print("�Է��� ������" + jobs + "�� ?");
				String jname = scanner.next();
				System.out.print("�Է��� ���������� ?");
				int kor = scanner.nextInt();
				System.out.print("�Է��� ���������� ?");
				int eng = scanner.nextInt();
				System.out.print("�Է��� ���������� ?");
				int mat = scanner.nextInt();
				dao.insertPerson(new PersonDto(pname, jname, kor, eng, mat));
				System.out.print("1�� ����");
				break;
			case "2" :
				System.out.print("����ϰ��� �ϴ� ������" +jobs + "��?");
				jname = scanner.next();
				ArrayList<PersonDto> dtos = dao.selectJname(jname);
				if(dtos.isEmpty()) {
					System.out.println(jname +"�������� ����� �����ϴ�");
				}else {
					for(PersonDto dto : dtos) {
						System.out.println(dto);
					}//for
				}//if
				break;
				
			case "3" :
				dtos = dao.selectAll();
				if(dtos.size()==0) {
					System.out.println("��ϵ� ����� �����ϴ�.");
				}else {
					for(int idx = 0; idx<dtos.size() ; idx++) {
						System.out.println(dtos.get(idx));
					}
					System.out.println("��" + dtos.size()+"��");
				}
			}
		}while(fn.equals("1")||fn.equals("2")||fn.equals("3"));
		System.out.println("bye");
	}
}
