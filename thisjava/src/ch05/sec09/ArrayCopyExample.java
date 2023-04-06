package ch05.sec09;

import java.util.Arrays;

public class ArrayCopyExample {

	public static void main(String[] args) {
		
		int[] intArr= {3,5,7,9,11};
		int[] intArr2=intArr;
		
		intArr[0]=300;
		System.out.println(intArr);
		System.out.println(Arrays.toString(intArr));
		System.out.println(Arrays.toString(intArr2));
		
		String[] oldStrArray = {"java", "array", "copy"};
		
		String[] newStrArray = new String[5];
		
		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
		
		for (int i = 0; i < newStrArray.length; i++) {
			System.out.print(newStrArray[i]+",");
		}
	}

}
