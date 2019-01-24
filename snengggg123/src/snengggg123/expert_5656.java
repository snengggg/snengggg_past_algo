package snengggg123;

import java.util.Scanner;

public class expert_5656 {
	
	static int W; 
	static int H;
	static int [] height;
	static int [][] square;
	static int N;
	static int totalNum;
	static int numA = 0;
	static int maxcost = -1;
	
	static void resizing() {
		for(int i = 1; i <= W; i++) {
			for(int j = H; j >= 1; j--) {
				if(square[j][i] == 0) {
					for(int k = j; k > 1; k--) {
						square[k][i] = square[k-1][i];
					}
				}
			}
		}
		return;
	}
	
	static void bomb(int x, int y, int Num) {
		
		square[x][y] = 0;
		height[y]--;
		
		for(int i = 1; i<Num;i++) {
		if(x-i > 0) {
			bomb(x-i,y,square[x-i][y]);
		}
		if(x+i < W) {
			bomb(x+i,y,square[x+i][y]);
		}
		if(y-i > 0) {
			bomb(x,y-i,square[x][y-i]);
		}
		if(y+i < H) {
			bomb(x,y+i,square[x][y+i]);
		}
		}
		
		resizing();
		return;
		
	}

	static void pingpong(int n, int x, int y) {
		
		
		if(N > n) {
			bomb(x,y,square[x][y]);
		}
		if(n >= 0) {
		for(int i = 1; i <= W; i++) {
			int Num = W - height[i] + 1;
			pingpong(n-1,Num,i);
			for(int k = 1; k <= H; k++) {
				for(int j = 1; j <= W; j++) {
					if(square[i][j] != 0) {
						numA++;
					}
				}
			}
			
			maxcost = Math.min(maxcost, numA);
		}
		}
		
		return;	
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		totalNum = 0;
		
	
		square = new int [H+2][W+1];
		height = new int [W+1];
		
		for(int i = 1; i <= H; i++) {
			for(int j = 1; j <= W; j++) {
				square[i][j] = sc.nextInt();
				if(square[i][j] != 0) {
					height[j]++;
					totalNum++;
				}
			}
		}
		
		pingpong(N, 0, 0);
		
		
		

		System.out.println(maxcost);
	}

}
