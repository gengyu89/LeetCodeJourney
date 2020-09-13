class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return Collections.emptyList();
        List<List<String>> list = new ArrayList<>();
        Map<String, Integer> hash = new HashMap<>();
        int i = 0;
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortStr = String.valueOf(c);
            if (!hash.containsKey(sortStr)) {
                hash.put(sortStr, i++);
                List<String> sub = new ArrayList<>();
                sub.add(str);
                list.add(sub);
            } else {
                list.get(hash.get(sortStr)).add(str);
            }
        }
        return list;
    }
}
