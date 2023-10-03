class Solution {
    public int numIdenticalPairs(int[] nums) {
        // int count=0;
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]==nums[j]){
        //             count++;
        //         }
        //     }
        // }
        // return count;
        Arrays.sort(nums);
        int curr = 0;
        int ans = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                curr++;
            }
            else{
                // if(curr>1){
                    ans += ((curr)*(curr+1))/2;
                    // System.out.println(ans+ "   " + curr);
                // }
                curr=0;
            }
        }
        // if(curr>1){
            ans += ((curr)*(curr+1))/2;
        // }
        return ans;
    }
}