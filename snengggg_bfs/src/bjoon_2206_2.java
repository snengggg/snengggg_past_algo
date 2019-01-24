import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bjoon_2206_2 {

	static int R, C;
	static int[][] room;
	static int[][] visit;
	static int[][][] roomCost;
	// static int[][] roomCopy;
	static int wallCount;
	static int[] dx = { 1, 0, -1, 0 }; // 우 하 좌 상
	static int[] dy = { 0, 1, 0, -1 };
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		room = new int[R][C];
		visit = new int[R][C];
		roomCost = new int[R][C][2];
		result = -1;

		wallCount = 0;

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				room[i][j] = str.charAt(j) - '0';
				if (room[i][j] == 1) {
					room[i][j] = -1;
					roomCost[i][j][0] = -1;
					roomCost[i][j][1] = -1;

				} else {
					room[i][j] = 987654321;
					roomCost[i][j][0] = 987654321;
					roomCost[i][j][1] = 987654321;

				}
			}
		}
		bfs(0, 0);

		if (result != -1) {
			result++;
		}

		System.out.println(result);

	}

	static void bfs(int sy, int sx) {

		int cy, cx, cf, y, x;

		Queue<Point_2> Sq = new LinkedList<>();

		Sq.offer(new Point_2(sy, sx, 0));

		room[sy][sx] = 0;
		roomCost[sy][sx][0] = 0;
		roomCost[sy][sx][1] = 0;

		// int flag = 0;

		while (!Sq.isEmpty()) {

			Point_2 pt = Sq.poll();

			cy = pt.y;
			cx = pt.x;
			cf = pt.flag;

			if (visit[cy][cx] != 1) {
				visit[cy][cx] = 1;

				if (cy == R - 1 && cx == C - 1) {
						result = Math.min(roomCost[cy][cx][0], roomCost[cy][cx][1]);
					}
				}

				for (int i = 0; i < 4; i++) {

					y = cy + dy[i];
					x = cx + dx[i];

					if (y < 0 || y >= R || x < 0 || x >= C)
						continue;

					if (room[y][x] == 987654321) {
						if (roomCost[y][x][0] > roomCost[cy][cx][0] + 1) {
							roomCost[y][x][0] = roomCost[cy][cx][0] + 1;
							Sq.offer(new Point_2(y, x, cf));
						}
						if (roomCost[y][x][1] > roomCost[cy][cx][1] + 1) {
							roomCost[y][x][1] = roomCost[cy][cx][1] + 1;
							Sq.offer(new Point_2(y, x, cf));
						}
					} else {
						if (visit[y][x] == 0) {
							if (cf == 0) {
								roomCost[y][x][0] = 987654321;
								roomCost[y][x][1] = roomCost[cy][cx][1] + 1;
								Sq.offer(new Point_2(y, x, cf + 1));
							} else {
								roomCost[y][x][0] = 987654321;
								roomCost[y][x][1] = 987654321;
							}
						}
					}
				}
			}

		}
	}



class Point_2 {
	int x;
	int y;
	int flag;

	public Point_2(int y, int x, int flag) {
		this.y = y;
		this.x = x;
		this.flag = flag;
	}
}
