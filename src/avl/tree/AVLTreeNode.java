package avl.tree;

import bsearch.tree.TreeNode;;

public class AVLTreeNode extends TreeNode {
	
	public int banlanceFatory;// 平衡因子，自己写的
	public int height; // 树的高度，递归算法用到

	public AVLTreeNode(int key) {
		super(key);
	}
	
	@Override
	public String toString() {
		String left = leftChild == null ? "" : leftChild.key + "";
		String right = rightChild == null ? "" : rightChild.key + "";
		return key + " L:" + left + 
					 " R:" + right + " H:" + height;
	}
}
