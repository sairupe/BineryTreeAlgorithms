package bsearch.tree;

import java.util.Stack;

/**
 * @author ZH
 * 中序遍历
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
		System.out.println("============Recursived============");
		LDRShow(root.rootNode);
		System.out.println("============UnRecursived============");
		LDR_UnRecursive(root.rootNode);
	}
	public static void LDRShow(TreeNode rootNode){
		if(rootNode.leftChild != null)
			LDRShow(rootNode.leftChild);
		System.out.print(rootNode.key + "|");
		if(rootNode.rightChild != null)
			LDRShow(rootNode.rightChild);
	}
	
    // 中序遍历非递归   
    public static void LDR_UnRecursive(TreeNode t) {  
        Stack<TreeNode> s = new Stack<TreeNode>();  
        while (t != null || !s.empty()) {  
            while (t != null) {  
                s.push(t);  
                t = t.leftChild;  
            }  
            if (!s.empty()) {  
                t = s.pop();  
                System.out.print(t.key + "|");  
                t = t.rightChild;  
            }  
        }  
    } 
    
    public static void visit(TreeNode p){
    	System.out.println(p.key);
    }
}
