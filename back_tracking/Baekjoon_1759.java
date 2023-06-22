import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1759 {
    public static char[]crypt;
    public static char[] code;
    public static int L, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        crypt = new char[C];
        code = new char[L];
        for (int i = 0; i < C; i++) {
            crypt[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(crypt);

        makeCode(0, 0);

    }

    public static void makeCode(int start, int cnt) {
        if(cnt == L) {
            if(isValid()) {
                System.out.println(code);
            }
            return;
        }

        for (int i = start; i < C; i++) {
            code[cnt] = crypt[i];
            makeCode(i + 1, cnt + 1);
        }
    }

    public static boolean isValid() {
        int con = 0;
        int vow = 0;

        for(char x : code) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') vow++;
            else con++;
        }

        return con >= 2 && vow >= 1;
    }
}