package snengggg_0412;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BackPack_1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int [] dp = new int[W+1];
		int Weight;
		int Cost;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			Weight = Integer.parseInt(st.nextToken());
			Cost = Integer.parseInt(st.nextToken());
			for(int j = 1; j <= W; j++) {
				if(j == Weight) {
					dp[j] = Math.max(dp[j], Cost);
				}
			}
		}
		br.close();
		
		dp[0] = 0;
		
		for(int i = 1; i <= W; i++) {
			for(int j = 0; j < i; j++) {
				if(i-j >= j) {
					dp[i] = Math.max(dp[i], dp[i-j]+dp[j]);
				}
			}
		}
		
		bw.write(dp[W] + "");
		bw.flush();
		bw.close();
		

	}

}
