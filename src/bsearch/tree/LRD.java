package bsearch.tree;

/**
 * @author ZH
 * ºóÐø±éÀú
 */
//B-Tree                                          
//                  15                      
//              5        16                 
//           3     12        20            
//              10        18    23        
//            6                                  
//              7 
//result 3, 7, 6, 10, 13, 12, 5, 18, 23, 20, 16, 15
public class LRD {
	public static void main(String[] args) {
		BSearchTreeRootNode root = new BSearchTreeRootNode();
		LRDShow(root.rootNode);
	}
	public static void LRDShow(TreeNode rootNode){
		if(rootNode.leftChild != null)
			LRDShow(rootNode.leftChild);
		if(rootNode.rightChild != null)
			LRDShow(rootNode.rightChild);
		System.out.print(rootNode.key + "|");
	}
}
