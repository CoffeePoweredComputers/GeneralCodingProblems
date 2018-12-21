class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        int parentVal = root.val;
        
        //if they both can still split and they are both less than the current value then go left
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        
        //if they both can still split and they are both less than the current value then to right
        else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        
        //otherwise this is the split point (i.e. the LCA) so return the current root
        else{
            return root;
        }
        
    }
}