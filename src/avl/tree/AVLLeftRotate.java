package avl.tree;

import bsearch.tree.BTreeSearch;
import bsearch.tree.LDR;
import bsearch.tree.TreeNode;

public class AVLLeftRotate {

	public static void main(String[] args) {
		AVLTreeRootNode rootNode = new AVLTreeRootNode();
		LDR.LDRShow(rootNode.root);
		TreeNode rotateNode = BTreeSearch.searchNodeByKey(rootNode.root, 4);
		leftRotate(rotateNode);
		LDR.LDRShow(rootNode.root);
	}

	// AVL-Tree                                          
	//                    7                      
	//              4            11                 
	//           3     6     9        18            
	//        2                   14      19      
	//						   12    17       22
	//                                      20        
	//
	//		  2,3,4,6,7,9,11,12,14,17,18,19,22
	// TODO 正确性验证
	
	// 1. 旋转节点右子树指向旋转节点父节点
	// 2. 根据旋转节点位置（为左子树或右子树），让旋转节点的父节点指向旋转节点右子树
	// 3. 旋转节点的父节点指向自己的右孩子
	// 4. 旋转节点的右子树为旋转节点右子树的左孩子
	// 5. 旋转节点的右子树的 左子树 为自己
	public static void leftRotate(TreeNode rotationNode){
		rotationNode.rightChild.parent = rotationNode.parent;// 更改右子树父节点指针
		if(rotationNode.parent == null){
			AVLTreeRootNode.root = rotationNode.rightChild;
		}
		else{
			if(rotationNode == rotationNode.parent.leftChild){
				rotationNode.parent.leftChild = rotationNode.rightChild;// 更改自己父类为左子树
			}
			else if(rotationNode == rotationNode.parent.rightChild){
				rotationNode.parent.rightChild = rotationNode.rightChild;// 更改自己父类为右子树
			}
		}
		rotationNode.parent = rotationNode.rightChild;// 更改原节点的父节点为原节点右孩子
		// 旋转后左节点为原左子树的右节点
		// 与书上的相比，这里减少空指针的判断而直接赋值
		rotationNode.rightChild = rotationNode.parent.leftChild;
		rotationNode.parent.leftChild = rotationNode;// 原左子树的右孩子现在是自己
		// AVL-Tree                                          
		//                      7                      
		//             3                 18                 
		//          2     4          11        19            
		//                  6      9     14        22      
		//					           12   17   20
		// 
		//			2,3,4,6,7,9,11,12,14,17,18,19,20,22
	}
	
	// 1. 旋转节点的右子树为旋转节点右子树的左孩子
	// 2. 旋转节点右子树指向旋转节点父节点
	// 3. 根据旋转节点位置（为左子树或右子树），让旋转节点的父节点指向旋转节点右子树
	// 4. 旋转节点的右子树的 左子树 为自己
	// 5. 旋转节点的父节点指向自己的右孩子
	public static TreeNode leftRotate2(TreeNode rotationNode){
		TreeNode rightChild = rotationNode.rightChild;
		rotationNode.rightChild = rightChild.leftChild;// 移动原节点右子树的左孩子到原节点的右孩子位置
		if (rightChild.leftChild != null) {
			rightChild.leftChild.parent = rotationNode;
		}
		// 如果旋转的是根节点
		rightChild.parent = rotationNode.parent;
		if (rotationNode.parent == null) {
			//AVLTreeRootNode.root = rightChild;
			AVLTreeRootNode.avlRoot = rightChild;
		}
		// 可能在左大分支和右大分支进行左旋，故要判断旋转节点是左孩子还是右孩子
		else if (rotationNode == rotationNode.parent.leftChild) {
			rotationNode.parent.leftChild = rightChild;
		} else {
			rotationNode.parent.rightChild = rightChild;
		}
		rightChild.leftChild = rotationNode;
		rotationNode.parent = rightChild;
		
		// 重新定义调整高度，别忘记了!!!!!
		((AVLTreeNode)rotationNode).height 
			= AVLInsert.max(AVLInsert.getHeight(rotationNode.leftChild),
					AVLInsert.getHeight(rotationNode.rightChild)) + 1;
		((AVLTreeNode)rightChild).height 
			= AVLInsert.max(AVLInsert.getHeight(rotationNode.leftChild),
					AVLInsert.getHeight(rotationNode.rightChild)) + 1;
		return rightChild;
	}
}
