package treap.tree;

import bsearch.tree.TreeNode;

public class TreapLeftRotate {
	
	public static TreeNode leftRotate(TreeNode rotationNode){
		TreeNode rightChild = rotationNode.rightChild;
		rotationNode.rightChild = rightChild.leftChild;// �ƶ�ԭ�ڵ������������ӵ�ԭ�ڵ���Һ���λ��
		if (rightChild.leftChild != null) {
			rightChild.leftChild.parent = rotationNode;
		}
		// �����ת���Ǹ��ڵ�
		rightChild.parent = rotationNode.parent;
		if (rotationNode.parent == null) {
			//AVLTreeRootNode.root = rightChild;
			TreapTreeRootNode.root = rightChild;
		}
		// ����������֧���Ҵ��֧������������Ҫ�ж���ת�ڵ������ӻ����Һ���
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
