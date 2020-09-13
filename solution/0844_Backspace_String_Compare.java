class Solution {
    public boolean backspaceCompare(String S, String T) {
        return trans(S).equals(trans(T));
    }
    private String trans(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '#') { sb.append(c); }
            else if (sb.length() > 0) { sb.deleteCharAt(sb.length() - 1); }
        }
        return sb.toString();
    }
}
