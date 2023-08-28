package com.lec.ex3supermatket;

import java.util.ArrayList;
import java.util.Scanner;

public class Supermarketmng {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		Scanner scanner = new Scanner(System.in);
		String fn;
		ArrayList<CustomerDto> customers;
		do {
			System.out.print("1:회원가입 , 2:폰검색 ,3:물품구입, 4:레벨별출력, 5:전체출력, 6:회원탈퇴 , 그외:종료");
			fn = scanner.next();
			switch(fn) {
			case "1" :
				System.out.println("가입할 회원 핸드폰 번호 ?");
				String ctel = scanner.next();
				System.out.println("가입할 이름은 ?");
				String cname = scanner.next();
				int result = dao.insertCustomer(ctel, cname);
				System.out.println(result == CustomerDao.SUCCESS ? "가입성공" : "가입실패");
				break;
			case "2" :
				System.out.println("검색할 전화번호 뒷4자리나 전화번호 전쳬 :");
				String serchTel = scanner.next();
				customers = dao.ctelGetCustomers(serchTel);
				if(customers.isEmpty()) {
					System.out.println(serchTel + "전화번호로 검ㅅ개된 고객이 없습니다. 회원가입하세여");
				}else {
					System.out.println("아이디\t핸드폰번호\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 추천 추천 구매액");
					for(CustomerDto customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "3" :
				System.out.println("구매할 고객 아이디번호(아이디가 잘못 입력된 경우 구매불가) ?");
				int cid  = scanner.nextInt();
				if(dao.getCustomer(cid) != null) {//구매ㄱ
					System.out.println("구매금액 ? ");
					int price = scanner.nextInt();
					result = dao.buy(cid, price) ;
					if(result == CustomerDao.SUCCESS) {
						System.out.println("구매감사합니다 " + price + "원 구매후 ");
						System.out.println("아이디\t핸드폰번호\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 추천 추천 구매액");
						System.out.println(dao.getCustomer(cid));
					}
				}else {
					System.out.println(cid +" 는 유요한 고객 아디가 아닙니다");
					}
				break;
			case "4" :
				System.out.println("검색하고자 하는 레벨명은" + dao.getLevelNames()+"은?");
				String levelName = scanner.next();
				customers =dao.levelNameGetCustomers(levelName) ;
				if(customers.isEmpty()) {
					System.out.println(levelName + "고객은 검색되지 않습니다");
				}else {
					System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추천 구매액");
					for(CustomerDto customer : customers) {
						System.out.println(customer);
					}
					System.out.println("총" +customers.size()+ "명");
				}
				break;
			case "5" :
				customers = dao.GetCustomers();
				if(customers.isEmpty()) {
					System.out.println("고객이 검색되지 않습니다");
				}else {
					System.out.println("아이디\t핸드폰번호\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추천 구매액");
					for(CustomerDto customer : customers) {
						System.out.println(customer);
					}
					System.out.println("총 " + customers.size() + "명");
				}
				
				break;
			case "6" :
				System.out.println("탈퇴할 전화번호는 ? ");
				ctel = scanner.next();
				result = dao.deleteCustomer(ctel) ;
				System.out.println(result == CustomerDao.SUCCESS? "입력완력":"유효한아님");
				break;
			}
			}while(fn.equals("1") || fn.equals("2") ||fn.equals("3")||fn.equals("4")||fn.equals("5")||fn.equals("6")); 
			System.out.println("BYE");
		}
	}

