//https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH

package snengggg_0412;

import java.util.Scanner;

public class Magnet_1 {

	static final int Max_N = 8;
	static final int Max_K = 20;
	static int K;
	static int [][] Magnet = new int[Max_N][Max_N];
	static int [][] Rotate = new int[Max_K][2];
	static boolean [] btwnValue = new boolean[3];
	static boolean [] rotateFlag = new boolean[4];
	
	
	
	static void rotateMagClock(int MagNum) {
		int temp = Magnet[MagNum][7];
		for(int i = 7; i >= 1; i--) {
			Magnet[MagNum][i] = Magnet[MagNum][i-1];
		}
		Magnet[MagNum][0] = temp;
		rotateFlag[MagNum] = true;
	}
	
	static void rotateMagCtrClock(int MagNum) {
		int temp = Magnet[MagNum][0];
		for(int i = 1; i <= 7; i++) {
			Magnet[MagNum][i-1] = Magnet[MagNum][i];
		}
		Magnet[MagNum][7] = temp;
		rotateFlag[MagNum] = true;
	}
	
	static void rotateMagnet(int mag, int vec) {
		if(rotateFlag[mag] == true)
			return;
		if(vec > 0) {
			rotateMagClock(mag);
		}else {
			rotateMagCtrClock(mag);
		}
		if(mag-1 >= 0) {
			if(btwnValue[mag-1] == false) {
				rotateMagnet(mag-1,vec*(-1));
			}
		}
		if(mag < 3) {
			if(btwnValue[mag] == false) {
				rotateMagnet(mag+1,vec*(-1));
			}
		}
		
	}
	static void btwnValueTest() {
		
		for(int i = 0; i < 3; i++) {
			if(Magnet[i][2] == Magnet[i+1][6])
				btwnValue[i] = true;
			else
				btwnValue[i] = false;
		}
	}
	static int scoreTotal() {
		
		
		return Magnet[0][0] + 2*Magnet[1][0] + 4*Magnet[2][0] + 8*Magnet[3][0];
	}
	static void rotateFlaginit() {
		for(int i = 0; i < 4; i++) {
			rotateFlag[i] = false;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int testcase = 1; testcase <= T; testcase++) {
		K = sc.nextInt();
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 8; j++) {
				Magnet[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < K; i++) {
			Rotate[i][0] = sc.nextInt();
			Rotate[i][1] = sc.nextInt();
		}
		
		
		for(int i = 0; i < K; i++) {
			btwnValueTest();
			rotateFlaginit();
			rotateMagnet(Rotate[i][0]-1,Rotate[i][1]);
		}
		
		System.out.println("#" + testcase + " " + scoreTotal());
		}
		
	}
}
