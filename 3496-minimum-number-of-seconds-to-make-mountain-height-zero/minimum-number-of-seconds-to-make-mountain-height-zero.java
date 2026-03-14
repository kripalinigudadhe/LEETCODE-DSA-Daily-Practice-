class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 0;
        long right = (long)1e18;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (canReduce(mid, mountainHeight, workerTimes)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canReduce(long time, int mountainHeight, int[] workerTimes) {
        long totalHeight = 0;

        for (int t : workerTimes) {
            long low = 0, high = 100000;

            while (low < high) {
                long mid = (low + high + 1) / 2;
                long cost = (long)t * mid * (mid + 1) / 2;

                if (cost <= time) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }

            totalHeight += low;

            if (totalHeight >= mountainHeight) return true;
        }

        return totalHeight >= mountainHeight;
    }
}