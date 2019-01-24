package snengggg_0412;

import java.util.Scanner;

public class MakeNum {
	
	static final int Oper_N = 4;
	static final int MAX_N = 12;
	static int N;
	static int [][] operator = new int [Oper_N][1];
	static int [] Num;
	static int cal;
	static int maxNum;
	static int minNum;
	static int ans;
	
	
	static void OPER(int N, int cal, int tot) {
		if(N-1 != cal) {
		if(operator[0][0] > 0) {
			operator[0][0]--;
			if(cal == 0)
				tot = Num[cal] + Num[cal+1];
			else
				tot = tot + Num[cal+1];
			OPER(N, cal+1, tot);
			operator[0][0]++;
		}
		if(operator[1][0] > 0) {
			operator[1][0]--;
			if(cal == 0)
				tot = Num[cal] - Num[cal+1];
			else
				tot = tot - Num[cal+1];
			OPER(N, cal+1, tot);
			operator[1][0]++;
		}
		if(operator[2][0] > 0) {
			operator[2][0]--;
			if(cal == 0)
				tot = Num[cal] * Num[cal+1];
			else
				tot = tot * Num[cal+1];
			OPER(N, cal+1, tot);
			operator[2][0]++;
		}
		if(operator[3][0] > 0) {
			operator[3][0]--;
			if(cal == 0)
				tot = Num[cal] / Num[cal+1];
			else
				tot = tot / Num[cal+1];
			OPER(N, cal+1, tot);
			operator[3][0]++;
		}
		}else {
			maxNum = Math.max(maxNum, tot);
			minNum = Math.min(minNum, tot);
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		cal = 0;
		Num = new int [N];
		
		for(int i = 0; i < Oper_N; i++) {
			operator[i][0] = sc.nextInt();
		}
		maxNum = 0;
		minNum = 999999;
		for(int i = 0; i < N; i++) {
			Num[i] = sc.nextInt();
		}
		
		OPER(N, cal, 0);
		
		ans = maxNum - minNum;
		System.out.println(maxNum);
		System.out.println(minNum);
		System.out.println(ans);
	}

}
