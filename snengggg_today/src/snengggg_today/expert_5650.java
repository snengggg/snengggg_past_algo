package snengggg_today;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class expert_5650 {

	static int N;
	static int[][] board;
	static int bCount;
	static int wCount;
	static bPoint[] bHole = new bPoint[5];
	static wPoint[] wHole = new wPoint[10];
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int cnt;
	static int maxCost = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		bCount = 0;
		wCount = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == -1) {
					bHole[bCount++] = new bPoint(i, j);
				}
				if (board[i][j] >= 6) {
					wHole[wCount++] = new wPoint(i, j, board[i][j]);
				}
			}
		}
		
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {
					for (int curway = 0; curway < 4; curway++) {
						cnt = 0;
						gameGo(i, j, curway);
						if(cnt > maxCost) {
							maxCost = cnt;
						}
					}
				}
			}
		}

	}

	static void gameGo(int sy, int sx, int way) {

		int cy, cx, y, x;

		cy = sy;
		cx = sx;

		y = cy + dy[way];
		x = cx + dx[way];

		if (!isRanged(y, x)) {
			findrangegameGo(y,x,way);
			cnt++;
		} else {
			if (board[y][x] == 0) {
				gameGo(y, x, way);
			} else if (board[y][x] > 0 && board[y][x] <= 5) {
				findwaygameGo(y, x, way, board[y][x]);
				cnt++;
			} else {
				for(int i = 0; i < wCount; i++) {
					if(board[y][x] == wHole[i].cost) {
						
					}
				}

				
			}
		}

	}

	static void findrangegameGo(int sy, int sx, int curway) {
		if(sy < 0) {
			gameGo(sy + dy[1], sx + dy[1], 1);
		}else if(sy >=N){
			gameGo(sy + dy[3], sx + dy[3], 3);
		}else if(sx < 0) {
			gameGo(sy + dy[0], sx + dy[0], 0);
		}else {
			gameGo(sy + dy[2], sx + dy[2], 2);
		}
	}

	static void findwaygameGo(int sy, int sx, int curway, int cost) {

		if (cost == 1) {
			if (curway == 0) {
				gameGo(sy + dy[2], sx + dy[2], 2);
			} else if (curway == 1) {
				gameGo(sy + dy[0], sx + dy[0], 0);
			} else if (curway == 2) {
				gameGo(sy + dy[3], sx + dy[3], 3);
			} else {
				gameGo(sy + dy[1], sx + dy[1], 1);
			}
		} else if (cost == 2) {
			if (curway == 0) {
				gameGo(sy + dy[2], sx + dy[2], 2);
			} else if (curway == 1) {
				gameGo(sy + dy[3], sx + dy[3], 3);
			} else if (curway == 2) {
				gameGo(sy + dy[1], sx + dy[1], 1);
			} else {
				gameGo(sy + dy[0], sx + dy[0], 0);
			}
		} else if (cost == 3) {
			if (curway == 0) {
				gameGo(sy + dy[1], sx + dy[1], 1);
			} else if (curway == 1) {
				gameGo(sy + dy[3], sx + dy[3], 3);
			} else if (curway == 2) {
				gameGo(sy + dy[0], sx + dy[0], 0);
			} else {
				gameGo(sy + dy[2], sx + dy[2], 2);
			}
		} else if (cost == 4) {
			if (curway == 0) {
				gameGo(sy + dy[3], sx + dy[3], 3);
			} else if (curway == 1) {
				gameGo(sy + dy[2], sx + dy[2], 2);
			} else if (curway == 2) {
				gameGo(sy + dy[0], sx + dy[0], 0);
			} else {
				gameGo(sy + dy[1], sx + dy[1], 1);
			}
		} else {
			if (curway == 0) {
				gameGo(sy + dy[2], sx + dy[2], 2);
			} else if (curway == 1) {
				gameGo(sy + dy[3], sx + dy[3], 3);
			} else if (curway == 2) {
				gameGo(sy + dy[0], sx + dy[0], 0);
			} else {
				gameGo(sy + dy[1], sx + dy[1], 1);
			}
		}

	}

	static boolean isRanged(int y, int x) {
		if (y < 0 || y >= N || x < 0 || x >= N) {
			return false;
		}
		return true;
	}

}

class bPoint {
	int y;
	int x;

	public bPoint(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

class wPoint {
	int y;
	int x;
	int cost;

	public wPoint(int y, int x, int cost) {
		this.y = y;
		this.x = x;
		this.cost = cost;
	}
}
