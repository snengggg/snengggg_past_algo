import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bjoon_2206 {

	static int R, C;
	static int[][] room;
	static int[][] roomCopy;
	// static int [][][] roomCopy;
	static int wallCount;
	static Queue<Point> Mq;
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
		roomCopy = new int[R][C];
		Mq = new LinkedList<>();
		result = 987654321;

		wallCount = 0;

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				room[i][j] = str.charAt(j) - '0';
				if (room[i][j] == 1) {
					Mq.offer(new Point(i, j));
					room[i][j] = -1;
					roomCopy[i][j] = -1;
				} else {
					room[i][j] = 987654321;
					roomCopy[i][j] = 987654321;
				}
			}
		}
		bfs(0, 0);

		if (result == 987654321) {
			result = -1;
		} else {
			result++;
		}

		System.out.println(result);

	}

	static void bfs(int sy, int sx) {

		int cy, cx, y, x;

		Queue<Point> Sq = new LinkedList<>();

		Sq.offer(new Point(sy, sx));

		Point Mpt = new Point(0, 0);

		room[sy][sx] = 0;
		roomCopy[sy][sx] = 0;
		
		while (true) {
			if (!Mq.isEmpty()) {
				Mpt = Mq.poll();
				room[Mpt.y][Mpt.x] = 987654321;
			}

			while (!Sq.isEmpty()) {

				Point pt = Sq.poll();

				cy = pt.y;
				cx = pt.x;

				if (cy == R - 1 && cx == C - 1) {
					result = Math.min(result, room[cy][cx]);
				}

				for (int i = 0; i < 4; i++) {

					y = cy + dy[i];
					x = cx + dx[i];

					if (y < 0 || y >= R || x < 0 || x >= C)
						continue;

					if (room[y][x] > room[cy][cx] + 1) {
						room[y][x] = room[cy][cx] + 1;
						Sq.offer(new Point(y, x));
					}

				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					room[i][j] = roomCopy[i][j];
				}
			}
			if (Mq.isEmpty()) {
				break;
			} else {
				//room[Mpt.y][Mpt.x] = -1;
				Sq.clear();
				Sq.offer(new Point(sy, sx));
			}
		}
	}
}

class Point {
	int x;
	int y;

	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
