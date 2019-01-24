package snengggg_0412;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test_1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coin = new int [n+1];
		int[] dp = new int [k+1];
		
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		dp[0] = 1;
		
		for(int i = 1 ; i <= n; i++) {
			for(int j = 1; j <= k; j++) {
				if(j - coin[i] >= 0) {
					dp[j] = dp[j] + dp[j - coin[i]];
				}
			}
		}
		
		
		bw.write(dp[k] + "");
		bw.flush();
		bw.close();
		
	}

}
//TODO Auto-generated method stub
		