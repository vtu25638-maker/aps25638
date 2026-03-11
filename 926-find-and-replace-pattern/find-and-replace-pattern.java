class Solution {

     public boolean follows(String p, String s) {
        int n = p.length();
        HashMap<Character,Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(s.charAt(i)) ){
                if(set.contains(p.charAt(i))) return false;
                map.put(s.charAt(i),p.charAt(i));
                set.add(p.charAt(i));
            }
            if(map.containsKey(s.charAt(i)) && p.charAt(i) != map.get(s.charAt(i))) return false;
        }
        return true;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        int n = words.length;
        List<String> ans = new ArrayList<>();

        for(int i =0;i<n;i++){
            if(follows(pattern,words[i])) ans.add(words[i]);
        }
        return ans;
    }
}