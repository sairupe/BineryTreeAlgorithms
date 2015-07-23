package avl.tree;

import bsearch.tree.BTreeSearch;
import bsearch.tree.LDR;
import bsearch.tree.TreeNode;

public class AVLRightRotate {

	public static void main(String[] args) {
		AVLTreeRootNode rootNode = new AVLTreeRootNode();
		LDR.LDRShow(rootNode.root);
		TreeNode rotateNode = BTreeSearch.searchNodeByKey(rootNode.root, 4);
		rightRotate(rotateNode);
		LDR.LDRShow(rootNode.root);
	}

	// AVL-Tree                                          
	//                    7                      
	//              4            11                 
	//           3     6     9        18            
	//        2                   14      19      
	//						   12    17       22
	//                                      20    
	
	@Deprecated
	//    18
	//  14
	// 12
	// 这种情况不太行，39行报空指针
	public static void rightRotate(TreeNode rotationNode){
//		if(rotationNode.leftChild != null && rotationNode.parent != null){
//			rotationNode.leftChild.parent = rotationNode.parent;// 更改左子树父节点指针
//			rotationNode.parent.leftChild = rotationNode.leftChild;// 更改父节点左子树指针
//			rotationNode.parent = rotationNode.leftChild;// 更改自己父类为左子树
//			rotationNode.leftChild = rotationNode.parent.rightChild;// 旋转后左节点为原左子树的右节点
//			rotationNode.parent.rightChild = null;// 原左子树的右节点清空
//			rotationNode.parent.rightChild = rotationNode;// 原左子树的右孩子现在是自己
//		}
		rotationNode.leftChild.parent = rotationNode.parent;// 更改右子树父节点指针
		if(rotationNode.parent == null){
			AVLTreeRootNode.root = rotationNode.leftChild;
		}
		else{
			if(rotationNode == rotationNode.parent.leftChild){
				rotationNode.parent.leftChild = rotationNode.leftChild;// 更改自己父类为左子树
			}
			else if(rotationNode == rotationNode.parent.rightChild){
				rotationNode.parent.rightChild = rotationNode.leftChild;// 更改自己父类为右子树
			}
		}
		rotationNode.parent = rotationNode.leftChild;// 更改原节点的父节点为原节点右孩子
		// 旋转后左节点为原左子树的右节点
		// 与书上的相比，这里减少空指针的判断而直接赋值
		rotationNode.leftChild = rotationNode.parent.rightChild;
		rotationNode.parent.rightChild = rotationNode;// 原左子树的右孩子现在是自己
		// AVL-Tree                                          
		//                    7                      
		//              3            11                 
		//           2     4     9        18            
		//                   6        14      19      
		//						   12    17       22
		// 
	}
	
	// 1. 旋转节点的右子树为旋转节点右子树的左孩子
		// 2. 旋转节点右子树指向旋转节点父节点
		// 3. 根据旋转节点位置（为左子树或右子树），让旋转节点的父节点指向旋转节点右子树
		// 4. 旋转节点的右子树的 左子树 为自己
		// 5. 旋转节点的父节点指向自己的右孩子
		public static TreeNode rightRotate2(TreeNode rotationNode){
			TreeNode leftChild = rotationNode.leftChild;
			rotationNode.leftChild = leftChild.rightChild;// 移动原节点右子树的左孩子到原节点的右孩子位置
			if(leftChild.rightChild != null){
				leftChild.rightChild.parent = rotationNode;
			}
			// 如果旋转的是根节点
			leftChild.parent = rotationNode.parent;
			if(rotationNode.parent == null){
				//AVLTreeRootNode.root = leftChild;
				AVLTreeRootNode.avlRoot = leftChild;
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
}
