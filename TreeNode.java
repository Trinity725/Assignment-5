
public class TreeNode<T> {
    private T data;
    protected TreeNode<T>left;
    protected TreeNode<T>right;

    public TreeNode(T dataNode) {
        data = dataNode;
        left = null;
        right = null;
    }

    public TreeNode(TreeNode<T> node)
    {
        this(node.left,node.right,node.getData());
    }
public TreeNode(TreeNode<T> leftKid, TreeNode<T> rightKid, T dataInfo){
        data = dataInfo;
        left = new TreeNode<T>(leftKid);
        right = new TreeNode<T>(rightKid);

}
    public T getData() {
        return data;
    }
}