package snengggg123;

import java.io.*;
import java.util.StringTokenizer;
 
public class expert_1859_source {
        public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
         
        int T = Integer.parseInt(br.readLine());
        int num = 1;
 
         
        while(T-->0) {
             
            int Day = Integer.parseInt(br.readLine());
             
            st = new StringTokenizer(br.readLine());
             
            int [] vals = new int[Day];
             
            for (int i = 0; i < Day ; i++) {
                vals[i] =   Integer.parseInt(st.nextToken());
            }
 
            int max = 0;
            long profit = 0;
             
            for(int i = Day -1; i >= 0; i--) {
                if(vals[i] >= max) {
                    max = vals[i];
                }else {
                    profit += (max - vals[i]);
                }
            }
            System.out.printf("#%d %d\n",num++,profit);
        }
    }
}