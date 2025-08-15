package beakjun.day10;

import java.io.*;
import java.util.*;

public class SeniorSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(nk.nextToken());
        int M = Integer.parseInt(nk.nextToken());
        int K = Integer.parseInt(nk.nextToken());

        Map<String, Integer> subjectScore = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            subjectScore.put(name, score);
        }

        Set<String> knownSubjects = new HashSet<>();
        int knownSum = 0;
        for (int i = 0; i < K; i++) {
            String subject = br.readLine();
            knownSubjects.add(subject);
            knownSum += subjectScore.get(subject);
        }

        List<Integer> unknownScores = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectScore.entrySet()) {
            if (!knownSubjects.contains(entry.getKey())) {
                unknownScores.add(entry.getValue());
            }
        }

        Collections.sort(unknownScores);
        int minSum = knownSum;
        int maxSum = knownSum;


        for (int i = 0; i < M - K; i++) {
            minSum += unknownScores.get(i);
        }


        for (int i = unknownScores.size() - 1; i >= unknownScores.size() - (M - K); i--) {
            maxSum += unknownScores.get(i);
        }

        System.out.println(minSum + " " + maxSum);
    }
}
