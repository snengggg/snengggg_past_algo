package snengggg123;

import java.util.Scanner;

public class expert_2063 {

	static int [] Num;
	
	static void push(int a, int b, int count) {
		
		for(int i = 0; i < count-a; i++) {
			Num[count-i] = Num[count-i-1];
		}
		Num[a] = b;
		return;
	}
	
	static void compare(int a, int b, int count) {
		
		if(a < count) {
			if(Num[a] >= b) {
				push(a,b,count);
				return;
			}
			else {
				compare(a+1,b,count);
				return;
			}
		}
		push(a,b,count);
		return;
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int midN = N/2;
		Num = new int [N];
		int temp = 0;
		
		Num[0] = sc.nextInt();
		
		for(int i = 1; i < N; i++) {
			
			compare(0, sc.nextInt(),i);
		}
		
		System.out.println(Num[midN]);

	}

}
