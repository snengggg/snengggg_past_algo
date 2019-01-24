package snengggg_0412;


import java.io.IOException;
import java.util.Scanner;


public class Runway_1 {
	
	static final int MAX_N = 20;
	static int [][] Line = new int[MAX_N*2][MAX_N];
	static int totalCount, jCount, xCount;
	static int N, X;
	
	static int Abs(int a, int b) {
		
		if(a>=b) {
			return a-b;
		}
		
		return b-a;
		
	}
	
	
	static boolean UPdown2(int i) {
		
		for(int j = 0 ; j < N-1; j++) {
			if(Abs(Line[i][j],Line[i][j+1]) >= 2) {
				return false;
			}
		}
		return true;
	}
	
	static boolean UPdown0(int i) {
		jCount = 0;
		for(int j = 0; j <= N-2; j++) {
			if(Line[i][j] == Line[i][j+1]) {
				jCount++;
			}
		}
		if(jCount == N-1) {
				return true;
			}
		return false;
	}
	static boolean upHill(int i) {
		boolean [] flag = new boolean [N];
		xCount = 1;
		for(int j = 0; j <= N-2; j++) {
			if(Line[i][j] == Line[i][j+1]) {
				if(flag[j] == true) {
					continue;
				}
				xCount++;
			}else if(Line[i][j] > Line[i][j+1]){
				xCount = 1;
				for(int k = 1; k < X; k++) {
					if(j+k+1 >= N) {
						return false;
					}
					if(Line[i][j+k] != Line[i][j+k+1]) {
						return false;
					}	
				}
				j = j + X - 1;
				flag[j+1] = true;
			}else {
				if(xCount < X) {
					return false;
				}else {
					xCount = 1;
				}
			}	
		}
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int a = 1; a <= T; a++) {
			N = sc.nextInt();
			X = sc.nextInt();
		
			for(int i = 0; i <= N-1; i++) {
				for(int j = 0; j <= N-1; j++) {
					Line[i][j] = sc.nextInt();
					Line[j+N][i] = Line[i][j];
				}
			}
		
			totalCount = 0;
		
			for(int i = 0; i <= N*2-1; i++) {
				
				if(UPdown2(i) == false) {
					continue;
				}
				if(UPdown0(i) == true) {
					totalCount++;
					continue;
				}
				if(upHill(i) == true) {
					totalCount++;
				}
		}
		
		System.out.println("#" + a + " " + totalCount);
		
	}
	}

}
