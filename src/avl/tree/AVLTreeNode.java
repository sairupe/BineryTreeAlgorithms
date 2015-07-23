package avl.tree;

import bsearch.tree.TreeNode;;

public class AVLTreeNode extends TreeNode {
	
	public int banlanceFatory;// ƽ�����ӣ��Լ�д��
	public int height; // ���ĸ߶ȣ��ݹ��㷨�õ�

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
