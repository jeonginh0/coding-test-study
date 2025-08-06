package beakjun.string;

import java.util.*;

public class MySolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        char[] pattern = sc.nextLine().trim().toCharArray();

        for (int i = 1; i < n; i++) {
            char[] cursor = sc.nextLine().trim().toCharArray();
            for (int j = 0; j < pattern.length; j++) {
                if (pattern[j] != cursor[j]) {
                    pattern[j] = '?';
                }
            }
        }

        System.out.println(new String(pattern));
    }
}