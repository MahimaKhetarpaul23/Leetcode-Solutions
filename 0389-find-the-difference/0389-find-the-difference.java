class Solution {
    public char findTheDifference(String s, String t) {
        
        HashMap<Character,Integer> mp = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(mp.containsKey(s.charAt(i))){
                mp.put(s.charAt(i),mp.get(s.charAt(i))+1);
            }
            else{
                mp.put(s.charAt(i),1);
            }
        }
        
        char ch=' ';
        
        for(int i=0;i<t.length();i++){
            if(mp.containsKey(t.charAt(i)) && mp.get(t.charAt(i))>0){
                int temp = mp.get(t.charAt(i));
                if(temp==1){
                    mp.remove(t.charAt(i));
                }
                else{
                    mp.put(t.charAt(i),temp-1);   
                }
            }
            else{
                ch = t.charAt(i);
            }
        }
        
        return ch;
        
    }
}