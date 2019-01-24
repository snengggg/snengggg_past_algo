package snengggg_0412;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IOtest_1 {

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		char [] test = new char [6];
		String [] test2 = new String [6];
		//String g = br.readLine();
		
		for(int i = 0; i < 6; i++) {
			test2[i] = br.readLine();
		}
		if(test2[5] == null) {
			for(int i = 0; i < 6; i++) {
				System.out.println(test2[i]);
			}
		}
		
		
	}
}
