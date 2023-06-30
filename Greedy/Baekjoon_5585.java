import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] DP, P;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int pay = Integer.parseInt(br.readLine());
        int charge = 1000 - pay;
        int result = 0;
        while(charge != 0) {
            if (charge >= 500) {
                charge -= 500;
                result++;
            }
            else if (charge >= 100) {
                charge -= 100;
                result++;
            }
            else if (charge >= 50) {
                charge -= 50;
                result++;
            }
            else if (charge >= 10) {
                charge -= 10;
                result++;
            }
            else if (charge >= 5) {
                charge -= 5;
                result++;
            }
            else if (charge >= 1) {
                charge -= 1;
                result++;
            }
        }
        System.out.println(result);
    }
}