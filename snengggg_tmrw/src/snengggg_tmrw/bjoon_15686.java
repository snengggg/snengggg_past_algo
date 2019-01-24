package snengggg_tmrw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bjoon_15686 {

	static int N;
	static int M;
	static int[][] maul;
	static int chickNum;
	// static int chickCnt = 0;
	static int houseNum;
	static int houseChickNum = 0;
	static int chickNumtotal = 987654321;
	static int[] chickBasket;
	static Point[] chickPt;
	static housePoint[] housePt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maul = new int[N][N];
		chickPt = new Point[13];
		housePt = new housePoint[N * 2];
		chickBasket = new int[M];
		chickNum = 0;
		houseNum = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				maul[i][j] = Integer.parseInt(st.nextToken());

				if (maul[i][j] == 1) {
					housePt[houseNum++] = new housePoint(i, j, 987654321);
				}
				if (maul[i][j] == 2) {
					chickPt[chickNum++] = new Point(i, j);
				}
			}
		}

		dfs(-1, 0);

		System.out.println(chickNumtotal);
	}

	static void dfs(int curNum, int chickCnt) {

		if (chickCnt < M) {

			for (int i = 0; i < chickNum; i++) {

				if (i > curNum) {

					chickBasket[chickCnt] = i;
					dfs(i, ++chickCnt);
					chickCnt--;
				}

			}
		} else {

			findhouseCost(chickBasket);

			for (int j = 0; j < houseNum; j++) {
				houseChickNum += housePt[j].cost;
			}
			if (houseChickNum < chickNumtotal) {
				chickNumtotal = houseChickNum;
			}
			houseChickNum = 0;
			for (int k = 0; k < houseNum; k++) {
				housePt[k].cost = 987654321;
			}
		}

	}

	static void findhouseCost(int[] basket) {

		int lenY = 0;
		int lenX = 0;
		int len = 0;

		for (int num = 0; num < M; num++) {

			for (int i = 0; i < houseNum; i++) {
				lenY = Math.abs(chickPt[basket[num]].y - housePt[i].y);
				lenX = Math.abs(chickPt[basket[num]].x - housePt[i].x);
				len = lenY + lenX;
				if (M >= 2) {
					if (housePt[i].cost > len) {
						housePt[i].cost = len;
					}
				} else {
					housePt[i].cost = len;
				}

			}
		}

	}

}

class Point {
	int y;
	int x;
	// int cost;
	// int flag;

	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

class housePoint {
	int y;
	int x;
	int cost;
	// int flag;

	public housePoint(int y, int x, int cost) {
		this.y = y;
		this.x = x;
		this.cost = cost;
	}
}
