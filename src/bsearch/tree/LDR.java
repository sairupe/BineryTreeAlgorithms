package bsearch.tree;

/**
 * @author ZH
 * ÖÐÐò±éÀú
 */
//B-Tree                                          
//                  15                      
//              5        16                 
//           3     12        20            
//              10        18    23        
//            6                                  
//              7  
//result 3, 5, 6, 7, 10, 12, 13, 15, 16, 18, 20, 23
public class LDR {
	public static void main(String[] args) {
		BSearchTreeRootNode root = new BSearchTreeRootNode();
		LDRShow(root.rootNode);
	}
	public static void LDRShow(TreeNode rootNode){
		if(rootNode.leftChild != null)
			LDRShow(rootNode.leftChild);
		System.out.print(rootNode.key + "|");
		if(rootNode.rightChild != null)
			LDRShow(rootNode.rightChild);
	}
}
