class Solution {
    
//     public void PS(String s,int idx,String str,List<String> al){
        
//     }
    public static void SS(int[] A,int idx,List<List<Integer>> res,List<Integer> curr){
        if(idx==A.length){
            //(curr.size()>0){
                // ArrayList<Integer> al = new ArrayList<Integer>();
                // for(int i=0;i<curr.size();i++){
                //     al.add(curr.get(i));
                // }
                // System.out.println();
                res.add(new ArrayList<>(curr));
            //
            return;
        }
        curr.add(A[idx]);
        SS(A,idx+1,res,curr);
        curr.remove(curr.size()-1);
        SS(A,idx+1,res,curr);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> al=new ArrayList<List<Integer>>();
        
        ArrayList<Integer> curr = new ArrayList<Integer>();
        SS(nums,0,al,curr);
        
        // Collections.sort(al,(x, y) -> {
        //     for (int i = 0; i < Math.min(x.size(), y.size()); i++) {
        //         if (x.get(i) != y.get(i)) {
        //             return x.get(i) - y.get(i);
        //         }
        //     }
        //     return x.size() - y.size();
        // });
        // for(int i=0;i<al.size();i++){
        //     for(int j=0;j<al.get(i).size();j++){
        //         System.out.print(al.get(i).get(j));
        //     }
            
        //     System.out.println();
        // }
        
        
        return al;
    }
}