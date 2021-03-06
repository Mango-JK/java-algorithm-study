import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654_N과M5 {
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, M;
	static int[] arr;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		used = new boolean[N + 1];

		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		solve(1, 0, "");

		System.out.println(sb.toString());
	}

	static void solve(int idx, int cnt, String str) {
		if (cnt == M) {
			sb.append(str.trim() + "\n");
			return;
		} else {
			if (idx > N)
				return;

			for (int i = 1; i <= N; i++) {
				if (!used[i]) {
					used[i] = true;
					solve(idx + 1, cnt + 1, str + arr[i] + " ");
					used[i] = false;
				}
			}
		}
	}
}