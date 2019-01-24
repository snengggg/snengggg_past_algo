package snengggg_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bjoon_14889 {

	static int N;
	static int[][] team;
	static int[] team_1;
	static int[] team_2;
	static int minCost = 987654321;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		team = new int[N][N];
		team_1 = new int[N / 2];
		team_2 = new int[N / 2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divTeam(1, 0);

		System.out.println(minCost);

	}

	static void divTeam(int s, int size) {

		team_1[size] = s;

		if (size < N / 2 - 1) {
			for (int i = 1; i <= N; i++) {

				if (team_1[size] >= i)
					continue;

				divTeam(i, size + 1);

			}
		} else {
			int count = 0;
			int flag = 0;

			

			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < N / 2; j++) {
					if (team_1[j] != i) {
						flag++;
					}
					if (flag == N / 2) {
						team_2[count++] = i;
						//flag = 0;
					}
				}
				if (count >= N / 2) {
					count = 0;
					break;
				}
				flag = 0;
			}

			findMincost();
		}

	}

	static void findMincost() {
		int team_1Count = 0;
		int team_2Count = 0;
		int result = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				if (i == j)
					continue;

				team_1Count += team[team_1[i]-1][team_1[j]-1];
				team_2Count += team[team_2[i]-1][team_2[j]-1];
			}
		}
		result = Math.abs(team_1Count - team_2Count);
		minCost = Math.min(minCost, result);
	}

}
