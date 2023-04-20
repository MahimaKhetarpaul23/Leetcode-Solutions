/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair{
    TreeNode node;
    int idx;
    Pair(TreeNode node,int idx){
        this.node=node;
        this.idx=idx;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        ArrayDeque<Pair> q = new ArrayDeque<Pair>();
        q.offer(new Pair(root,1));
        int ans=1;
        while(!q.isEmpty()){
            int n=q.size();
            int minV=0,maxV=0;
            for(int i=0;i<n;i++){
                Pair temp = q.poll();
                TreeNode p = temp.node;
                int idx = temp.idx;
                if(i==0){
                    minV=idx;
                }
                if(i==n-1){
                    maxV=idx;
                }
                if(p.left!=null){
                    q.offer(new Pair(p.left,2*idx));
                }
                if(p.right!=null){
                    q.offer(new Pair(p.right,2*idx+1));
                }
            }
            ans = Math.max(ans,maxV-minV+1);
        }
        return ans;
    }
}