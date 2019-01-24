package snengggg_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class expert_2115 {

	static int N, M, C;
	static int[][] honey;
	static int[][] honeyCost;
	static int[] basket;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		honey = new int[N][N];
		honeyCost = new int[N][N - M + 1];
		basket = new int[M];

		findHoneyCost();

	}

	static void findHoneyCost() {

		// int maxCost = -1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				honeyCost[i][j] = maxHoney(i, j);
			}
		}

	}

	static int maxHoney(int sy, int sx) {

		int curCost = 0;
		int maxCost;
		
		for(int i = 0; i < M; i++) {
			basket[i] = honey[sy][sx+i]; 
		}
		
		for(int i = 1; i <= M; i++) {
			
			
			
		}
		
		



		return 0;
	}
	
	

}
