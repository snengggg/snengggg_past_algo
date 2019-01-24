package snengggg123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class expert_2007 {
	
	static String lineTotal;
	
	static int patternTest(int a, int b){
		for(int i = 0; i < b-a-1; i++) {
			if(lineTotal.charAt(a+1) != lineTotal.charAt(b+1)){
				return 0;
			}
		}
		return b-a;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase <= T; testcase++) {
			lineTotal = br.readLine();
			int patternNum = 0;
			for(int i = 1; i < 10; i++) {
				if(lineTotal.charAt(0) == lineTotal.charAt(i)){
					patternNum = patternTest(0,i);
				}
				if(patternNum > 0) {
					break;
				}
			}
			System.out.println("#" + testcase + " " +patternNum);
		}

		

	}

}
