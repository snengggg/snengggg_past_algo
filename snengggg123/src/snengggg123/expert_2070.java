package snengggg123;

import java.util.Scanner;


public class expert_2070 {

	static char compare(int a, int b) {
		
		if(a > b)
			return '>';
		else if(a < b)
			return '<';
		else
			return '=';
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char temp = compare(sc.nextInt(), sc.nextInt());
			
			System.out.println("#" + test_case + " " + temp);
		}
		
		

	}

}
