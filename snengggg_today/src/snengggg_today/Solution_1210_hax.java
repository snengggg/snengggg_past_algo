package snengggg_today;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_1210_hax {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/testfor.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer;
		int cur;
		String turn;
		for (int t = 1; t <= 10; t++) {
			String[] line = new String[100];
			turn = br.readLine();
			for (int i = 0; i < 100; i++) {
				line[i] = br.readLine();
			}

			cur = line[99].indexOf('2');
			System.out.println(cur);
			for (int l = 98; l >= 0; l--) {
				if (cur - 2 >= 0 && line[l].charAt(cur - 2) == '1') {
					cur -= 4;
					for (int s = cur; s >= 0; s -= 2) {
						if (s < 3 || line[l].charAt(s - 2) == '0') {
							cur = s;
							break;
						}
					}
				} else if (cur < 197 && line[l].charAt(cur + 2) == '1') {
					cur += 4;
					for (int s = cur; s < 199; s += 2) {
						if (s > 196 || line[l].charAt(s + 2) == '0') {
							cur = s;
							break;
						}
					}
				}
			}
			answer = cur / 2;
			System.out.println("#" + t + " " + answer);
		}
	}
}