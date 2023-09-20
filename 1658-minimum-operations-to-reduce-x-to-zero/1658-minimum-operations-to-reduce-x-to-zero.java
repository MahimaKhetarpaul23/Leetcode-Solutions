class Solution {
    public int minOperations(int[] nums, int x) {
        
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        
        if(sum==x){
            return n;
        }
        
        // FINDING THE LARGEST SUBARRAY WITH SUM AS : SUM - X.
        int currSum=0;
        int i=0;
        int j=0;
        int len = 0;
        int targetSum = sum - x;
        while(j<n){
            currSum += nums[j];
            while(currSum>targetSum && i<j){
                currSum -= nums[i];
                i++;
            }
            if(currSum == targetSum){
                len = Math.max(len,j-i+1);
            }
            j++;
        }

        if(len==0){ // no subarray with sum : sum-x.
            return -1;
        }
        
        
        return n-len;
    }
}