package ch14_exception;

import java.awt.Desktop.Action;

public class ThrowEx {
	public ThrowEx() {
		try {
			actionC();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

	private void actionC() throws Exception {
		System.out.println("actionC ���ݺ�");
		actionB();
		System.out.println("actionC �Ĺݺ�");
	}
	private void actionB() throws RuntimeException {
		System.out.println("actionB ���ݺ�");
		try {
			actionA();
		}catch(ArrayIndexOutOfBoundsException e) {
		 System.out.println(e.getMessage());
		}
			
			System.out.println("actionB �Ĺݺ�");
	}

	private void actionA() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionB ���ݺ�");
		int[]arr ={0,1};
		System.out.println(arr[2]);
		System.out.println("actionA �Ĺݺ�");
		
	}
		
	}
