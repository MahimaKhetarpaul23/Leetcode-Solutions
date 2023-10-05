class Solution {
    public int majorityElement(int[] arr) {
        int n = arr.length;
        int ele = -1;
        int cnt = 0;
        for(int i=0;i<n;i++){ 
            if(cnt == 0){
                ele = arr[i];
                cnt++;
            }
            else if(ele == arr[i]){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        
        // checking if ele is majority element or not ??
        int count = 0;
        for(int i=0;i<n;i++){
            if(arr[i] == ele){
                count++;
            }
        }
        if(count>n/2){
            return ele;
        }
        return -1;
    }
}