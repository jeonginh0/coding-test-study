package beakjun.day8;

public class SeniorSolution {
    public boolean digitCount(String num) {
        int[] count = new int[10];

        for (char c : num.toCharArray()) {
            int digit = c - '0';
            count[digit]++;
        }

        for (int i = 0; i < num.length(); i++) {
            int expectedCount = num.charAt(i) - '0';
            if (count[i] != expectedCount) {
                return false;
            }
        }

        return true;
    }
}
