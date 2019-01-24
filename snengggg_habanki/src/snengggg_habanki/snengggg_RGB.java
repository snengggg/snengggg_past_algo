package snengggg_habanki;

import java.util.Scanner;
import java.math.*;

public class snengggg_RGB {

	//static int[] cost = new int[3];
	static int[][] RGB;
	static int N;
	static int current;
	static int Maxcost = -1;
	
	static void RGBtest(int high, int num, int cur) {
		
		if(high < N) {
		
		cur = cur + RGB[high][num];
		
		if(num == 1)
		RGBtest(high+1,(num+1)%3, cur);
		
		RGBtest(high+1,(num+2)%3, cur);
		
		
		}
		
		Maxcost = Math.max(Maxcost, cur); 	
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		
		RGB = new int[N+1][3];
		
		for(int i = 1; i < N+1; i++) {
			RGB[i][0] = input.nextInt();
			RGB[i][1] = input.nextInt();
			RGB[i][2] = input.nextInt();
		}
		
		for(int i = 0; i < 3; i++) {
			RGBtest(1, i, 0);
		}
		
		System.out.println(Maxcost);
		
		
	}

}
