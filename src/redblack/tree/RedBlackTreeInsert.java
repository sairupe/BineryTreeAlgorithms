package redblack.tree;

import avl.tree.AVLLeftRotate;
import avl.tree.AVLRightRotate;
import bsearch.tree.TreeNode;


public class RedBlackTreeInsert {
	
	
	/**
	 * 红黑树插入节点
	 * @param insertKeyValue
	 */
	public static void redBlackTreeInsert(int insertKeyValue){
		// 检查是否已经存在KEY相同的节点
//		if(BTreeSearch.searchNodeByKey(RedBlackTreeRootNode.rootNode, insertKeyValue) != null)
//			return;
		
		// 获取哨兵节点
		TreeNode y = NilNode.nilNode;
		// 为新节点赋值
		TreeNode newNode = new RedBlackTreeNode(insertKeyValue);
		((RedBlackTreeNode)newNode).color = Color.RED;
		newNode.leftChild = y;
		newNode.rightChild = y;
		// 获取根节点
		TreeNode x = RedBlackTreeRootNode.rootNode;
		// 寻找插入位置
		while(x != NilNode.nilNode){
			y = x;
			if(insertKeyValue < x.key){
				x = x.leftChild;
			}
			else{
				x = x.rightChild;
			}
		}
		
		if(y == NilNode.nilNode){ // 树为空，插入根节点
			RedBlackTreeRootNode.rootNode = newNode;
			newNode.parent = NilNode.nilNode;// 根节点的父亲节点是哨兵节点
		}
		else{
			x = newNode;// 为引用赋值
			x.parent = y;// 为新节点设置父亲节点
			RB_INSERT_FIX(newNode);
		}
	}
	
	/**
	 * 红黑树节点插入修正
	 */
	public static void RB_INSERT_FIX(TreeNode insertNode){
		RedBlackTreeNode x = (RedBlackTreeNode) insertNode;
		while(x.parent != NilNode.nilNode 
				&& ((RedBlackTreeNode)
						x.parent).color == Color.RED){// 父亲节点是红的
			if(x.parent == x.parent.parent.leftChild){// 父亲节点是爷节点的孩子
				RedBlackTreeNode y =  (RedBlackTreeNode) x.parent.parent.rightChild;// X的叔叔节点
				// CASE 1
				if(y.color == Color.RED){ // 如果叔叔节点是红的
					((RedBlackTreeNode) x.parent).color = Color.BLACK; // 父节点置黑
					y.color = Color.BLACK;// 叔叔节点置黑
					((RedBlackTreeNode) x.parent.parent).color = Color.RED;// 爷节点置红
					x = (RedBlackTreeNode) x.parent.parent;// X指向爷节点
				}
				// CASE 2 
				else if(x == x.parent.rightChild){ // X是父亲的右孩子
					x = (RedBlackTreeNode) x.parent;// 指向父节点
					AVLLeftRotate.leftRotate2(x);// 父节点进行 LL 旋转
				}
				// CASE 3
				((RedBlackTreeNode)x.parent).color = Color.BLACK;// 父节点置黑
				((RedBlackTreeNode)x.parent.parent).color = Color.RED;// 爷节点置红
				AVLRightRotate.rightRotate2(x.parent.parent);
				
			}
			// 左右相反的情况
			else if(x.parent == x.parent.parent.rightChild){// 父亲节点是爷节点的孩子
				RedBlackTreeNode y =  (RedBlackTreeNode) x.parent.parent.leftChild;// X的叔叔节点
				// CASE 1
				if(y.color == Color.RED){ // 如果叔叔节点是红的
					((RedBlackTreeNode) x.parent).color = Color.BLACK; // 父节点置黑
					y.color = Color.BLACK;// 叔叔节点置黑
					((RedBlackTreeNode) x.parent.parent).color = Color.RED;// 爷节点置红
					x = (RedBlackTreeNode) x.parent.parent;// X指向爷节点
				}
				// CASE 2 
				else if(x == x.parent.leftChild){ // X是父亲的右孩子
					x = (RedBlackTreeNode) x.parent;// 指向父节点
					AVLRightRotate.rightRotate2(x);// 父节点进行 LL 旋转
				}
				// CASE 3
				((RedBlackTreeNode)x.parent).color = Color.BLACK;// 父节点置黑
				((RedBlackTreeNode)x.parent.parent).color = Color.RED;// 爷节点置红
				AVLLeftRotate.leftRotate2(x.parent.parent);
			}
		}
		((RedBlackTreeNode)RedBlackTreeRootNode.rootNode).color = Color.BLACK;// 根节点置黑
	}
}
