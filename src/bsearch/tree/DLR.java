package bsearch.tree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * @author ZH
 * 前续遍历
 * 
 */
//B-Tree                                          
//                  15                      
//              5        16                 
//           3     12        20            
//              10   13   18    23        
//            6                                  
//              7       
//result 15, 5, 3, 12, 10, 6, 7, 13, 15, 16, 18, 20, 23
public class DLR {
	public static void main(String[] args) {
		BSearchTreeRootNode root = new BSearchTreeRootNode();
		System.out.println("\n===========Recursive===========");
		DLRShow(root.rootNode);
		System.out.println("\n===========UnRecursive===========");
		DLR_UnRecursive(root.rootNode);
		System.out.println("\n===========DLR_BRAND_SEARCH===========");
		DLR_BRAND_SEARCH(root.rootNode);
	}
	public static void DLRShow(TreeNode rootNode){
		System.out.print(rootNode.key + "|");
		if(rootNode.leftChild != null)
			DLRShow(rootNode.leftChild);
		if(rootNode.rightChild != null)
			DLRShow(rootNode.rightChild);
	}
	
	// 先序遍历非递归   （深度优先）
    public static void DLR_UnRecursive(TreeNode t) {  
        Stack<TreeNode> s = new Stack<TreeNode>();  
        while (t != null || !s.empty()) {  
            while (t != null) {  
                System.out.print(t.key + "|");  
                s.push(t);  
                t = t.leftChild;  
            }  
            if (!s.empty()) {  
                t = s.pop();  
                t = t.rightChild;  
            }  
        }  
    }  
    
    // 广度优先 
    public static void DLR_BRAND_SEARCH(TreeNode t){
    	Queue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(100);
    	queue.add(t);
    	while(!queue.isEmpty()){
    		TreeNode tree = queue.poll();
    		System.out.print(tree.key + "|");
    		if(tree.leftChild != null){
    			queue.add(tree.leftChild);
    		}
    		if(tree.rightChild != null){
    			queue.add(tree.rightChild);
    		}
    	}
    }
}
