package snengggg_0412;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RGB_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] R = new int[N+1];
		int[] G = new int[N+1];
		int[] B = new int[N+1];
		int[] Rdp = new int[N+1];
		int[] Gdp = new int[N+1];
		int[] Bdp = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			R[i] = Integer.parseInt(st.nextToken());
			G[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		for(int i = 1; i <= N; i++) {
			Rdp[i] = Math.min(R[i] + Gdp[i-1],R[i] + Bdp[i-1]);
			Gdp[i] = Math.min(G[i] + Rdp[i-1],G[i] + Bdp[i-1]);
			Bdp[i] = Math.min(B[i] + Rdp[i-1],B[i] + Gdp[i-1]);
		}
		
		int MinCost = Math.min(Rdp[N], Math.min(Gdp[N], Bdp[N]));
		
		bw.write(MinCost + "");
		bw.flush();
		bw.close();
	}

}
