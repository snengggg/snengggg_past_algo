package snengggg_today;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testfor {
	static int N = 100;
	static int[][] map = new int[N][N];
	static int[][] dir = { { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/testfor.txt"));
		Scanner kb = new Scanner(System.in);
		int[] start = new int[2];
		for (int T = 1; T <= 10; T++) {
			int dummy = kb.nextInt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int n = kb.nextInt();
					map[i][j] = n;
					if (map[i][j] == 2) {
						start[0] = i;
						start[1] = j;
					}
				}
			}

			// System.out.println(start[1]);
			// 알고리즘 시작!
			int startrow = start[0];
			int startcol = start[1];
			for (int i = N - 1; i >= 0; i--) {
				if (startcol + dir[0][1] >= 0 && map[startrow + dir[0][0]][startcol + dir[0][1]] == 1) {// 좌이동
					startcol += dir[0][1];
					if (startcol + dir[0][1] == -1) {
						continue;
					}
					while (startcol + dir[0][1] >= 0 && map[startrow + dir[0][0]][startcol + dir[0][1]] == 1 ) {
						startcol += dir[0][1];
					}
					startrow = startrow - 1;
					continue;
				}

				if (startcol + dir[1][1] < N && // 경계검사
						map[startrow + dir[1][0]][startcol + dir[1][1]] == 1) {// 우이동
					startcol += dir[1][1];
					if (startcol + dir[1][1] == 100) {
						continue;
					}
					while (startcol + dir[1][1] < N && map[startrow + dir[1][0]][startcol + dir[1][1]] == 1 ) {
						startcol += dir[1][1];
					}
					startrow = startrow - 1;
					continue;
				}
				//System.out.println("["+startrow + "] [" + startcol + "]");
				startrow = startrow - 1;
			}
			System.out.println("#" + T + " " + startcol);
		}
	}

}