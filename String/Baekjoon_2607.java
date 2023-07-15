import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 35분 걸림
 * Hashmap한번 쓰려고 했다가 코드가 더럽게 꼬였네...
 * 그냥 배열로 써서 탐색했으면 더 빨리 풀 수 있었을 것 같고
 * 배열 써도 시간 복잡도도 늘어날 것 같지 않아서 후회됨.
 * 다른 사람 풀이를 한번 보고 반성 타임을 가지자.
 */
public class Baekjoon_2607 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wordNum = Integer.parseInt(br.readLine());
        String pivot = br.readLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : pivot.toCharArray()) {
            if (map.get(ch) == null) {
                map.put(ch, 1);
            } else {
                int x = map.get(ch);
                map.put(ch, x + 1);
            }
        }

        int result = 0;
        for (int i = 0; i < wordNum - 1; i++) {
            HashMap<Character, Integer> clone = (HashMap<Character, Integer>) map.clone();

            String temp = br.readLine();
            HashMap<Character, Integer> tempMap = new HashMap<>();
            for (char ch : temp.toCharArray()) {
                if (clone.get(ch) == null) {
                    if(tempMap.get(ch) == null){
                        tempMap.put(ch, 1);
                    } else {
                        int x = tempMap.get(ch);
                        tempMap.put(ch, x + 1);
                    }
                } else {
                    int x = clone.get(ch);
                    if (x > 1) {
                        clone.put(ch, x - 1);
                    } else {
                        clone.remove(ch);
                    }
                }
            }

            if (clone.size() == 1 && tempMap.size() == 1) {
                int a = 0, b = 0;
                for (int value : clone.values()) {
                    a = value;
                }
                for (int value : tempMap.values()) {
                    b = value;
                }
                if(a == 1 && b == 1) {
                    result++;
                }
            } else if (clone.size() == 1 && tempMap.isEmpty()) {
                int a = 0;
                for (int value : clone.values()) {
                    a = value;
                }
                if(a == 1) {
                    result++;
                }
            } else if (clone.isEmpty() && tempMap.size() == 1) {
                int a = 0;
                for (int value : tempMap.values()) {
                    a = value;
                }
                if(a == 1) {
                    result++;
                }
            } else if (clone.isEmpty() && tempMap.isEmpty()) {
                result++;
            }
        }

        System.out.println(result);
    }
}