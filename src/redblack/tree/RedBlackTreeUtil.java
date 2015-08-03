package redblack.tree;

import bsearch.tree.TreeNode;

public class RedBlackTreeUtil {
	
	public static void RB_LDR(TreeNode rbNode){
		if(rbNode.leftChild != NilNode.nilNode)
			RB_LDR(rbNode.leftChild);
		System.out.print(rbNode.toString());
		if(rbNode.rightChild != NilNode.nilNode)
			RB_LDR(rbNode.rightChild);
	}
	
	public static TreeNode leftRotate2(TreeNode rotationNode, int rootType){
		TreeNode rightChild = rotationNode.rightChild;
		rotationNode.rightChild = rightChild.leftChild;// 移动原节点右子树的左孩子到原节点的右孩子位置
		if (rightChild.leftChild != NilNode.nilNode) {
			rightChild.leftChild.parent = rotationNode;
		}
		// 如果旋转的是根节点
		rightChild.parent = rotationNode.parent;
		if (rotationNode.parent == NilNode.nilNode) {
			if(rootType == RedBlackTreeRootNode.P168)
				RedBlackTreeRootNode.rootNodeP168 = rightChild;
			else if(rootType == RedBlackTreeRootNode.CASE12)
				RedBlackTreeRootNode.rootDeleteCase12 = rightChild;
			else if(rootType == RedBlackTreeRootNode.CASE134)
				RedBlackTreeRootNode.rootDeleteCase134 = rightChild;
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
	
	public static TreeNode rightRotate2(TreeNode rotationNode, int rootType){
		TreeNode leftChild = rotationNode.leftChild;
		rotationNode.leftChild = leftChild.rightChild;// 移动原节点右子树的左孩子到原节点的右孩子位置
		if(leftChild.rightChild != NilNode.nilNode){
			leftChild.rightChild.parent = rotationNode;
		}
		// 如果旋转的是根节点
		leftChild.parent = rotationNode.parent;
		if(rotationNode.parent == NilNode.nilNode){
			if(rootType == RedBlackTreeRootNode.P168)
				RedBlackTreeRootNode.rootNodeP168 = leftChild;
			else if(rootType == RedBlackTreeRootNode.CASE12)
				RedBlackTreeRootNode.rootDeleteCase12 = leftChild;
			else if(rootType == RedBlackTreeRootNode.CASE134)
				RedBlackTreeRootNode.rootDeleteCase134 = leftChild;
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
	
	public static void main(String[] args){
		RB_LDR(RedBlackTreeRootNode.rootNodeP168);
	}
}
