import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static int n, delete;
    public static int[] parent;
    public static boolean[] visit;
    public static int result = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 초기화
        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        visit = new boolean[n];
        int root = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if(parent[i] == -1) root = i;
        }
        delete = Integer.parseInt(br.readLine());

        //노드 삭제
        deleteNode(delete);

        //리프노드 세기
        countLeafNode(root);
        System.out.println(result);
    }

    public static void deleteNode(int delete) {
        parent[delete] = -2;
        for (int i = 0; i < n; i++) {
            if (parent[i] == delete) {
                deleteNode(i);
            }
        }
    }

    public static void countLeafNode(int now) {
        boolean isLeaf = true;
        visit[now] = true;
        if (parent[now] != -2) {
            for (int i = 0; i < n; i++) {
                if (parent[i] == now && !visit[i]) {
                    countLeafNode(i);
                    isLeaf = false;
                }
            }
            if(isLeaf) result++;
        }
    }
}
