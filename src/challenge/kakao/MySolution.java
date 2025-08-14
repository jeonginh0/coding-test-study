package challenge.kakao;

import java.util.*;

public class MySolution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> table = new HashMap<>();

        // 1) info 전처리: 4개 속성 각각 "-" 가능 → 16개 조합
        for (String row : info) {
            String[] t = row.split(" ");
            String[] attrs = { t[0], t[1], t[2], t[3] };
            int score = Integer.parseInt(t[4]);

            for (int mask = 0; mask < 16; mask++) {
                StringBuilder key = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    key.append((mask & (1 << i)) != 0 ? "-" : attrs[i]);
                    if (i < 3) key.append(" ");
                }
                table.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(score);
            }
        }

        // 2) 점수리스트 정렬
        for (List<Integer> list : table.values()) {
            Collections.sort(list);
        }

        // 3) 쿼리 처리
        int[] answer = new int[query.length];
        for (int qi = 0; qi < query.length; qi++) {
            String q = query[qi].replace(" and ", " ");
            String[] t = q.split(" ");
            String key = String.join(" ", Arrays.copyOfRange(t, 0, 4));
            int x = Integer.parseInt(t[4]);

            List<Integer> list = table.getOrDefault(key, Collections.emptyList());
            int idx = lowerBound(list, x);
            answer[qi] = list.size() - idx;
        }
        return answer;
    }

    // lower_bound: 최초로 >= target이 나오는 인덱스
    private int lowerBound(List<Integer> a, int target) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a.get(m) >= target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
