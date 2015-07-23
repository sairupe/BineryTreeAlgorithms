package treap.tree;

import avl.tree.AVLLeftRotate;
import avl.tree.AVLRightRotate;
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
		newNode.fix = randomFix;
		// ѭ����鸸�ڵ�
		while(newNode.parent != null){
			if(newNode.fix < ((TreapTreeNode)newNode.parent).fix){
				if(newNode == newNode.parent.leftChild){
					// ��������(RR)
					AVLRightRotate.rightRotate2(newNode);
				}
				else{
					// ��������(LL)
					AVLLeftRotate.leftRotate2(newNode);
				}
			}
		}
	}
	
	public static void main(String[] args){
		for(int node : TreapTreeRootNode.disorderTreeArray){
			treapInsert(TreapTreeRootNode.root, node);
		}
		TreapUtil.treapLDRShow(TreapTreeRootNode.root);
	}
}
