package avl.tree;

import bsearch.tree.BTreeSearch;
import bsearch.tree.TreeNode;

public class AVLInsert {
	
	/**
	 * 递归算法
	 * @param grandFatherNode 插入新节点的爷节点(当最后insertParentNode == null，退化成父节点，这个主要为新节点赋值PARENT)
	 * @param insertParentNode 插入新节点的父节点(当最后insertParentNode == null，退化要新生成的节点)
	 * @param insertKeyValue 插入关键字的值
	 */
	// TODO grandFatherNode实际上可以省略
	public static TreeNode avlInsert2(
			TreeNode insertGrandFatherNode,
			TreeNode insertParentNode, 
			int insertKeyValue) {
		if(insertKeyValue == 12){
			System.out.println();
		}
		if(insertGrandFatherNode != null 
				&& insertParentNode != null
				&& insertGrandFatherNode.key == 6 
				&& insertParentNode.key == 11){
			System.out.println();
		}
		if(insertParentNode == null){
			if(AVLTreeRootNode.avlRoot == null){
				AVLTreeRootNode.avlRoot = new AVLTreeNode(insertKeyValue);
				//return AVLTreeRootNode.avlRoot;
			}
			else{
				insertParentNode = new AVLTreeNode(insertKeyValue);
				insertParentNode.parent = insertGrandFatherNode;
				//return insertParentNode;
			}
		}
		
		if(BTreeSearch.searchNodeByKey(AVLTreeRootNode.avlRoot, insertKeyValue) != null){
			return AVLTreeRootNode.avlRoot;// 不允许添加相同节点
		}
		else{
			if(insertKeyValue < insertParentNode.key){// 插入到左子树
				insertParentNode.leftChild = avlInsert2(insertParentNode, insertParentNode.leftChild, insertKeyValue);// 递归调用
				// 检查是否失去平衡
				if(getHeight(insertParentNode.leftChild) - getHeight(insertParentNode.rightChild) == 2){
					if(insertKeyValue < insertParentNode.leftChild.key){
						// 进行RR(右旋)调整
						insertParentNode = AVLRightRotate.rightRotate2(insertParentNode);
					}
					else{
						// 进行LL(左旋)调整
						insertParentNode = AVLRightRotate.rightRotate2(insertParentNode);
					}
				}
			}else if(insertKeyValue > insertParentNode.key){
				insertParentNode.rightChild = avlInsert2(insertParentNode, insertParentNode.rightChild, insertKeyValue);// 递归调用
				// 检查是否失去平衡(此时HIGHT还没有+1的，这里是因为进到函数提前判断失衡)
				if(getHeight(insertParentNode.rightChild) - getHeight(insertParentNode.leftChild) == 2){
					if(insertKeyValue > insertParentNode.rightChild.key){
						// 进行LL(左旋)调整
						insertParentNode = AVLLeftRotate.leftRotate2(insertParentNode);
					}
					else{
						// 进行RR(右旋)调整
						insertParentNode = AVLRightRotate.rightRotate2(insertParentNode);
					}
				}
			}
		}
		
		((AVLTreeNode)insertParentNode).height 
				= max(getHeight(insertParentNode.leftChild),
						getHeight(insertParentNode.rightChild)) + 1;
		return insertParentNode;
	}
	
	/**
	 * 原来写的非递归算法，未实现，这里根据的是平衡因子，而递归则是高度
	 * @param insertKeyValue
	 */
	//TODO
	@Deprecated
	public static void avlInsert(int insertKeyValue) {

		if (AVLTreeRootNode.avlRoot == null) {
			AVLTreeRootNode.avlRoot = new AVLTreeNode(insertKeyValue);
		} else if (BTreeSearch.searchNodeByKey(AVLTreeRootNode.avlRoot,
				insertKeyValue) != null) {
			return;// 不允许添加相同节点
		} else {
			TreeNode insertNode = AVLTreeRootNode.avlRoot;
			if (AVLTreeRootNode.avlRoot == null) {
				AVLTreeRootNode.avlRoot = new AVLTreeNode(insertKeyValue);
				return;
			}
			TreeNode insertParentNode = null;
			while (insertNode != null) {
				if (insertNode.key > insertKeyValue
						&& insertNode.leftChild != null) {
					((AVLTreeNode) insertNode).banlanceFatory++;// 往左边插平衡因子增大
					insertParentNode = insertNode;
					insertNode = insertNode.leftChild;
				} else if (insertNode.key < insertKeyValue) {
					((AVLTreeNode) insertNode).banlanceFatory--;// 往左边插平衡因子增大
					insertParentNode = insertNode;
					insertNode = insertNode.rightChild;
				}
			}

			boolean insertLeft = true;
			if (insertKeyValue < insertParentNode.key) {
				insertParentNode.leftChild = new AVLTreeNode(insertKeyValue);
				insertParentNode.leftChild.parent = insertParentNode;
			} else {
				insertParentNode.rightChild = new AVLTreeNode(insertKeyValue);
				insertParentNode.rightChild.parent = insertParentNode;
				insertLeft = false;
			}

			// TODO
			// 应该回溯到根节点一路调整，看了别人的有用递归，这里再思考下
			// 判断平衡性，关于LR,RL自己画个图旋转下就知道啦
			AVLTreeNode insertGrandFatherNode = (AVLTreeNode) insertParentNode.parent;
			// 以 左子树高度 - 右子树 高度为计算
			if (insertGrandFatherNode != null
					&& insertGrandFatherNode.banlanceFatory == 2) {// 根节点插入根本不用理
				if (insertLeft) {// 进行RR调整
					AVLRightRotate.rightRotate2(insertGrandFatherNode);
				} else {// LR调整
					AVLLeftRotate.leftRotate2(insertParentNode);
					AVLRightRotate.rightRotate2(insertGrandFatherNode);
				}
			} else if (insertGrandFatherNode != null
					&& insertGrandFatherNode.banlanceFatory == -2) {
				if (!insertLeft) {// 进行LL调整
					AVLLeftRotate.leftRotate(insertGrandFatherNode);
				} else {// RL调整
					AVLRightRotate.rightRotate2(insertParentNode);
					AVLLeftRotate.leftRotate2(insertGrandFatherNode);
				}
			}
		}
	}
	
	/**
	 * 这里如果子树为空的话，高度返回为什么为-1，因为这是个递归插入的算法，而且高度是在函数末尾才更新的
	 * 例如要插入4时,如图
	 * 2 (h:1)
	 *   3 (h:0)
	 *     4
	 * 插入4完成后，3的h更新为1，此时返回2节点进行平衡判断， 此时2NodeLeftHeight = 0,2NodeRightHeight = 1;
	 * 1 - 0 = 1, 并不满足平衡性调整条件，但实际上已经需要左旋了
	 * 
	 * 而如果只有一个子树为空的情况下，在另一个子树下插入节点，必定是失衡的
	 * 故这个返回值可同时用于满足失衡条件判断和让新节点高度置0
	 * @param node
	 * @return
	 */
	public static int getHeight(TreeNode node){
		if(node == null){
			return -1;
		}
		return ((AVLTreeNode)node).height;
	}
	
	public static int max(int a, int b){
		return a > b ? a : b;
	}
}
