package snengggg123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class expert_1859_2 {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int maxNum = 0;
		long marginTotal = 0;
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase <= T; testcase++) {
			int day = Integer.parseInt(br.readLine());
		
			int [] dayCost = new int[day];
		
			st = new StringTokenizer(br.readLine());
		
			for(int i = 0; i < day; i++) {
				dayCost[i] = Integer.parseInt(st.nextToken());
			}
			
			maxNum = dayCost[day-1];
		
			for(int i = day-2; i >=0; i--) {
				if(dayCost[i] > maxNum) {
					maxNum = dayCost[i];
				}else {
					marginTotal = marginTotal + maxNum - dayCost[i];
				}
			}
		System.out.println("#" + testcase + " " + marginTotal);
		marginTotal = 0;
		}
		
		

	}

}
