package treap.tree;

import bsearch.tree.TreeNode;

public class TreapRightRotate {

	public static TreeNode rightRotate(TreeNode rotationNode){

		TreeNode leftChild = rotationNode.leftChild;
		
		rotationNode.leftChild = leftChild.rightChild;// 移动原节点右子树的左孩子到原节点的右孩子位置
		if(leftChild.rightChild != null){
			leftChild.rightChild.parent = rotationNode;
		}
		// 如果旋转的是根节点
		leftChild.parent = rotationNode.parent;
		if(rotationNode.parent == null){
			//AVLTreeRootNode.root = leftChild;
			TreapTreeRootNode.root = leftChild;
		}
		// 可能在左大分支和右大分支进行左旋，故要判断旋转节点是左孩子还是右孩子
		else if(rotationNode == rotationNode.parent.leftChild){
			rotationNode.parent.leftChild = leftChild;
		}
		else{
			rotationNode.parent.rightChild = leftChild;
		}
		leftChild.rightChild = rotationNode;
		rotationNode.parent = leftChild;
		
		return leftChild;
	}
}
