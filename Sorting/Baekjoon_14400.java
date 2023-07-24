import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


/**
 * 45분 소요
 * 기하 더럽다.기하 더럽다.기하 더럽다.기하 더럽다.기하 더럽다.기하 더럽다.기하 더럽다.
 * 그래도 sort에 새로운 기준을 만들 수 있도록 compartor의 구현체 선언하는 부분을 배워서 좋았당 :)
 */
public class Baekjoon_14499 {

    static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Pos[] positions = new Pos[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            positions[i] = new Pos(x, y);
        }

        Comparator<Pos> xComparator = new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                return o1.x - o2.x;
            }
        };
        Arrays.sort(positions, xComparator);
        int xMedian = positions[positions.length / 2].x;

        Comparator<Pos> yComparator = new Comparator<Pos>() {
            @Override
            public int compare(Pos o1, Pos o2) {
                return o1.y - o2.y;
            }
        };
        Arrays.sort(positions, yComparator);
        int yMedian = positions[positions.length / 2].y;

        Pos store = new Pos(xMedian, yMedian);
        Long totalDistance = 0l;
        for (int i = 0; i < n; i++) {
            totalDistance += getDistance(store, positions[i]);
        }
        System.out.println(totalDistance);
    }

    public static long getDistance(Pos a, Pos b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}