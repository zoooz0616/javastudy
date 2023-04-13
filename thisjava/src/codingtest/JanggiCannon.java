package codingtest;

import java.util.Arrays;
import java.util.Scanner;

import javax.naming.directory.SearchResult;

import ch01.sec12.Calculator;

public class JanggiCannon {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//testcase 수
		int testcase = scanner.nextInt();
		
		int n = scanner.nextInt();
		int xindex=0;
		int yindex=0;
		
		for (int i = 0; i < testcase; i++) {
			scanner.nextLine();
			String[][] array = new String[n][n];
			for (int j = 0; j < n; j++) {
				String data = scanner.nextLine();
				array[j]=data.split(" ");
				for (int k = 0; k < n; k++) {
					if (array[j][k].equals("X")){
						xindex=j;
						yindex=k;
					}
				}
			}
			
			int result = 0;
			int hh=0;
			for (int j = yindex+1; j < n; j++) {
				switch (array[xindex][j].toString()) {
				case "L": {
					continue;
				}
				case "Y":{
					break;
				}
				case "H":{
					if (hh==1) {
						result++;
						hh=0;
					}else {
						hh++;
					}
					break;
				}
				default:
					
				}	
			}
			System.out.println("#"+(i+1)+" "+result);
			hh=0;
			for (int j = yindex-1; j >=0 ; j--) {
				switch (array[xindex][j].toString()) {
				case "L": {
					continue;
				}
				case "Y":{
					break;
				}
				case "H":{
					if (hh==1) {
						result++;
						hh=0;
					}else {
						hh++;
					}
					break;
				}
				default:
					
				}	
			}
			
			System.out.println("#"+(i+1)+" "+result);
			
			hh=0;
			for (int j = xindex+1; j <n ; j++) {
				switch (array[j][yindex].toString()) {
				case "L": {
					continue;
				}
				case "Y":{
					break;
				}
				case "H":{
					if (hh==1) {
						result++;
						hh=0;
					}else {
						hh++;
					}
					break;
				}
				default:
					
				}	
			}
			
			System.out.println("#"+(i+1)+" "+result);
			
			hh=0;
			for (int j = xindex-1; j >=0 ; j--) {
				System.out.println(array[j][yindex].charAt(0));
				switch (array[j][yindex].toString()) {
				case "L": {
					continue;
				}
				case "Y":{
					break;
				}
				case "H":{
					if (hh==1) {
						result++;
						hh=0;
					}else {
						hh++;
					}
					break;
				}
				default:
					
				}	
			}
			System.out.println("#"+(i+1)+" "+result);
		}
		
	}
	
//	public static int searchxindex(String[][] array, int n) {
//		int xindex=0;
//		int yindex=0;
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if (array[i][j].equals('X')) {
//					xindex=i;
//					yindex=j;
//				}
//			}
//			
//		}
//		return xindex;
//	}
//	
//	public static int searchyindex(String[][] array, int n) {
//		int xindex=0;
//		int yindex=0;
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if (array[i][j].equals('X')) {
//					xindex=i;
//					yindex=j;
//				}
//			}
//			
//		}
//		return yindex;
//	}
//	
//	
//	public static int calresult(String[][] array,int n) {
//		int result=0;
//		int x=searchxindex(array, n);
//		int y=searchyindex(array, n);
//		
//		
//		
//		
//		
//		result+=calresult(array,n);
//		
//		return result;
//	}

}
