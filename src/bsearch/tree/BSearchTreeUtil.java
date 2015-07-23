package bsearch.tree;

public class BSearchTreeUtil {
	/**
	 * ���Һ�̽ڵ�
	 * @param root
	 */
	public static TreeNode searchSuccessor(TreeNode root){
		TreeNode successor = null;
		/* ������������ڵĻ����򷵻������������Ľڵ㣬��Ϊ����С��֮�е����Ľڵ� */
		if(root.rightChild != null){
			successor = searchMin(root.rightChild);
		}
		else{// ͬ��������ǰ��
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
	 * ��Ѱ��������Ķ������������С�Ľڵ�
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
