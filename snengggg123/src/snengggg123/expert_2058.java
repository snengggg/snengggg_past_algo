package snengggg123;

import java.util.Scanner;

public class expert_2058 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int N_4 = N/1000;
		int N_3 = N%1000/100;
		int N_2 = N%100/10;
		int N_1 = N%10;
		
		
		System.out.println(N_4 + N_3 + N_2 + N_1);

	}

}
