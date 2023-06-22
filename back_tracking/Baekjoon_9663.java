import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_9663 {
    static int[] MAP;
    static int N;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        MAP = new int[N];

        nQueen(0);
        System.out.println(result);
    }

    static void nQueen(int depth) {
        // 모든 원소를 다 채운 상태면 result 증가시키고 return 한다
        if (depth == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            MAP[depth] = i;
            // 퀸을 놓을 수 있으면
            if(ableToSet(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    static boolean ableToSet(int col) {
        for (int i = 0; i < col; i++) {
            // 같은 행에 존재할 경우
            if(MAP[col] == MAP[i]) {
                return false;
            }

            /*
             * 대각선 상에 놓여있는 경우
             * (열의 차와 행의 차가 같을 경우)
             */
            else if (Math.abs(col - i) == Math.abs(MAP[col] - MAP[i])) {
                return false;
            }
        }
        return true;
    }

}