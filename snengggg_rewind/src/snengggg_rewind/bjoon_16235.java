package snengggg_rewind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bjoon_16235 {

	static int N, M, K;
	static Stack<tree>[][] stck;
	static tree tr;
	//static tree[][] treeboard;
	static int[][] water;
	static int[][] inputwater;
	static int [] dx = {1, 1, 0, -1, -1, -1, 0, 1};
	static int [] dy = {0, 1, 1, 1, 0, -1,-1,-1};
	static int totaltreecount;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int cy, cx, ccost;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		inputwater = new int[N][N];
		water = new int[N][N];
		stck = new Stack[N][N];
		totaltreecount = 0;
		//tree tr;
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				inputwater[i][j] = Integer.parseInt(st.nextToken());
				water[i][j] = 5;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			cx = Integer.parseInt(st.nextToken())-1;
			cy = Integer.parseInt(st.nextToken())-1;
			ccost = Integer.parseInt(st.nextToken());
			tr = new tree(cy,cx,ccost);
			//stck[cy][cx].push(tr);
			stck[cy][cx].push(tr);
			
		}

		for (int i = 0; i < K; i++) {
			spring();
			summer();
			fall();
			winter();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				totaltreecount += stck[i][j].size();
			}
		}
		System.out.println(totaltreecount);

	}
	
	static void winter() {
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				water[i][j] += inputwater[i][j];
			}
		}	
	}
	static void fall() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(stck[i][j].size() != 0) {
					maketree(i,j);
				}
			}
		}
	}
	
	static void maketree(int cy, int cx) {
		int tCount = stck[cy][cx].size();
		
		for(int i = 0; i < tCount; i++) {
			if(stck[cy][cx].elementAt(i).cost % 5 == 0) {
				maketreeneighbor(cy, cx);
			}
		}
		
	}
	
	static void maketreeneighbor(int sy, int sx) {
		
		int cy, cx, y, x;
		
		cy = sy;
		cx = sx;
		
		for(int i = 0; i < 8; i++) {
			y = cy + dy[i];
			x = cx + dx[i];
			
			if(!isRanged(y, x))
				continue;
			
			stck[y][x].push(new tree(y,x,1));
			
		}
		
	}
	
	static boolean isRanged(int cy, int cx) {
		
		if(cy < 0 || cy >= N || cx < 0 || cx >= N) {
			return false;
		}
		return true;
	}
	
	
	static void summer() {
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <N; j++) {
				if(stck[i][j].size() != 0 && stck[i][j].peek().cost < 0) {
					treetowater(i,j);
				}
			}
		}
	}
	static void treetowater(int cy, int cx) {
		int tCount = stck[cy][cx].size(); 
		for(int i = 0; i < tCount; i++) {
			if(stck[cy][cx].peek().cost < 0) {
				water[cy][cx] += stck[cy][cx].peek().cost*(-1)/2;
				stck[cy][cx].pop();
			}
		}
	}
	

	static void spring() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (stck[i][j].size() != 0) {
					watering(i, j);
				}
			}
		}

	}

	static void watering(int cy, int cx) {
		int tCount = stck[cy][cx].size();
		//int tCost = stck[cy][cx].peek().cost;

		for (int i = 0; i < tCount; i++) {
			if (stck[cy][cx].elementAt(i).cost <= water[cy][cx]) {
				water[cy][cx] -= stck[cy][cx].elementAt(i).cost;
				stck[cy][cx].elementAt(i).cost++;
			}else {
				stck[cy][cx].elementAt(i).cost = stck[cy][cx].elementAt(i).cost*-1;
				break;
			}
		}
	}

}

class tree {
	int y;
	int x;
	int cost;

	public tree(int y, int x, int cost) {
		this.y = y;
		this.x = x;
		this.cost = cost;
	}
}
