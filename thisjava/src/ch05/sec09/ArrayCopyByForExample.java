package ch05.sec09;

public class ArrayCopyByForExample {

	public static void main(String[] args) {
		int[] oldintArray = {1,2,3};
		int[] newintArray=new int[5];
		
		for (int i = 0; i < oldintArray.length; i++) {
			newintArray[i]=oldintArray[i];
		}
		
		for (int i = 0; i < newintArray.length; i++) {
			System.out.print(newintArray[i]+" ");
		}
	}

}
