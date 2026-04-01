class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list= new ArrayList<>();

        if(s.length()<p.length()) return list;
        int[] count= new int[26];
        int[] countP= new int[26];
        for(int i=0;i<p.length();i++){
            countP[p.charAt(i)-'a']++;
        }
        for(int i=0,j=0;j<s.length();j++){
            count[s.charAt(j)-'a']++;
            if(j-i+1==p.length()){
                if(Arrays.equals(count,countP)) list.add(i);
                count[s.charAt(i)-'a']--;
                i++;
            }
        }

        return list;
        
}
}