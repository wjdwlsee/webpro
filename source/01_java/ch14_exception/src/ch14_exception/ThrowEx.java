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
		System.out.println("actionC 전반부");
		actionB();
		System.out.println("actionC 후반부");
	}
	private void actionB() throws RuntimeException {
		System.out.println("actionB 전반부");
		try {
			actionA();
		}catch(ArrayIndexOutOfBoundsException e) {
		 System.out.println(e.getMessage());
		}
			
			System.out.println("actionB 후반부");
	}

	private void actionA() throws ArrayIndexOutOfBoundsException {
		System.out.println("actionB 전반부");
		int[]arr ={0,1};
		System.out.println(arr[2]);
		System.out.println("actionA 후반부");
		
	}
		
	}
