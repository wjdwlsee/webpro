package com.lec.ex3supermatket;

import java.util.ArrayList;

public class CustomerDaotest {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		int result;
		ArrayList<CustomerDto> customers;
		System.out.println("1. ȸ������ �׽�Ʈ");
//		String ctel = "010-3333-5555"; String cname = "����";
//		result = dao.insertCustomer(ctel, cname);
//		System.out.println(result == CustomerDao.SUCCESS ?
//				cname+ "�� ȸ������ ����. ����Ʈ 1000�� �ο�" : cname+ "�� ȸ������ ����");
		System.out.println("2.��ȭ��ȣ �˻� �׽�Ʈ");
		String serchTel = "9999" ;
		customers = dao.ctelGetCustomers(serchTel);
		if(customers.isEmpty()) {
			System.out.println(serchTel + "��ȭ��ȣ�� �˻��� ���� �����ϴ�");
		}else {
			System.out.println("���̵�\t��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� ��õ ���ž�");
			for(CustomerDto customer : customers) {
				System.out.println(customer);
			}
		}
		System.out.println("3.��ǰ����");
		int cid = 4;
		if(dao.getCustomer(cid)!=null) {
			int price = 100;
			result = dao.buy(cid, price); //cid ���� price�� ��ǰ����
			if(result == CustomerDao.SUCCESS) {
				System.out.println("��ǰ ���� �����մϴ�. ������ �庸�� �Ʒ��� ���� ������Ʈ �Ǿ����ϴ�");
				System.out.println("���̵�\t�ڵ�����ȣ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ��õ ��õ���ž�");
				System.out.println(dao.getCustomer(cid));
			}
		}else {
			System.out.println(cid + "�� ��ȿ���� ���� id�� ���� �Ұ�");
		}
//		System.out.println("4��.������ ���");
//		customers = dao.levelNameGetCustomers("gold");
//		if(customers.size()==0) {
//			System.out.println("�ش緹���� �����ϴ�");
//		}else {
//			System.out.println("���̵�\t�ڵ�����ȣ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ��õ ��õ���ž�");
//			for(CustomerDto customer : customers) {
//				System.out.println(customer);
//			}
//		}
//		System.out.println("5��.������ ���");
//		customers =dao.GetCustomers();
//		if(customers.size()==0) {
//			System.out.println("�ش緹���� �����ϴ�");
//		}else {
//			System.out.println("���̵�\t�ڵ�����ȣ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ��õ ��õ ���ž�");
//			for(CustomerDto customer : customers) {
//				System.out.println(customer);
//				System.out.println(customer);
//			}
//		}
//		System.out.println("6.ȸ��Ż��");
//		result = dao.deleteCustomer("010-9999-9999");
//		System.out.println(result == CustomerDao.SUCCESS ? "��������" :"������ ��ȣ�� �ƴմϴ�");
		
	}
}