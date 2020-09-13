class Solution {
    public double myPow(double x, int n) {
        if (n < 0) return helper(1 / x, -n);
        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double d = helper(x, n >>> 1);
        if (n % 2 == 0) return d * d;
        return d * d * x;
    }
}
