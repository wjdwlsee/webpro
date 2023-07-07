package com.lec.ex03_point;
//x,y / infopoint (좌표 x,y)setter&getter 상속받ㅇ듬
//Point3D p =new Point3D(1,2,3);p.infoPrint()



public class Point3D extends Point {
	private int z;
	public Point3D(int z ,int y, int x) {
		System.out.println("매개변수 있는 Point3D생성자 함수-x,y,z초기화");
		setX(x); //this.x =x; protected 만 가능
		setY(y);
		this.z = z;
	}
	
	@Override
	public void infopoint() {
		System.out.println("좌표(x,y,z) : " + getX() + "," + getY() + "," + z);
		
	}
//	public void infoPrint3d() {
//		System.out.println("좌표(x,y,z) : " + getX() + "," + getY() + "," + z);
	}