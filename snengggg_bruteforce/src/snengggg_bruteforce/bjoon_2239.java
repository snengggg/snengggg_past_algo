package snengggg_bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bjoon_2239 {

	static int[][][] sdoku = new int[9][9][10];
	// static int [][][] sdokuNum = new int [9][9][10];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st;
		int numCount = 0;
		int minCost = 987654321;
		int minY = 0;
		int minX = 0;
		int tempK = 987654321;
		int zeroCount = 0;

		for (int i = 0; i < 9; i++) {
			st = br.readLine();
			for (int j = 0; j < 9; j++) {
				sdoku[i][j][0] = st.charAt(j) - '0';
				for (int k = 1; k <= 9; k++) {
					sdoku[i][j][k] = 1;
				}

			}
		}

		while (true) {
			minCost = 987654321;
			zeroCount = 0;

			findNum(0, 0);

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (sdoku[i][j][0] == 0) {
						for (int k = 1; k <= 9; k++) {
							if (sdoku[i][j][k] == 1) {
								numCount++;
								tempK = k;
							}
						}
						// System.out.println(numCount);
						if (numCount == 1) {
							sdoku[i][j][0] = tempK;
							sdoku[i][j][tempK] = 0;

						}

						if (numCount < minCost) {
							minCost = numCount;
							minY = i;
							minX = j;
						}

					}
					numCount = 0;
				}
			}

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (sdoku[i][j][0] == 0) {
						zeroCount++;
					}
				}
			}
			if (zeroCount == 0)
				break;

			if (minCost >= 2) {
				for (int fk = 1; fk <= 9; fk++) {
					if (sdoku[minY][minX][fk] == 1) {
						sdoku[minY][minX][fk] = 0;
						sdoku[minY][minX][0] = fk;
					}
				}
			}

		}

		for (int a = 0; a < 9; a++) {
			for (int b = 0; b < 9; b++) {
				System.out.print(sdoku[a][b][0]);
			}
			System.out.println();
		}

	}

	static void findNum(int y, int x) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sdoku[i][j][0] == 0) {

					canNum(i, j, isWhere(i, j));
				}
			}
		}
	}

	static int isWhere(int y, int x) {
		int where = 0;

		if (y >= 0 && y < 3 && x >= 0 && x < 3) {
			where = 1;
		} else if (y >= 0 && y < 3 && x >= 3 && x < 6) {
			where = 2;
		} else if (y >= 0 && y < 3 && x >= 6 && x < 9) {
			where = 3;
		} else if (y >= 3 && y < 6 && x >= 0 && x < 3) {
			where = 4;
		} else if (y >= 3 && y < 6 && x >= 3 && x < 6) {
			where = 5;
		} else if (y >= 3 && y < 6 && x >= 6 && x < 9) {
			where = 6;
		} else if (y >= 6 && y < 9 && x >= 0 && x < 3) {
			where = 7;
		} else if (y >= 6 && y < 9 && x >= 3 && x < 6) {
			where = 8;
		} else {
			where = 9;
		}
		return where;
	}

	static void canNum(int y, int x, int where) {

		for (int k = 1; k <= 9; k++) {
			for (int j = 0; j < 9; j++) {
				if (sdoku[y][j][0] == k) {
					sdoku[y][x][k] = 0;
					break;
				}
			}
			for (int i = 0; i < 9; i++) {
				if (sdoku[i][x][0] == k) {
					sdoku[y][x][k] = 0;
				}

			}

			if (where == 1) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (sdoku[i][j][0] == k) {
							sdoku[y][x][k] = 0;
						}
					}
				}
			} else if (where == 2) {
				for (int i = 0; i < 3; i++) {
					for (int j = 3; j < 6; j++) {
						if (sdoku[i][j][0] == k) {
							sdoku[y][x][k] = 0;
						}
					}
				}
			} else if (where == 3) {
				for (int i = 0; i < 3; i++) {
					for (int j = 6; j < 9; j++) {
						if (sdoku[i][j][0] == k) {
							sdoku[y][x][k] = 0;
						}
					}
				}
			} else if (where == 4) {
				for (int i = 3; i < 6; i++) {
					for (int j = 0; j < 3; j++) {
						if (sdoku[i][j][0] == k) {
							sdoku[y][x][k] = 0;
						}
					}
				}
			} else if (where == 5) {
				for (int i = 3; i < 6; i++) {
					for (int j = 3; j < 6; j++) {
						if (sdoku[i][j][0] == k) {
							sdoku[y][x][k] = 0;
						}
					}
				}
			} else if (where == 6) {
				for (int i = 3; i < 6; i++) {
					for (int j = 6; j < 9; j++) {
						if (sdoku[i][j][0] == k) {
							sdoku[y][x][k] = 0;
						}
					}
				}
			} else if (where == 7) {
				for (int i = 6; i < 9; i++) {
					for (int j = 0; j < 3; j++) {
						if (sdoku[i][j][0] == k) {
							sdoku[y][x][k] = 0;
						}
					}
				}
			} else if (where == 8) {
				for (int i = 6; i < 9; i++) {
					for (int j = 3; j < 6; j++) {
						if (sdoku[i][j][0] == k) {
							sdoku[y][x][k] = 0;
						}
					}
				}
			} else {
				for (int i = 6; i < 9; i++) {
					for (int j = 6; j < 9; j++) {
						if (sdoku[i][j][0] == k) {
							sdoku[y][x][k] = 0;
						}
					}
				}
			}

		}

	}
}
