package bsearch.tree;
/**
 * @author Zh
 * 二叉查找树插入算法(目前只支持不重复KEY插入)
 */
public class BTreeInsert {

	// B-Tree                                          
	//                  15                      
	//              5        16                 
	//           3     12        20            
	//              10        18    23        
	//            6                                  
	//              7          
	public static void main(String[] args) {
		BSearchTreeRootNode root = new BSearchTreeRootNode();
		insert(root.rootNode, 11);
		LDR.LDR_UnRecursive(root.rootNode);
		System.out.println();
		LDR.LDRShow(root.rootNode);
	}

	/**
	 * 
	 * @param root 二叉树根节点
	 * @param key 关键字的值
	 * @return 新插入的节点
	 */
	public static TreeNode insert(TreeNode root, int key){
		TreeNode newNode = new TreeNode(key);
		TreeNode insertParentNode = root;
		TreeNode lastCheckNode = null;
		while(insertParentNode != null){// 找到某个节点，其左节点，或右节点为空
			lastCheckNode = insertParentNode;
			if(key < insertParentNode.key)
				insertParentNode = insertParentNode.leftChild;
			else
				insertParentNode = insertParentNode.rightChild;
		}
		newNode.parent = lastCheckNode;// 这里赋值注意是lastCheckNode
		if(lastCheckNode == null){
			BSearchTreeRootNode.rootNode = newNode;
		}
		else if(newNode.key < lastCheckNode.key){
			lastCheckNode.leftChild = newNode;
		}
		else{
			lastCheckNode.rightChild = newNode;
		}
		return newNode;
	}
}
