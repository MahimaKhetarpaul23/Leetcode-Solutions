class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxVal = Integer.MIN_VALUE;
        int n=candies.length;
        for(int i=0;i<n;i++){
            maxVal = Math.max(maxVal,candies[i]);
        }
        
        List<Boolean> al=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(candies[i] + extraCandies >= maxVal){
                al.add(true);
            }
            else{
                al.add(false);
            }
        }
        
        return al;
    }
}