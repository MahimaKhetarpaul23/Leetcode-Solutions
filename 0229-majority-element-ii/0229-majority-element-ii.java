class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1 = -1;
        int ele2 = -1;
        int cnt1 = 0;
        int cnt2 = 0;
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            if(ele1 == nums[i]){
                cnt1++;
            }
            else if(ele2 == nums[i]){
                cnt2++;
            }
            else if(cnt1 == 0){
                ele1 = nums[i];
                cnt1++;
            }
            else if(cnt2 == 0){
                ele2 = nums[i];
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        
        // checking if ele1 and ele2 have frequency greater than n/3:
        int count1 = 0;
        int count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == ele1){
                count1++;
            }
            if(nums[i] == ele2){
                count2++;
            }
        }
        
        List<Integer> al = new ArrayList<>();
        if(ele1==ele2 && count1>n/3){
            al.add(ele1);
            return al;
        }
        if(count1> n/3){
            al.add(ele1);
        }
        if(count2> n/3){
            al.add(ele2);
        }
        
        return al;     
    }
}