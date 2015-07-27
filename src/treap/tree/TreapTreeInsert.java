package treap.tree;

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
		// 循环检查父节点
		TreeNode checkParent = newNode.parent;
		while(checkParent != null){
			if(newNode.fix < ((TreapTreeNode)newNode.parent).fix){
				if(newNode == newNode.parent.leftChild){
					// 进行右旋(RR)
					checkParent = TreapRightRotate.rightRotate(newNode.parent);// 根据父节点进行旋转
				}
				else{
					// 进行左旋(LL)
					checkParent = TreapLeftRotate.leftRotate(newNode.parent);// 根据父节点进行旋转
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
