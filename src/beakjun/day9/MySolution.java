package beakjun.day9;

import java.util.*;

public class MySolution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersectionSet = new HashSet<>();

        for (int num: nums1){
            set.add(num);
        }

        for (int num: nums2){
            if(set.contains(num)){
                intersectionSet.add(num);
            }
        }

        int[] result = new int[intersectionSet.size()];
        int i = 0;
        for (int num: intersectionSet){
            result[i++] = num;
        }

        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] result = intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
