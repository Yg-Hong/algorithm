import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Baekjoon_1717 {
    public static int[] root;
    public static int[] rank;
    public static int[] parent;
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 초기화
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        root = new int[n + 1];
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (command){
                case "0":
                    union(a, b);
                    break;

                case "1":
                    if(find(a) == find(b)) System.out.println("YES");
                    else System.out.println("NO");
                    break;
            }
        }
    }

    public static int find(int x) {
        if (root[x] == x) {
            return x;
        } else {
            // 최적화!!!!!!!경로 압축(Path Compression)
            // find하면서 만난 모든 값의 부모 노드를 root로 만든다.
            return root[x] = find(root[x]);
        }

    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        // 두 값의 root가 같으면(이미 같은 트리) 합치지 않는다.
        if(x == y) return;

        // 최적화!!!!!!! union-by-rank
        // 항상 높이가 더 낮은 트리를 높이가 높은 트리 밑에 넣는다.
        // 즉, 높이가 더 높은 쪽을 root로 삼는다.

        if (rank[x] < rank[y]) {
            root[x] = y;
        } else {
            root[y] = x;

            if(rank[x] == rank[y])
                rank[x]++;  //만약 높이가 같다면 합친 후 (x의 높이 + 1)
        }


    }
}