package treap.tree;

import bsearch.tree.TreeNode;

public class TreapLeftRotate {
	
	public static TreeNode leftRotate(TreeNode rotationNode){
		TreeNode rightChild = rotationNode.rightChild;
		rotationNode.rightChild = rightChild.leftChild;// 移动原节点右子树的左孩子到原节点的右孩子位置
		if (rightChild.leftChild != null) {
			rightChild.leftChild.parent = rotationNode;
		}
		// 如果旋转的是根节点
		rightChild.parent = rotationNode.parent;
		if (rotationNode.parent == null) {
			//AVLTreeRootNode.root = rightChild;
			TreapTreeRootNode.root = rightChild;
		}
		// 可能在左大分支和右大分支进行左旋，故要判断旋转节点是左孩子还是右孩子
		else if (rotationNode == rotationNode.parent.leftChild) {
			rotationNode.parent.leftChild = rightChild;
		} else {
			rotationNode.parent.rightChild = rightChild;
		}
		rightChild.leftChild = rotationNode;
		rotationNode.parent = rightChild;
		
		return rightChild;
	}
}
