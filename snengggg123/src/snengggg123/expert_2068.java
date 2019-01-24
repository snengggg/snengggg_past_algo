package snengggg123;

import java.util.Scanner;

public class expert_2068 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for(int testcase = 1; testcase <= T; testcase++) {
			int maxNum = -1;
			for(int i = 0; i < 10; i++) {
				maxNum = Math.max(maxNum, sc.nextInt());
			}
			System.out.println("#"+testcase + " " + maxNum);
		}

	}

}
