package snengggg123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Expert_2050 {
	
	public static void main (String args[]) throws IOException {
		
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String abc = br.readLine();
		
		for(int i = 0; i < abc.length(); i++) {
			int b = (abc.charAt(i)-64)%32;
			System.out.print(b + " ");
		}
		
	}

}
