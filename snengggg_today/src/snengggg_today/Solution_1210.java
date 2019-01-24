package snengggg_today;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210 {

	static int[][] ladder;
	static int endN;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int garbage;
		ladder = new int[100][100];
		for (int testcase = 1; testcase <= 10; testcase++) {
			garbage = Integer.parseInt(br.readLine());
			for (int i = 0; i < 99; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				ladder[99][i] = Integer.parseInt(st.nextToken());
				if (ladder[99][i] == 2) {
					endN = i;
					break;
				}
			}

			for (int i = 99; i >= 0; i--) {
				if ((endN - 1) >= 0 && ladder[i][endN-1] == 1) {
					goLeft(i, endN-1);
					continue;
				}
				if ((endN + 1) < 100 && ladder[i][endN+1] == 1) {
					goRight(i, endN+1);
					continue;
				}
			}
			System.out.println("#" + testcase + " " + endN);
		}
	}
	public static void goLeft(int i, int end) {

		while (end >= 0  && ladder[i][end] != 0) {
			end--;
		}
		endN = end+1;
	}
	public static void goRight(int i, int end) {

		while (end < 100 && ladder[i][end] != 0) {
			end++;
		}
		endN = end-1;
	}
}