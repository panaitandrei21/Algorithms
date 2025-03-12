package org.example.threesum;

import java.util.*;

public class ThreeSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (!map.isEmpty() && map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int sum = -nums[i];
                int a_pointer = i + 1;
                int b_pointer = nums.length - 1;
                while (a_pointer < b_pointer) {
                    int currSum = nums[a_pointer] + nums[b_pointer];
                    if (currSum == sum) {
                        res.add(Arrays.asList(nums[i], nums[a_pointer], nums[b_pointer]));
                        while (a_pointer < b_pointer && nums[a_pointer] == nums[a_pointer + 1]) a_pointer++;
                        while (a_pointer < b_pointer && nums[b_pointer] == nums[a_pointer - 1]) b_pointer--;
                        a_pointer++;
                        b_pointer--;
                    } else if (currSum > sum) {
                        b_pointer--;
                    } else if (currSum < sum) {
                        a_pointer++;
                    }
                }
            }

        }
        return res;
    }
    public static int threeSumClosestToTarget(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int sum = target - nums[i];
            int a_pointer = i + 1;
            int b_pointer = nums.length - 1;
            while (a_pointer < b_pointer) {
                int currSum = nums[a_pointer] + nums[b_pointer];
                if (Math.abs(currSum - sum) < Math.abs(closest - target)) {
                    closest = currSum + nums[i];
                }
                if (currSum == sum) {
                    return target;
                } else if (currSum > sum) {
                    b_pointer--;
                } else if (currSum < sum) {
                    a_pointer++;
                }
            }
        }
        return closest;
    }
    public static int threeSumClosestToTargetBruteForce(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (target == sum) {
                        return target;
                    }

                    if (Math.abs(sum - target) < Math.abs(closest - target)) {
                        closest = sum;
                    }

                }
            }

        }
        return closest;
    }
}
