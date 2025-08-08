package beakjun.linked_hashset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MySolution {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 중복 제거를 위한 Set, 입력 순서를 유지하기 위한 LinkedHashSet
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        // set을 리스트로 변환하고 정렬
        List<String> words = new ArrayList<>(set);

        // 길이 짧은 순으로 우선 정렬, 길이 같으면 사전 순으로 정렬
        Collections.sort(words, (a,b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        // 결과 출력
        for (String word : words) {
            System.out.println(word);
        }
    }
}
