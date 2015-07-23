package bsearch.tree;

public class BTreeSearch {
	// B-Tree                                          
	//                  15                      
	//              5        16                 
	//           3     12        20            
	//              10        18    23        
	//            6                                  
	//              7                                
	public static void main(String[] args) {
		BSearchTreeRootNode root = new BSearchTreeRootNode();
		TreeNode key23 = searchNodeByKey(root.rootNode, 5);
		searchSuccessor(key23);
		searchPredecessor(key23);
	}
	
	public static TreeNode searchNodeByKey(TreeNode root, int key){
		if(root.key == key){
			System.out.println("====Hit====");
			return root;
		}
		else if(root.key > key && root.leftChild != null)
			return searchNodeByKey(root.leftChild, key);
		else if(root.key < key && root.rightChild != null)
			return searchNodeByKey(root.rightChild, key);
		else
			return null;
	}
	
	public static int searchMin(TreeNode root){
		if(root.leftChild != null){
			return searchMin(root.leftChild);
		}
		return root.key;
	}
	
	public static int searchMax(TreeNode root){
		if(root.rightChild != null){
			return searchMin(root.rightChild);
		}
		return root.key;
	}
	
	/**
	 * 需找后继节点
	 * @param root
	 */
	public static void searchSuccessor(TreeNode root){
		int successor = -1;
		/* 如果右子树存在的话，则返回左子树中最大的节点，即为比它小的之中的最大的节点 */
		if(root.rightChild != null){
			successor = searchMin(root.rightChild);
		}
		else{// 同理下面找前驱
			TreeNode paramNode = root;
			while(paramNode.parent != null && paramNode != paramNode.parent.leftChild){
				paramNode = paramNode.parent;
			}
			if(paramNode.parent != null)
				successor = paramNode.parent.key;
		}
		System.out.println("====>>>Tree Node " + root.key + " successor is " + successor);
	}
	
	/**
	 * 需找前驱节点
	 * @param root
	 */
	public static void searchPredecessor(TreeNode root){
		int predecessor = -1;
		if(root.leftChild != null){
			predecessor = searchMax(root.leftChild);// correct
		}
		else{
			TreeNode paramNode = root;
			/* 如果左子树不存在的话，则需要往上找，直到找到目标节点是目标节点父亲节点的右孩子 */
			/* paramNode != paramNode.parent.rightChild 已经以自己为起始节点比较了
			 * 根据 20-18-23，第一次比较，如果发现自己不是父亲的右孩子，则需要往上一层去需找
			 * 如果自己已经是右孩纸，则直接输出的是父节点*/
			while(paramNode.parent != null && paramNode != paramNode.parent.rightChild){
				paramNode = paramNode.parent;
			}
			if(paramNode.parent != null)
				predecessor = paramNode.parent.key;
			
		}
		System.out.println("====>>>Tree Node " + root.key + " predecessor is " + predecessor);
	}
}

