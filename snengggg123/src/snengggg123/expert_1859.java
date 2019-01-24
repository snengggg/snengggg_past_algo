package snengggg123;

import java.util.Scanner;

public class expert_1859 {

	static int[] dayCost;
	static int maxNum;
	static int maxNumindex;
	static long marginTotal;
	static int costTotal;
	static int costDay;
	
	static void findMaxNum(int start, int end) {
		maxNum = dayCost[start];
		for(int i = start+1; i < end; i++) {
			if(dayCost[i] >= maxNum) {
				maxNum = dayCost[i];
				maxNumindex = i;
			}
		}
		return;	
	}
	
	static void marginMax(int start, int end) {
		
		if(start < end) {
		maxNum = 0;
		maxNumindex = -1;
		costTotal = 0;
		costDay = 0;
		
		findMaxNum(start, end);
		if(maxNumindex != -1) {
		for(int i = start; i < maxNumindex; i++) {
			costTotal += dayCost[i];
			costDay++;
		}
		marginTotal = marginTotal + costDay*dayCost[maxNumindex] - costTotal;
		
		marginMax(maxNumindex+1, end);
		}else {
			marginMax(start+1, end);
			return;
		}
		}else {
			return;
		}
		return;
		
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int testcase = 1; testcase <= T; testcase ++) {
			int N = sc.nextInt();
		
			dayCost = new int [N];
		
			for(int i = 0; i < N; i++) {
				dayCost[i] = sc.nextInt();
			}
			marginMax(0,N);
		
			System.out.println("#" + testcase + " " + marginTotal);
			marginTotal = 0;
		}
	}

}
