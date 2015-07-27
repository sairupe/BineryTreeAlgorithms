package treap.tree;

import bsearch.tree.TreeNode;

public class TreapRightRotate {

	public static TreeNode rightRotate(TreeNode rotationNode){

		TreeNode leftChild = rotationNode.leftChild;
		
		rotationNode.leftChild = leftChild.rightChild;// �ƶ�ԭ�ڵ������������ӵ�ԭ�ڵ���Һ���λ��
		if(leftChild.rightChild != null){
			leftChild.rightChild.parent = rotationNode;
		}
		// �����ת���Ǹ��ڵ�
		leftChild.parent = rotationNode.parent;
		if(rotationNode.parent == null){
			//AVLTreeRootNode.root = leftChild;
			TreapTreeRootNode.root = leftChild;
		}
		// ����������֧���Ҵ��֧������������Ҫ�ж���ת�ڵ������ӻ����Һ���
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
