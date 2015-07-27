package treap.tree;

import bsearch.tree.TreeNode;

/*
 * Treap��
 * ����������������  + ��С������
 * ���������������ʣ� ���ڵ�Key > ����Key, ���ڵ�Key < �Һ�ֽKey
 * ��С�����ʣ� ���ڵ��Fix����ֵС�� ����Fix���Һ��ӵ�Fix
 * 
 * Treap����һ�Ų�ƽ�����
 */
public class TreapTreeInsert {

	public static void treapInsert(TreeNode root, int insertKetValue){
		TreapTreeNode newNode = new TreapTreeNode(insertKetValue);
		TreeNode insertParentNode = root;
		TreeNode lastCheckNode = null;
		while(insertParentNode != null){// �ҵ�ĳ���ڵ㣬����ڵ㣬���ҽڵ�Ϊ��
			lastCheckNode = insertParentNode;
			if(insertKetValue < insertParentNode.key)
				insertParentNode = insertParentNode.leftChild;
			else
				insertParentNode = insertParentNode.rightChild;
		}
		newNode.parent = lastCheckNode;// ���︳ֵע����lastCheckNode
		if(lastCheckNode == null){
			TreapTreeRootNode.root = newNode;
		}
		else if(newNode.key < lastCheckNode.key){
			lastCheckNode.leftChild = newNode;
		}
		else{
			lastCheckNode.rightChild = newNode;
		}
		// �������Ȩֵ
		int randomFix = TreapUtil.getRandomIntByRange(100);
		// ========TEST===============
		if(insertKetValue == 17){
			randomFix = 50;
		}
		else if(insertKetValue == 3){
			randomFix = 60;
		}
		else if(insertKetValue == 22){
			randomFix = 40;
		}
		// ========TEST===============
		newNode.fix = randomFix;
		// ѭ����鸸�ڵ�
		TreeNode checkParent = newNode.parent;
		while(checkParent != null){
			if(newNode.fix < ((TreapTreeNode)newNode.parent).fix){
				if(newNode == newNode.parent.leftChild){
					// ��������(RR)
					checkParent = TreapRightRotate.rightRotate(newNode.parent);// ���ݸ��ڵ������ת
				}
				else{
					// ��������(LL)
					checkParent = TreapLeftRotate.leftRotate(newNode.parent);// ���ݸ��ڵ������ת
				}
			}
			checkParent = checkParent.parent;
		}
	}
	
	public static void main(String[] args){
		for(int node : TreapTreeRootNode.disorderTreeArray){
			treapInsert(TreapTreeRootNode.root, node);
		}
		TreapUtil.treapLDRShow(TreapTreeRootNode.root);
	}
}
