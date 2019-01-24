package snengggg_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class bjoon_1726 {

	static int R, C;
	static int[][] rail;			//입력값 
	static int[][] railCost;		//명령 cost 저장 
	static int[][] visit;		
	static Point_3 start;
	static Point_3 end;
	static int[] dx = { 1, 2, 3, -1, -2, -3, 0, 0, 0, 0, 0, 0 }; // right(1,2,3) left(1,2,3) down(1,2,3) up(1,2,3)
	static int[] dy = { 0, 0, 0, 0, 0, 0, 1, 2, 3, -1, -2, -3 }; // 한번에 이동가능한 모든 점을 탐
	static int result; 

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		rail = new int[R][C];
		railCost = new int[R][C];
		visit = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				rail[i][j] = Integer.parseInt(st.nextToken());
				if (rail[i][j] == 0) {
					railCost[i][j] = 987654321;  		//이동가능한곳의 cost 987654321
				}else {
					railCost[i][j] = 0;					//못가는곳 0으로 
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		start = new Point_3(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
				Integer.parseInt(st.nextToken()), 0);

		st = new StringTokenizer(br.readLine());
		end = new Point_3(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
				Integer.parseInt(st.nextToken()), 0);

		bfs();

		System.out.println(result);

	}

	static void bfs() {
		int cy, cx, cway, ccost, y, x, way, cost, fcost;

		Queue<Point_3> q = new LinkedList<>();
		q.clear();
		q.offer(start);			//start point q에 push
		railCost[start.y][start.x] = 0;
		result = 987654321;
		
		while (!q.isEmpty()) {

			Point_3 pt = q.poll(); // q.poll
			//if (!isVisited(pt.y, pt.x)) {		//이미 visit한 point일 경우 탐색안
				cy = pt.y;						//현재 y
				cx = pt.x;						//현재 x
				cway = pt.way;					//현재 방
				ccost = pt.cost;					//지금까지 받은 명령  
				isVisit(cy, cx);					//visit[][] 마킹 

				if (cy == end.y && cx == end.x) {		//목적지에 도착했을 때 
					fcost = findCost(cway, end.way);		//방향 맞춰주기위한 cost
					if(cy == 0 && cx == 0 && start.x == 0 && start.y == 0) {
						result = fcost;					//시작점과 끝점이 0, 0으로 
					}else {
						railCost[cy][cx] += fcost;
						result = Math.min(result, railCost[cy][cx]);
						
						//result = railCost[cy][cx] + fcost;
					}
				}

				for (int i = 0; i < 12; i++) {

					y = cy + dy[i];
					x = cx + dx[i];
					way = go3th(i) / 3;

					if (!isRanged(x, y)) {
						continue;
					}
					if (rail[y][x] == 1) {
						i = go3th(i) - 1;
						continue;
					} else {

						cost = ccost + findCost(cway, way) + 1;
						if (railCost[y][x] > cost) {
							railCost[y][x] = cost;
							q.offer(new Point_3(y, x, way, cost));
						}

					}
				}
			//}

		}

	}

	static boolean isVisited(int y, int x) {
		if (rail[y][x] == 1) {
			return true;
		}
		return false;
	}

	static int findCost(int cur, int want) {

		if (cur == 1) {
			if (want == 3 || want == 4) {
				return 1;
			} else if (want == 2) {
				return 2;
			} else {
				return 0;
			}
		} else if (cur == 3) {
			if (want == 1 || want == 2) {
				return 1;
			} else if (want == 4) {
				return 2;
			} else {
				return 0;
			}
		} else if (cur == 2) {
			if (want == 3 || want == 4) {
				return 1;
			} else if (want == 1) {
				return 2;
			} else {
				return 0;
			}
		} else {
			if (want == 1 || want == 2) {
				return 1;
			} else if (want == 3) {
				return 2;
			} else {
				return 0;
			}
		}
	}

	static int go3th(int n) {
		if (n >= 0 && n < 3) {
			return 3;
		} else if (n >= 3 && n < 6) {
			return 6;
		} else if (n >= 6 && n < 9) {
			return 9;
		} else {
			return 12;
		}
	}

	static void isVisit(int y, int x) {
		visit[y][x] = 1;
	}

	static boolean isRanged(int x, int y) {
		if (y < 0 || y >= R || x < 0 || x >= C) {
			return false;
		} else {
			return true;
		}
	}

}

class Point_3 {
	int x;
	int y;
	int way;
	int cost;

	public Point_3(int y, int x, int way, int cost) {
		this.y = y;
		this.x = x;
		this.way = way;
		this.cost = cost;

	}
}
