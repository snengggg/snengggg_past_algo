package snengggg_0412;

import java.util.Scanner;

public class Chief_2 {

	static final int MAX_N = 16;
	static int [][] recipe;
	static boolean Flag[];
	static int seek;
	static int ansMin;

	
	static int abs(int a, int b)
	{
		return a > b ? a-b : b-a;
	}
	
	static void masterChief(int N, int seek, int needA) {
		int SumA = 0;
		int SumB = 0;
		
		if(N == seek) {
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=N; j++) {
					if(i != j){
						if(Flag[i-1] && Flag[j-1]) {
							SumA = SumA + recipe[i][j];
						}else if(!Flag[i-1] && !Flag[j-1]) {
							SumB = SumB + recipe[i][j];
						}
					}
				}
			}
			ansMin = Math.min(ansMin, abs(SumA,SumB));
			return;
		}
		
		if(needA > 0) {
			Flag[seek] = true;
			masterChief(N, seek+1, needA-1);
			
			Flag[seek] = false;
		}
		masterChief(N, seek+1, needA);
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			recipe = new int [N+1][N+1];
			Flag = new boolean[N+1];
			ansMin = 999999;
			seek = 0;
		
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					recipe[i][j] = sc.nextInt();
				}
			}
		
			masterChief(N, seek, N/2);
		
		
			System.out.println("#" + testcase + " " + ansMin);
		

		}
	}

}
