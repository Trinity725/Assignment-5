
import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
    private TreeNode<String> root;

    /**
     * calls the buildTree method
     */
    public MorseCodeTree() {
        this.root = null;
        buildTree();
    }
    
    /**
     * Returns a reference to the root
     * @return reference to root
     */
    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    /**
     * sets the root of the MorseCodeTree
     * @param a newNode that will be the root of MorseCodeTree
     */
    @Override
    public void setRoot(TreeNode<String> newNode) {
        root = new TreeNode<String>(newNode);
    }

    /**
     * Adds element to the correct position in the tree based on the code 
     * This method will call the recursive method addNode
     *
     * @param code the code for the new node to be added
     */
    @Override
    public void insert(String code, String result) {
        if (root == null) {
            root = new TreeNode<String>(result);
        } else addNode(root, code, result);
    }

    /**
     * This is a recursive method that adds element to the correct position in the tree based on the code
     *
     * @param root - the root of the tree for this particular recursive instance of addNode
     * @param code - the code for this particular recursive instance of addNode
     * @param letter - the data of the new TreeNode to be added
     */
    @Override
    public void addNode(TreeNode<String> root, String code, String letter) 
    {
    	if (code.length() > 1) 
    	{
			if (code.charAt(0) == '-') 
			{
				addNode(root.right, code.substring(1), letter);
			} else if (code.charAt(0) == '.') 
			{
				addNode(root.left, code.substring(1), letter);
			}
		}
		
		else if (code.length() == 1) 
		{
			if (code.charAt(0) == '.') 
			{
				root.left = new TreeNode<String>(letter);
			} else if (code.charAt(0) == '-') 
			{
				root.right = new TreeNode<String>(letter);
			}
		}
    }

    /**
     * Fetch the data in the tree based on the code
     * This method will call the recursive method fetchNode
     *
     * @param code-the code that describes the traversals  to retrieve the string (letter)
     * @return the string (letter) that corresponds to the code
     */
    @Override
    public String fetch(String code) 
    {
        String fetchCode = fetchNode(root, code);
        return fetchCode;
    }

    /**
     * This is the recursive method that fetches the data of the TreeNode
     * that corresponds with the code
     *
     * @param root - the root of the tree for this particular recursive instance of addNode
     * @param code - the code for this particular recursive instance of addNode
     * @return the string (letter) corresponding to the code
     */
    @Override
    public String fetchNode(TreeNode<String> root, String code) 
    {
        String letter = "";
        if (code.length() > 1) 
        {
            if (code.charAt(0) == '.') 
            {
                letter += fetchNode(root.left, code.substring(1));
            } else 
            {
                letter += fetchNode(root.right, code.substring(1));
            }
        } else 
        {
            if (code.equals(".")) 
            {
                letter += root.left.getData();
                return letter;
            } else 
            {
                letter += root.right.getData();
                return letter;
            }
        }
        return letter;
    }

    
    /**
     * This operation is not supported in the MorseCodeTree
     * @param data - data of node to be deleted
     * @return reference to the current tree
     * @throws UnsupportedOperationException
     */
    @Override
    public MorseCodeTree delete(String data) 
    {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
    /**
     * This operation is not supported in the MorseCodeTree
     * @return reference to the current tree
     * @throws UnsupportedOperationException
     */
    @Override
    public MorseCodeTree update() {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
    
    /**
     * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code
     *
     */
    @Override
    public void buildTree() 
    {
        insert("","");
        
        insert(".","e"); insert("-","t");

        insert("..","i"); insert(".-","a");insert("-.","n"); insert("--","m");

        insert("...","s"); insert("..-","u");insert(".-.","r"); insert(".--","w");
        insert("-..","d"); insert("-.-","k");insert("--.","g"); insert("---","o");

        insert("....","h"); insert("...-","v");insert("..-.","f");
        insert(".-..","l");insert(".--.","p"); insert(".---","j");
        insert("-...","b"); insert("-..-","x");insert("-.-.","c");
        insert("-.--","y");insert("--..","z"); insert("--.-","q");
    }

    /**
     * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
     * Used for testing to make sure tree is built correctly
     * @return an ArrayList of the items in the linked Tree
     */
    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String>list=new ArrayList<String>();
        LNRoutputTraversal(root,list);
        return list;
    }

    /**
     * The recursive method to put the contents of the linked converter tree in an ArrayList<T>
     * @param root the root of the tree for this particular recursive instance
     * @param list the ArrayList that will hold the contents of the tree in LNR order
     */
    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) 
    {
        if(root.left==null && root.right==null) 
        {
            list.add(root.getData()+" ");
        }
        else 
        {
            if(root.left!=null) 
            {
                LNRoutputTraversal(root.left,list);
                list.add(root.getData()+" ");
            }
            if(root.right!=null) 
            {
                LNRoutputTraversal(root.right,list);
            }
        }

    }

    }
