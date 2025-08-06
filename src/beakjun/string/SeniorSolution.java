package beakjun.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeniorSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] files = new String[n];

        for (int i = 0; i < n; i++) {
            files[i] = br.readLine();
        }

        if (n == 1) {
            System.out.println(files[0]);
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < files[0].length(); i++) {
            char ch = files[0].charAt(i);
            boolean same = true;

            for (int j = 1; j < n; j++) {
                if (files[j].charAt(i) != ch) {
                    same = false;
                    break;
                }
            }

            sb.append(same ? ch : '?');
        }

        System.out.println(sb.toString());
    }

}
