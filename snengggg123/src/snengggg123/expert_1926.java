package snengggg123;

import java.util.Scanner;

public class expert_1926 {

	
	
	static String Check369(String Num) {
		
		
		int len = Num.length();
		int checkNum = 0;
		
		
		for(int i = 0; i < len; i++) {
			if(Num.charAt(i) == '3' || Num.charAt(i) == '6' || Num.charAt(i) == '9') {
				checkNum++;
			}
		}
		
		if(checkNum == 0) {
			return Num;
		}else {
			Num = "";
			for(int i = 0; i < checkNum; i ++) {
				Num += '-';
			}
			return Num;
		}
	}
		
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt()	;
		String Numst;
		String Numreturn;
		
		for(int i = 1; i <= N; i++) {
			Numst = Integer.toString(i);
			Numreturn = Check369(Numst);
			System.out.print(Numreturn + " ");
		}
		

	}

}
