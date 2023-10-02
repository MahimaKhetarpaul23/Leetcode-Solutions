class Solution {
    public boolean winnerOfGame(String colors) {
        
        int currA = 0;
        int currB = 0;
        // int maxA = 0;
        // int maxB = 0;
        int a_result = 0;
        int b_result = 0;
        
        for(int i=0;i<colors.length();i++){
            if(colors.charAt(i)=='A'){
                if(currB > 2){
                    b_result += currB - 2;
                }
                currB = 0;
                currA++;
            }
            else{
                if(currA > 2){
                    a_result += currA - 2;
                }
                currA = 0;
                currB++;
            }
        }
        if(currB > 2){
            b_result += currB - 2;
        }
        if(currA > 2){
            a_result += currA - 2;
        }
        // System.out.println(a_result+ "   " + b_result);
        
        if(a_result<=0){
            return false;
        }
        
        if(a_result>b_result){
            return true;
        }
        
        return false;
    }
}