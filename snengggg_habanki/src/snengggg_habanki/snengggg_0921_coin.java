package snengggg_habanki;

import java.util.Scanner;

public class snengggg_0921_coin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Scanner input = new Scanner(System.in);
	int N = input.nextInt();
	int K = input.nextInt();
	
	int[] coin = new int[N];
	int[] dp = new int[K+1];
	
	for(int i = 0; i<N; i++) {
		coin[i] = input.nextInt();
	}
	
	dp[0] = 1;
	
	for(int i = 0; i < N; i++) {
		for(int j = 1; j <= K; j++) {
			if(j - coin[i]>= 0) {
				dp[j] = dp[j] + dp[j-coin[i]];
			}
		}
	}
	
	System.out.println(dp[K]);	
	
	
	

	}

}
