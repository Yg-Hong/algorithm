import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node node) {
        return weight - node.weight;
    }
}

public class Main {

    static int N, M;
    static ArrayList<ArrayList<Node>> g;
    static int[] dist;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //초기화
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        g = new ArrayList<>();
        dist = new int[N + 1];
        visit = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
        }

        // 단방향 그래프 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            //start에서 end로 가는 weight입력
            g.get(start).add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(startNode, endNode));
    }

    public static int dijkstra(int startNode, int endNode) {
        //초기화
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startNode, 0));
        dist[startNode] = 0;

        // 알고리즘
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!visit[cur]) {
                visit[cur] = true;

                for (Node node : g.get(cur)) {
                    if (!visit[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }

        return dist[endNode];
    }
}