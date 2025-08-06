package beakjun.string_analysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MySolution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            int lower = 0, upper = 0, digit = 0, space = 0;

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if ('a' <= c && c <= 'z') lower++;
                else if ('A' <= c && c <= 'Z') upper++;
                else if ('0' <= c && c <= '9') digit++;
                else if (c == ' ') space++;
            }

            out.append(lower).append(' ')
                    .append(upper).append(' ')
                    .append(digit).append(' ')
                    .append(space).append('\n');
        }

        System.out.print(out.toString());
    }
}
