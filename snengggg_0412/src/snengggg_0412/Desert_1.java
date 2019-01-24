package snengggg_0412;

import java.util.Scanner;

public class Desert_1 {

	static int [][] desert;
	static boolean [][] flag;
	static int [] desNum;
	static int N;
	static int startX, startY;
	static int maxGet;
	
	static void move(int i, int j, int get, int[] dNum) {
		if(i < 0 || i >= N || j < 0 || j >= N )
			return;
		if(get == 0) {
			startX = i;
			startY = j;
		}
		if(flag[i][j] != true || startX != i || startY != j) {
			if(flag[i][j] == true) {
				return;
			}
			for(int k = 0; k < get; k++) {
				if(desert[i][j] == dNum[k])
					return;
			}
			dNum[get] = desert[i][j];
			flag[i][j] = true;
			move(i-1, j+1,get+1,dNum);
			move(i+1, j+1,get+1,dNum);
			move(i+1, j-1,get+1,dNum);
			move(i-1, j-1,get+1,dNum);
			flag[i][j] = false;
			return;
		}
		maxGet = Math.max(maxGet, get);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		desert = new int [N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				desert[i][j] = sc.nextInt();
			}
		}
		maxGet = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				desNum = new int[N*2];
				flag = new boolean [N][N];
				move(i,j,0,desNum);
				System.out.println(maxGet);
			}
		}
		/*if(maxGet<4)
			maxGet = -1;*/
		System.out.println(maxGet);
	}

}
