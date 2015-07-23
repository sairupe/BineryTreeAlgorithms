package bsearch.tree;

public class BSearchTreeUtil {
	/**
	 * 需找后继节点
	 * @param root
	 */
	public static TreeNode searchSuccessor(TreeNode root){
		TreeNode successor = null;
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
				successor = paramNode.parent;
		}
		return successor;
	}
	
	/**
	 * 搜寻传入参数的二叉查找树中最小的节点
	 * @param root
	 * @return
	 */
	public static TreeNode searchMin(TreeNode root){
		if(root.leftChild != null){
			return searchMin(root.leftChild);
		}
		return root;
	}
}
