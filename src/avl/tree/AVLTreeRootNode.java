package avl.tree;

import common.CommonUtil;

import bsearch.tree.LDR;
import bsearch.tree.TreeNode;

public class AVLTreeRootNode {

	public static TreeNode root;// 不带高度的树
	public static TreeNode avlRoot;// 带高度的不同方法构建的树
	public static int[] avlTreeArray={2,3,4,6,7,9,11,12,14,17,18,19,22};
	// AVL-Tree                                          
	//                    7                      
	//              4            11                 
	//           3     6     9        18            
	//        2                   14      19      
	//						   12    17       22
	//                                      20            
	public AVLTreeRootNode(){// TMD 
		root = new TreeNode(7);
		
		TreeNode key4 = new TreeNode(4);
		TreeNode key11 = new TreeNode(11);
		
		TreeNode key3 = new TreeNode(3);
		TreeNode key6 = new TreeNode(6);
		TreeNode key9 = new TreeNode(9);
		TreeNode key18 = new TreeNode(18);
		
		TreeNode key2 = new TreeNode(2);
		TreeNode key14 = new TreeNode(14);
		TreeNode key19 = new TreeNode(19);
		
		TreeNode key12 = new TreeNode(12);
		TreeNode key17 = new TreeNode(17);
		TreeNode key22 = new TreeNode(22);
		
		TreeNode key20 = new TreeNode(20);
		
		root.leftChild = key4;
		root.rightChild = key11;
		key4.parent = root;
		key4.leftChild = key3;
		key4.rightChild = key6;
		key11.parent = root;
		key11.leftChild = key9;
		key11.rightChild = key18;
		
		key3.parent = key4;
		key3.leftChild = key2;
		key6.parent = key4;
		key9.parent = key11;
		key18.parent = key11;
		key18.leftChild = key14;
		key18.rightChild = key19;
		
		key2.parent = key3;
		key14.parent = key18;
		key14.leftChild = key12;
		key14.rightChild = key17;
		key19.parent = key18;
		key19.rightChild = key22;
		
		key12.parent = key14;
		key17.parent = key14;
		key22.parent = key19;
		
		key20.parent = key22;
	}
	
	public static void main(String args[]){
//		AVLTreeRootNode root = new AVLTreeRootNode();
		TreeNode AVLTreeRootNode = CommonUtil.buildBinarySearchTreeByIntArray(avlTreeArray);
		LDR.LDRShow(AVLTreeRootNode);
	}
}
