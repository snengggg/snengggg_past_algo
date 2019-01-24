import java.util.Scanner;

public class expert_1986 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int N;
		int totalNum;
		
		for(int testcase = 1; testcase <= T; testcase++) {
			N = sc.nextInt();
			totalNum = 0;
			for(int i = 1; i <= N; i++) {
				if(i % 2 == 1) {
					totalNum += i;
				}else {
					totalNum -= i;
				}
			}
			System.out.println("#" + testcase + " " + totalNum);
		}
		
		
	}

}
