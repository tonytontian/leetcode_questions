class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorderTraversalHelper(root, result);
        return result;
    }
    
    public List<Integer> inorderTraversalHelper(TreeNode root, List result) {
        if(root == null){
            return result;
        }
        
        inorderTraversalHelper(root.left, result);
        result.add(root.val);
        inorderTraversalHelper(root.right, result);
        return result;
    }
    
}