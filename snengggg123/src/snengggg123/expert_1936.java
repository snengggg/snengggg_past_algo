package snengggg123;

import java.util.Scanner;

public class expert_1936 {
	
	static char RSP(int a, int b) {
		
		if(a == 1) {
			if(b == 2) {
				return 'B';
			}else {
				return 'A';
			}
		}else if(a == 2) {
			if(b == 3) {
				return 'B';
			}else {
				return 'A';
			}
		}else {
			if(b == 1) {
				return 'B';
			}else {
				return 'A';
			}
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt()	;
		int B = sc.nextInt()	;
		
		System.out.println(RSP(A,B));

	}

}
