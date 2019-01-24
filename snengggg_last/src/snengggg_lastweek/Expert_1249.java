package snengggg_lastweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class expert_1249{
	
	static int N;
	static int [][] maps;
	static int [][] cost;
	static int result;
	
	static int [] dx = {1, 0, -1, 0};
	static int [] dy = {0, 1, 0, -1};
	
	public void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		//int testcase = Integer.parseInt(br.readLine()); 
		
		N = Integer.parseInt(br.readLine());
		
		maps = new int [N][N];
		cost = new int [N][N];
		
		//Arrays.fill(cost,100000);
		
		for(int i = 0; i< N; i++) {
			String st = br.readLine();
			for(int j = 0; j<N; j++) {
				maps[i][j] = st.charAt(j) - '0';
			}
		}
		
		bfs(0,0);
			
		System.out.println(result);
	}
	
	public void bfs(int y, int x){
		
		cost[y][x] = 0;
		Queue<point> q = new LinkedList<>(); 
		point pt = new point(y,x);
		q.offer(pt);
		while(q.isEmpty()) {
			
			pt = q.poll();
			int pt_y = pt.y;
			int pt_x = pt.x;
		
		if(pt_y == N-1 && pt_x == N-1) {
			result = cost[pt_y][pt_x];
		}
			
			for(int i = 0; i < 4; i++) {
				
				if(pt_y < 0 || pt_y >= N || pt_x < 0 || pt_x >= N)
					continue;
			
				if(cost[pt_y+i][pt_x+i] > cost[pt_y][pt_x]+maps[pt_y+i][pt_x+i]) {
					cost[pt_y+i][pt_x+i] = cost[pt_y][pt_x]+maps[pt_y+i][pt_x+i];
					q.offer(new point(pt_y+i, pt_x+i));
				}
			}
			
		
		
		}
	}
	
	
	
	
}

class point {
	int x;
	int y;
	
	public point(int y, int x) {
		this.x = x;
		this.y = y;
	}
	
}