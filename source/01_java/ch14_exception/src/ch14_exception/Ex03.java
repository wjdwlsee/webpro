package ch14_exception;

public class Ex03 {
	public static void main(String[] args) {
		int[]arr ={0,1,2};
		for(int idx=0; idx<=arr.length ; idx++) {
			try {
			System.out.println("arr[" + idx + "]=" +arr[idx]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("���� �޼��� :" + e.getMessage());
			}finally {
			 System.out.println("try�� �����Ŀ���, catch �� �����Ŀ��� ����Ǵ� ��");
			}
			System.out.println("------------------");
			}
		}

	}

