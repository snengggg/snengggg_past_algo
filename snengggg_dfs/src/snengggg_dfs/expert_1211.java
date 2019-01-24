package snengggg_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class expert_1211 {

	static int[][] ladder = new int[100][100];
	static int[] dx = { -1, 1 };
	static int[] dy = { 0, 0 };
	static int minCost;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int testcase = 1; testcase <= 10; testcase++) {

			br.readLine();

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ladderSize;
			int minCost = 987654321;
			int result = 0;

			for (int i = 0; i < 100; i++) {
				ladderSize = 987654321;
				if (ladder[0][i] == 1) {
					ladderSize = goBottom(0, i, 0);
					//System.out.println(ladderSize);
					if (ladderSize <= minCost) {
						minCost = ladderSize;
						result = i;
					}
					
				}
			}

			System.out.println("#" + testcase + " " + result);

		}

	}

	static int goBottom(int cury, int curx, int cost) {

		int leftx, rightx, y;
		int getCost;

		leftx = curx + dx[0];
		rightx = curx + dx[1];

		if (cury == 99) {
			return cost;
		} else {

			for (int i = cury; i < 100; i++) {

				if (leftx < 0) {
					if (ladder[i][rightx] == 1) {
						getCost = findGetCost(i, rightx, 1);
						return goBottom(i+1, getCost + curx, getCost + cost);

					}
				}
				if (rightx >= 100) {
					if (ladder[i][leftx] == 1) {
						getCost = findGetCost(i, leftx, -1);
						return goBottom(i+1, curx - getCost, getCost + cost);

					}
				}

				if (leftx >= 0 && rightx < 100) {

					if (ladder[i][rightx] == 1) {
						getCost = findGetCost(i, rightx, 1);
						return goBottom(i+1, getCost + curx, getCost + cost);

					}
					if (ladder[i][leftx] == 1) {
						getCost = findGetCost(i, leftx, -1);
						return goBottom(i+1, curx - getCost, getCost + cost);
					}
				}
			}
			return cost;
		}
	}

	static int findGetCost(int y, int x, int flag) {
		int cost = 0;
		if (flag == 1) {
			for (int i = x; i < 100; i++) {
				if (ladder[y][i] == 0) {
					cost = i - x;
					break;
				}else {
					if(i == 99) {
						cost = i - x + 1;
						break;
					}
				}
			}
		} else {
			for (int i = x; i >= 0; i--) {
				if (ladder[y][i] == 0 || i < 0) {
					cost = x - i;
					break;
				}else {
					if(i == 0) {
						cost = x - i + 1;
					}
				}
			}
		}
		return cost;

	}

	static void keepCost(int cost) {

	}

}
