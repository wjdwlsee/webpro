package cm.lec.test;

public class PtogramingLan {
	private static int max;
	private Object name;

	public static void main(String[] args) {
		int[]arr = {76,45,34,89,100,50,90,93};
		int tot = 0;
		
	
			 for(int temp : arr) {
					tot += temp;
				}
				System.out.println("총점은 "+tot);
			
			double avg = tot/8.0 ;
			System.out.println(" 평균은 " + avg);
		
			int   min=0;
			int   max=0;	
			for(int j=0 ; j<arr.length; j++) {
				if(arr[j] < min) {
					min = arr[j];
					
				}
				if(arr[j] > max) {
					max = arr[j];
					max=j;
				
				}

				System.out.println("최고점 : " + arr[max]);
			System.out.println("최저점 : " + arr[min]);
		
	}		
			
	}			
}
