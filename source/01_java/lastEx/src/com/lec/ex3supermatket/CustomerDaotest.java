package com.lec.ex3supermatket;

import java.util.ArrayList;

public class CustomerDaotest {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		int result;
		ArrayList<CustomerDto> customers;
		System.out.println("1. 회원가입 테스트");
//		String ctel = "010-3333-5555"; String cname = "허길아";
//		result = dao.insertCustomer(ctel, cname);
//		System.out.println(result == CustomerDao.SUCCESS ?
//				cname+ "님 회원가입 감사. 포인트 1000점 부여" : cname+ "님 회원가입 실패");
		System.out.println("2.전화번호 검색 테스트");
		String serchTel = "9999" ;
		customers = dao.ctelGetCustomers(serchTel);
		if(customers.isEmpty()) {
			System.out.println(serchTel + "전화번호로 검색된 고객이 없습니다");
		}else {
			System.out.println("아이디\t전화\t이름\t포인트\t구매누적액\t고객레벨\t레벌업을 위한 추천 구매액");
			for(CustomerDto customer : customers) {
				System.out.println(customer);
			}
		}
		System.out.println("3.물품구매");
		int cid = 4;
		if(dao.getCustomer(cid)!=null) {
			int price = 100;
			result = dao.buy(cid, price); //cid 고객이 price원 물품구매
			if(result == CustomerDao.SUCCESS) {
				System.out.println("물품 구매 감사합니다. 고객님의 장보가 아래와 같이 업테이트 되었습니다");
				System.out.println("아이디\t핸드폰번호\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 추천 추천구매액");
				System.out.println(dao.getCustomer(cid));
			}
		}else {
			System.out.println(cid + "는 유효하지 않은 id라서 구매 불가");
		}
//		System.out.println("4번.레벨별 출력");
//		customers = dao.levelNameGetCustomers("gold");
//		if(customers.size()==0) {
//			System.out.println("해당레벨이 없습니다");
//		}else {
//			System.out.println("아이디\t핸드폰번호\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 추천 추천구매액");
//			for(CustomerDto customer : customers) {
//				System.out.println(customer);
//			}
//		}
//		System.out.println("5번.레벨별 출력");
//		customers =dao.GetCustomers();
//		if(customers.size()==0) {
//			System.out.println("해당레벨이 없습니다");
//		}else {
//			System.out.println("아이디\t핸드폰번호\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 추천 추천 구매액");
//			for(CustomerDto customer : customers) {
//				System.out.println(customer);
//				System.out.println(customer);
//			}
//		}
//		System.out.println("6.회원탈퇴");
//		result = dao.deleteCustomer("010-9999-9999");
//		System.out.println(result == CustomerDao.SUCCESS ? "삭제성공" :"유요한 번호가 아닙니다");
		
	}
}