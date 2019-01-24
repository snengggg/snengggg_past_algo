package snengggg_0412;

import java.util.Scanner;

public class swimmingPool_1 {
	
	static final int costNum= 4;
	static final int monthNum= 12;
	static int [] cost = new int [costNum];
	static int [] month = new int [monthNum];
	static int minCost;

	static void getCost(int i, int totalprice) {
		if(i < monthNum) {
			while(month[i] == 0) {
				if(i >= monthNum -1)
					break;
				i++;			
			}
			int temp = totalprice;
			getCost(i+1, temp + cost[0]*month[i]);
		
			getCost(i+1, temp + cost[1]);
		
			getCost(i+3, temp + cost[2]);
			
			return;
		}
		minCost = Math.min(minCost, totalprice);
		return;
	}
	
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int testcase = 1; testcase <= T; testcase++) {
		for(int i = 0; i < costNum; i++) {
			cost[i] = sc.nextInt();
		}
		for(int i = 0; i < monthNum; i++) {
			month[i] = sc.nextInt();
		}
		
		minCost = 999999;
		getCost(0, 0);
		
		System.out.println("#" + testcase + " " + Math.min(minCost,cost[3]));

	}
	}

}
