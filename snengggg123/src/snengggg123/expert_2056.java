package snengggg123;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class expert_2056 {

	static boolean checkdate(int mon, int day) {
		
		if(mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
			if(day >= 1 && day <= 31)
				return true;
		}
		else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
			if(day >= 1 && day <= 33)
				return true;
		}else if(mon == 2) {
			if(day >= 1 && day <= 28){
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
	
	public static void main(String args[]) throws ParseException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase <= T; testcase++) {
			//StringTokenizer st = new StringTokenizer(br.readLine());	
			int year = 0;
			int month = 0;
			int day = 0;
			boolean flag = false;
			
			//String date = br.readLine();
			
			//String date = st.nextToken();
			String date = br.readLine();
			int date2 = Integer.parseInt(date);
			
			year = date2 / 10000;
			month = date2%10000/100;
			day = date2%100;
			
			flag = checkdate(month, day);
			
			if(flag == true) {
				
				System.out.println("#" + testcase + " " + date.substring(0,4) + "/" + date.substring(4,6) + "/" + date.substring(6,8));
				//System.out.println(date2);
				
			}else {
				System.out.println("#" + testcase + " -1" );
			}
			
		}
		
	}

	
}
