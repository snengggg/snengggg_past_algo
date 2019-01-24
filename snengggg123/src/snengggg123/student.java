package snengggg123;

import java.util.Arrays;
import java.util.Scanner;

public class student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int k = 1; k <= T; k++) {
		int num = sc.nextInt();
		int Maxcost = -1;
		int cost = 0;
		int [] score = new int [101];
		
		Arrays.fill(score,0);
		
		for(int i = 0; i < 1000; i++) {
			score[sc.nextInt()]++;
		}
		for(int i = 0; i < 101; i++) {
			if(score[i] >= Maxcost) {
				Maxcost = score[i];
				cost = i;
			}
		}
		
		System.out.println("#" + k + " " + cost);
		}
		
	}

}
