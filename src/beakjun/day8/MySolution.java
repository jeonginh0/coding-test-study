package beakjun.day8;

import java.io.*;

public class MySolution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        int n = num.length();
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';
            count[digit]++;
        }

        boolean isValid = true;
        for (int i = 0; i < n; i++) {
            int expected = num.charAt(i) - '0';

            if (count[i] != expected) {
                isValid = false;
                break;
            }
        }

        System.out.println(isValid);
    }
}
