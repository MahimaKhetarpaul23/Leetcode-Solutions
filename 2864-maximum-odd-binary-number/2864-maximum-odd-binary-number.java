class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        char arr[] = new char[n];
        for(int i=0;i<n;i++){
            arr[i]='0';
        }
        int ones = 0;
        int zeroes = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                ones++;
            }
            else{
                zeroes++;
            }
        }
        for(int i=0;i<ones-1;i++){
            arr[i]='1';
        }
        arr[n-1]='1';
        String res = "";
        for(int i=0;i<n;i++){
            res += arr[i];
        }
        return res;
    }
}