class Solution {
    public int[] sortArrayByParity(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            if (A[lo] % 2 > A[hi] % 2) {
                int tmp = A[hi];
                A[hi] = A[lo];
                A[lo] = tmp;
            }
            if (A[lo] % 2 == 0) lo++;
            if (A[hi] % 2 == 1) hi--;
        }
        return A;
    }
}
