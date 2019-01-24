package snengggg_0412;

import java.util.Scanner;

public class Chief_1 {


	static final int MAX_N = 16;
	static int [][] Recipe = new int[MAX_N][MAX_N];
	static int [][] sumRecipe = new int[MAX_N][MAX_N];
	static int N;
	static int minCost;
	
	static void sumRecipeTotal() {
		for(int i = 1; i < N; i++) {
			for(int j = i+1; j <= N; j++) {
				sumRecipe[i][j] = Recipe[i-1][j-1] + Recipe[j-1][i-1];
			}
		}
	}
	static int abs(int a, int b) {
		if(a >= b) {
			return a-b;
		}else {
			return b-a;
		}
	}
	
	static void subRecipeMin() {
		minCost = 999999;
		for(int i = 1; i <= N-1; i++) {
			for(int j = i+1; j <= N; j++) {
				for(int k = 1; k <= N-1; k++) {
					if(k != i && k != j) {
						for(int l = k+1; l <= N; l++) {
							if(l != i && l != j) {
								minCost = Math.min(minCost, abs(sumRecipe[i][j],sumRecipe[k][l]));
							}
						}
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				Recipe[i][j] = sc.nextInt();
			}
		}
		
		sumRecipeTotal();
		subRecipeMin();
		
		System.out.println(minCost);
		
		
		
	}

}
