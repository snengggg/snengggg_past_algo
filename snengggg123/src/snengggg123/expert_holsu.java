package snengggg123;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class expert_holsu {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bt = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int numTemp = 0;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int sumTotal = 0;
			for(int i = 0; i < 10; i++) {
				numTemp = Integer.parseInt(st.nextToken());
				if(numTemp%2 == 1) {
					sumTotal += numTemp;
				}
			}
			
			
			System.out.println("#" + test_case + " " + sumTotal);
		}
		br.close();
		bt.flush();
		bt.close();

	}

}
