import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int answer = 0;

            // 가로 확인
            for (int i = 0; i < N; i++) {
                int count = 0;

                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) {
                        count++;
                    } else {
                        if (count == K) {
                            answer++;
                        }
                        count = 0;
                    }
                }

                // 줄 끝에서 끝난 경우
                if (count == K) {
                    answer++;
                }
            }

            // 세로 확인
            for (int j = 0; j < N; j++) {
                int count = 0;

                for (int i = 0; i < N; i++) {
                    if (map[i][j] == 1) {
                        count++;
                    } else {
                        if (count == K) {
                            answer++;
                        }
                        count = 0;
                    }
                }

                // 줄 끝에서 끝난 경우
                if (count == K) {
                    answer++;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}