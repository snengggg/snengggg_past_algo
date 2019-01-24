import java.util.Scanner;

public class expert_2005 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();

			int[][] pascal = new int[N + 1][N + 1];

			pascal[1][1] = 1;
			for (int i = 2; i <= N; i++) {
				for (int j = 1; j <= i; j++) {
					pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
				}
			}
				System.out.println("#" + testcase);
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print(pascal[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

}
