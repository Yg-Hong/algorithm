import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baekjoon_11725
{
    static ArrayList<ArrayList<Integer>> graph;
    static int[] parent;
    static int N;


    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i = 0 ; i< N + 1;i++) {
            graph.add(new ArrayList<>());
        }
        parent = new int[N + 1];
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        bfs();

        for(int i = 2; i <= N; i++)
            System.out.println(parent[i]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        parent[1] = 1;
        while(!q.isEmpty()) {
            int now = q.poll();

            for(int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);

                if(parent[next] > 0)
                    continue;

                q.add(next);
                parent[next] = now;
            }
        }
    }
}