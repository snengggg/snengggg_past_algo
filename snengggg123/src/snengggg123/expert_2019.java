package snengggg123;

import java.util.Scanner;

public class expert_2019 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int total;
		
		for(int i = 0; i <= N; i++) {
			total = 1;
			for(int j = 1; j <= i; j++) {
				total *= 2;
			}
			System.out.print(total + " ");
		}
		

	}

}
