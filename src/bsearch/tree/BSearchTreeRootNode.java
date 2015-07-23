package bsearch.tree;

public class BSearchTreeRootNode {

	public static TreeNode rootNode;
	
	
	// B-Tree                                          
	//                  15                      
	//              5        16                 
	//           3     12        20            
	//              10        18    23        
	//            6                                  
	//   
	public BSearchTreeRootNode(){
		rootNode = new TreeNode(15);
		TreeNode key5 = new TreeNode(5);
		TreeNode key16 = new TreeNode(16);
		TreeNode key3 = new TreeNode(3);
		TreeNode key12 = new TreeNode(12);
		TreeNode key20 = new TreeNode(20);
		TreeNode key10 = new TreeNode(10);
		TreeNode key13 = new TreeNode(13);
		TreeNode key18 = new TreeNode(18);
		TreeNode key23 = new TreeNode(23);
		TreeNode key6 = new TreeNode(6);
		TreeNode key7 = new TreeNode(7);
		
		rootNode.leftChild = key5;
		rootNode.rightChild = key16;
		key5.parent = rootNode;
		key16.parent = rootNode;
		
		key5.leftChild = key3;
		key5.rightChild = key12;
		key3.parent = key5;
		key12.parent = key5;
		
		key12.leftChild = key10;
		key12.rightChild = key13;
		key10.parent = key12;
		key13.parent = key12;
		
		key10.leftChild = key6;
		key6.parent = key10;
		
		key6.rightChild = key7;
		key7.parent = key6;
		
		key16.rightChild = key20;
		key20.parent = key16;
		
		key20.leftChild = key18;
		key20.rightChild = key23;
		key18.parent = key20;
		key23.parent = key20;
	}
}
