package snengggg_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bjoon_6603 {

	static int K;
	static int[] S;
	static int[] lottoN;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			K = Integer.parseInt(st.nextToken());
			if (K == 0)
				break;

			S = new int[K];
			lottoN = new int[6];

			for (int i = 0; i < K; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i <= K - 6; i++) {
				dfs(i, 0);
			}
			System.out.println();
		}
	}

	static void dfs(int N, int size) {

		int curN = S[N];
		lottoN[size] = curN;

		if (size < 5) {
			for (int i = 0; i < K; i++) {

				if (curN >= S[i])
					continue;

				dfs(i, size + 1);
			}
		} else {
			printCurlotto();
		}

	}
	static void printCurlotto() {

		for (int i = 0; i < 6; i++) {
			System.out.print(lottoN[i] + " ");
		}
		System.out.println();
	}

}
