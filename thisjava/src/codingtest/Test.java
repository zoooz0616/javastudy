package codingtest;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cnt = scanner.nextInt(); 
		for(int i=0; i<cnt; i++) {
			int N = scanner.nextInt();
			scanner.nextLine();
			String[][] array = new String[N][N];
			for(int line=0; line<N; line++) {
				String data = scanner.nextLine();
				array[line] = data.split(" ");
			}
//			System.out.println(Arrays.deepToString(array));

			int result = 0;  // 먹은 알의 수
			int px = -1; //X가 있는  x좌표
			int py = -1; //X가 있는  y좌표
			outer: for(int y=0; y<N; y++) { // X의 위치를 찾음
				for(int x=0; x<N; x++) {
					if(array[y][x].equals("X")) {
						px = x;
						py = y;
						break outer;
					}
				}
			}
			boolean isJumped = false; //처음 H를 만나면 true
			
			// 오른쪽으로 찾아가면서...
			for(int x=px+1; x<N; x++) {
				if(array[py][x].equals("L")) continue;
				if(array[py][x].equals("Y")) break;
				if(array[py][x].equals("H")) {
					if(isJumped) {
						result++;
						break;
					}else {
						isJumped = true;
					}
				}
			}			
			// 왼쪽으로 찾아가면서...
			isJumped = false;
			for(int x=px-1; x>=0; x--) {
				if(array[py][x].equals("L")) continue;
				if(array[py][x].equals("Y")) break;
				if(array[py][x].equals("H")) {
					if(isJumped) {
						result++;
						break;
					}else {
						isJumped = true;
					}
				}
			}
			
			// 아래쪽으로 찾아가면서...
			isJumped = false;
			for(int y=py+1; y<N; y++) {
				if(array[y][px].equals("L")) continue;
				if(array[y][px].equals("Y")) break;
				if(array[y][px].equals("H")) {
					if(isJumped) {
						result++;
						break;
					}else {
						isJumped = true;
					}
				}
			}
			
			// 위쪽으로 찾아가면서...
			isJumped = false;
			for(int y=py-1; y>=0; y--) {
				if(array[y][px].equals("L")) continue;
				if(array[y][px].equals("Y")) break;
				if(array[y][px].equals("H")) {
					if(isJumped) {
						result++;
						break;
					}else {
						isJumped = true;
					}
				}
			}
			System.out.println("#"+(i+1) + " " + result);
		}
		scanner.close();
	}
}
