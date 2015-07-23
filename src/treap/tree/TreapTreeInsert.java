package treap.tree;

import avl.tree.AVLLeftRotate;
import avl.tree.AVLRightRotate;
import bsearch.tree.TreeNode;

/*
 * Treap树
 * 二叉树搜索树性质  + 最小堆性质
 * 二叉树搜索树性质： 根节点Key > 左孩子Key, 根节点Key < 右孩纸Key
 * 最小堆性质： 根节点的Fix修正值小于 左孩子Fix和右孩子的Fix
 * 
 * Treap树是一颗不平衡的树
 */
public class TreapTreeInsert {

	public static void treapInsert(TreeNode root, int insertKetValue){
		TreapTreeNode newNode = new TreapTreeNode(insertKetValue);
		TreeNode insertParentNode = root;
		TreeNode lastCheckNode = null;
		while(insertParentNode != null){// 找到某个节点，其左节点，或右节点为空
			lastCheckNode = insertParentNode;
			if(insertKetValue < insertParentNode.key)
				insertParentNode = insertParentNode.leftChild;
			else
				insertParentNode = insertParentNode.rightChild;
		}
		newNode.parent = lastCheckNode;// 这里赋值注意是lastCheckNode
		if(lastCheckNode == null){
			TreapTreeRootNode.root = newNode;
		}
		else if(newNode.key < lastCheckNode.key){
			lastCheckNode.leftChild = newNode;
		}
		else{
			lastCheckNode.rightChild = newNode;
		}
		// 随机修正权值
		int randomFix = TreapUtil.getRandomIntByRange(100);
		newNode.fix = randomFix;
		// 循环检查父节点
		while(newNode.parent != null){
			if(newNode.fix < ((TreapTreeNode)newNode.parent).fix){
				if(newNode == newNode.parent.leftChild){
					// 进行右旋(RR)
					AVLRightRotate.rightRotate2(newNode);
				}
				else{
					// 进行左旋(LL)
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
