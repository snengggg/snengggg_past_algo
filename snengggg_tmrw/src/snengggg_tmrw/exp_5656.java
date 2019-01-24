package snengggg_tmrw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exp_5656 {

	static int N, C, R;
	static int minbCount;
	static int[][] brick;
	static int[][] brickCopy;
	static int[] basket;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			minbCount = 987654321;
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());

			brick = new int[R][C];
			brickCopy = new int[R][C];
			basket = new int[N];

			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					brick[i][j] = Integer.parseInt(st.nextToken());
					brickCopy[i][j] = brick[i][j];
				}
			}

			// C조합 dfs

			C_dfs(0, 0);

			System.out.println("#" + testcase + " " + minbCount);
		}
	}

	static void C_dfs(int cCount, int maxBasket) {

		if (maxBasket < N) {

			for (int i = 0; i < C; i++) {

				basket[maxBasket] = i;

				C_dfs(i, maxBasket + 1);

			}
		} else {

			bombBasket(basket);
			findCurbrick();
			resetBrick();

		}

	}

	static void resetBrick() {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				brick[i][j] = brickCopy[i][j];
			}
		}

	}

	static void findCurbrick() {
		int bCount = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (brick[i][j] != 0) {
					bCount++;
				}
			}
		}
		if (bCount < minbCount) {
			minbCount = bCount;
		}
	}

	static void bombBasket(int[] bas) {

		boolean bombCount;

		for (int i = 0; i < N; i++) {

			bombCount = bomb(basket[i]);

			if (bombCount) {
				renewBrick();
			}

		}
	}

	static void renewBrick() {
		for (int i = 0; i < C; i++) {
			for (int j = R - 1; j >= 0; j--) {
				if (brick[j][i] == 0) {
					getupperBrick(j, i);
				}
			}
		}
	}

	static void getupperBrick(int sy, int sx) {

		for (int i = sy - 1; i >= 0; i--) {
			if (brick[i][sx] != 0) {
				brick[sy][sx] = brick[i][sx];
				brick[i][sx] = 0;
				break;
			}
		}

	}

	static boolean bomb(int bombNum) {

		boolean needtoReset = false;

		for (int i = 0; i < R; i++) {
			if (brick[i][bombNum] != 0) {
				if (brick[i][bombNum] == 1) {
					brick[i][bombNum] = 0;
				} else {
					bombneighbor(i, bombNum);
					needtoReset = true;
				}
				break;
			}
		}
		return needtoReset;
	}

	static void bombneighbor(int sy, int sx) {

		int cy, cx, y, x;
		int bNum = brick[sy][sx];
		cy = sy;
		cx = sx;
		brick[sy][sx] = 0;
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < bNum - 1; j++) {
				y = cy + dy[i] * (j + 1);
				x = cx + dx[i] * (j + 1);
				if (isRanged(y, x)) {
					if (brick[y][x] == 0 || brick[y][x] == 1) {
						brick[y][x] = 0;
					} else {
						bombneighbor(y, x);
					}
				}
			}
		}

	}

	static boolean isRanged(int y, int x) {

		if (y < 0 || y >= R || x < 0 || x >= C) {
			return false;
		}
		return true;
	}

}
