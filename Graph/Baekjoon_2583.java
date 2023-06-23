import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Baekjoon_2583
{
    static int[][] map;
    static boolean[][] visit;
    static int M, N, K;
    static ArrayList<Integer> result;
    static int[] dx = { 0,0,1,-1 };
    static int[] dy = { 1,-1,0,0 };

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visit = new boolean[M][N];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            drawing(leftX, leftY, rightX, rightY);
        }

        result = new ArrayList<>();
        for(int y = 0; y < M; y++) {
            for(int x = 0; x < N; x++) {
                if(!visit[y][x] && map[y][x] == 0) {
                    result.add(bfs(x, y));
                }
            }
        }
        System.out.println(result.size());
        for(int i = 0; i < result.size(); i++) {
            Collections.sort(result);
            System.out.print(result.get(i) + " ");
        }
    }

    static void drawing(int LX, int LY, int RX, int RY) {
        for(int y = LY; y <= RY - 1; y++) {
            for(int x = LX; x <= RX - 1; x++) {
                map[y][x] += 1;
            }
        }
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {x,y});
        visit[y][x] = true;
        int area = 1;
        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;
                if(visit[nextY][nextX])
                    continue;
                if(map[nextY][nextX] > 0)
                    continue;

                q.add(new int[] {nextX, nextY});
                //System.out.println(q);
                visit[nextY][nextX] = true;
                area++;
            }
        }

        return area;
    }
}