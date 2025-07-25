package com.BinarySearch;

public class KokoEatingBanana {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));

    }

    static public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = highestNumberOfBananas(piles);
        int ans = end;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long timeTaken = 0;

            for (int pile : piles) {
                timeTaken += (pile + mid - 1) / mid;
            }
            if (timeTaken <= h) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;

    }

    static public int highestNumberOfBananas(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}