package com.lec.ex03_point.copy;
//x,y / infopoint (��ǥ x,y)setter&getter ��ӹޤ���
//Point3D p =new Point3D(1,2,3);p.infoPrint()



public class Point3D extends Point {
	private int z;
	public Point3D(int z ,int y, int x) {
		super(y,x);
		this.z = z;
		System.out.println("�Ű����� �ִ� Point3D������ �Լ�-x,y,z�ʱ�ȭ");
		
			
//		setX(x); //this.x =x; protected �� ����
//		setY(y);
		
	}
	
	@Override
	public void infopoint() {
		System.out.println("��ǥ(x,y,z) : " + getX() + "," + getY() + "," + z);
		
	}
//	public void infoPrint3d() {
//		System.out.println("��ǥ(x,y,z) : " + getX() + "," + getY() + "," + z);
}