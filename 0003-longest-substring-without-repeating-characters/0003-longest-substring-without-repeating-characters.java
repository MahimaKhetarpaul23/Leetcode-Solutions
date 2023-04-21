class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> mp = new HashMap<Character,Integer>();
        
        int i=0;
        int j=0;
        int n=s.length();
        int ans=0;
        while(j<n){
            char ch = s.charAt(j);
            // System.out.println(ch);
            if(mp.containsKey(ch)){
                // System.out.println(j+" :: "+ch);
                int idx=mp.get(ch);
                while(i<=idx){
                    mp.remove(s.charAt(i));
                    i++;
                }
                mp.put(ch,j);
                // ans = Math.max(ans,j-i+1);
            }
            else{
                mp.put(ch,j);
                ans = Math.max(ans,j-i+1);
            }
            //System.out.println(ans+"  -----  "+i+" :: "+j);
            j++;
        }
        
        return ans;
        
    }
}