package beakjun.day10;

import java.io.*;
import java.util.*;

public class MySolution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<String, Integer> score = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            score.put(name, p);
        }

        Set<String> known = new HashSet<>();
        for (int i = 0; i < K; i++) {
            String t = br.readLine().trim();
            known.add(t);
        }

        long sumKnown = 0;
        List<Integer> others = new ArrayList<>();
        for (Map.Entry<String, Integer> e : score.entrySet()) {
            if (known.contains(e.getKey())) sumKnown += e.getValue();
            else others.add(e.getValue());
        }

        Collections.sort(others);

        int need = M - K;
        long min = sumKnown, max = sumKnown;
        for (int i = 0; i < need; i++) min += others.get(i);
        for (int i = 0; i < need; i++) max += others.get(others.size()-1 - i);

        System.out.println(min + " " + max);
    }
}
