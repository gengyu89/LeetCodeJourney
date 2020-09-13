class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        int sl = s.length(), pl = p.length();
        boolean[][] dp = new boolean[sl + 1][pl + 1];
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        dp[0][0] = true;
        for (int i = 1; i <= pl; ++i) {
            if (pc[i - 1] == '*') dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i <= sl; ++i) {
            for (int j = 1; j <= pl; ++j) {
                if (pc[j - 1] != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (sc[i - 1] == pc[j - 1] || pc[j - 1] == '?');
                } else {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[sl][pl];
    }
}
