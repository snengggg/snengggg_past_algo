import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class expert_1989 {
	
	static String palin;
	
	static int palinCheck() {
		int len = palin.length();
		
		for(int i = 0; i < len/2; i++) {
			if(palin.charAt(i) != palin.charAt(len-i-1)) {
				return 0;
			}
		}
		return 1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int ox;
		
		for(int testcase = 1; testcase <= T; testcase++) {
			
			palin = br.readLine();
			
			ox = palinCheck();
			
			System.out.println("#"+testcase + " " + ox);

		}
		
		
		
		
		

	}

}
