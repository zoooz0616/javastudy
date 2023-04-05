package ch04.sec04;

public class Practice {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7,8,9};//배열
		//arr모든 값 더하려면
		int arrSum=0;
		for (int j = 0; j < arr.length; j++) {
			arrSum+=arr[j];
		}
		System.out.println(arrSum);
		
		int arrSum2=0;
		for (int data : arr) {
			arrSum2+=data;
		}
		System.out.println(arrSum2);
	}

}
