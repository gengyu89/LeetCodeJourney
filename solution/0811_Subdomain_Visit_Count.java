class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        Map<String, Integer> map = new HashMap();
        for (String cpdomain : cpdomains) {
            int i = cpdomain.indexOf(' ');
            int n = Integer.valueOf(cpdomain.substring(0, i));
            String domain = cpdomain.substring(i + 1);
            for (i = 0; i < domain.length(); ++i) {
                if (domain.charAt(i) == '.') {
                    String d = domain.substring(i + 1);
                    map.put(d, map.getOrDefault(d, 0) + n);
                }
            }
            map.put(domain, map.getOrDefault(domain, 0) + n);
        }

        List<String> res = new ArrayList();
        for (String domain : map.keySet()) res.add(map.get(domain) + " " + domain);
        return res;
    }
}
