import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_10610 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String N = br.readLine();
        boolean zeroFlag = false;
        int total = 0;
        for (int i = 0; i < N.length(); i++) {
            if(N.charAt(i) == '0')
                zeroFlag = true;
            total += Integer.parseInt(String.valueOf(N.charAt(i)));
        }
        if(!zeroFlag || total % 3 != 0) {
            System.out.println("-1");
            return;
        }

        char[] charArr = N.toCharArray();
        Arrays.sort(charArr);
        StringBuilder sb = new StringBuilder();
        for (int i = charArr.length - 1; i >= 0; i--) {
            sb.append(charArr[i] - '0');
        }
        System.out.println(sb.toString());
    }
}