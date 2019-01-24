package snengggg123;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.*;

public class rgb2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		int mincost;
		
		Scanner in = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bt = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int [][] RGB = new int [N+1][3];
		int [][] dp = new int [N+1][3];
		
		
		for(int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
			{
				RGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j <= 2; j++) {
			dp[i][j] = RGB[i][j] + Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3]);
			}
		}
		
		
		mincost = Math.min(Math.min(dp[N][0], dp[N][1]),dp[N][2]);
		
		bt.write(mincost + "");
		bt.flush();
		bt.close();
		
	}

}
