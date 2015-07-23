package bsearch.tree;

/**
 * @author ZH
 * Ç°Ðø±éÀú
 * 
 */
//B-Tree                                          
//                  15                      
//              5        16                 
//           3     12        20            
//              10        18    23        
//            6                                  
//              7       
//result 15, 5, 3, 12, 10, 6, 7, 13, 15, 16, 18, 20, 23
public class DLR {
	public static void main(String[] args) {
		BSearchTreeRootNode root = new BSearchTreeRootNode();
		DLRShow(root.rootNode);
	}
	public static void DLRShow(TreeNode rootNode){
		System.out.print(rootNode.key + "|");
		if(rootNode.leftChild != null)
			DLRShow(rootNode.leftChild);
		if(rootNode.rightChild != null)
			DLRShow(rootNode.rightChild);
	}
}
