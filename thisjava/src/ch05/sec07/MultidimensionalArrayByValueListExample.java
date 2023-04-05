package ch05.sec07;

public class MultidimensionalArrayByValueListExample {

	public static void main(String[] args) {
		int[][] scores= {
				{80,90,96},
				{76,88}
		};
		
		System.out.println("1번째 배열의 길이(반의 수): "+scores.length);
		System.out.println("2차원 배열 길이(첫 번째 반의 학생 수 : "+scores[0].length);
		System.out.println("2차원 배열 길이(두 번째 반의 학생 수 : "+scores[1].length);
		
		System.out.println("scores[0][2]: "+scores[0][2]);
		System.out.println("scores[1][1]: "+scores[1][1]);
		
		int sum1=0;
		for (int i = 0; i < scores[0].length; i++) {
			sum1+=scores[0][i];
		}
		System.out.println("첫 번째 반의 평균 점수: "+(double)sum1/scores[0].length);
		
		int sum2=0;
		for (int i = 0; i < scores[1].length; i++) {
			sum2+=scores[1][i];
		}
		System.out.println("첫 번째 반의 평균 점수: "+(double)sum2/scores[1].length);
		
		System.out.println("전체 학생의 평균 점수: "+ (double)(sum1+sum2)/(scores[0].length+scores[1].length));
	}

}
