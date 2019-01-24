package snengggg123;

import java.util.Scanner;

public class expert_2071 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int sumTotal = 0;
			int ave = 0;
			int ave_2 = 0;
			for(int i = 0; i < 10; i++) {
				sumTotal += sc.nextInt();
			}
			ave = sumTotal/10;
			ave_2 = sumTotal%10;
			if(ave_2 >= 5) {
				ave++;
			}
			
			System.out.println("#" + test_case + " " + ave);
		}
				

	}

}
