import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baekjoon_7562 {

    static int[][] map;
    static int[][] visit;
    static int[] dx = { -1,-2,-2,-1,1,2,2,1 };
    static int[] dy = { -2,-1,1,2,2,1,-1,-2 };
    static int size;
    static int goal_x, goal_y;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            size = Integer.parseInt(br.readLine());

            map = new int[size][size];
            visit = new int[size][size];

            st = new StringTokenizer(br.readLine());
            int now_x = Integer.parseInt(st.nextToken());
            int now_y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            goal_x = Integer.parseInt(st.nextToken());
            goal_y = Integer.parseInt(st.nextToken());
            System.out.println(bfs(now_x, now_y));
        }
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {x, y});
        if(goal_x == x && goal_y == y)
            return 0;
        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i = 0 ; i< 8;i++) {
                int next_x = now[0] + dx[i];
                int next_y = now[1] + dy[i];

                if(next_x < 0 || next_y < 0 || next_x >= size || next_y >= size)
                    continue;
                if(visit[next_y][next_x] > 0)
                    continue;

                q.add(new int[] {next_x, next_y});
                visit[next_y][next_x] = visit[now[1]][now[0]] + 1;
                if(next_y == goal_y && next_x == goal_x)
                    return visit[next_y][next_x];
            }
        }


        return -1;
    }
}