package redblack.tree;

import bsearch.tree.TreeNode;


public class RedBlackTreeRootNode {
	
	static{
		buildRedBlackTreeP168();
		buildDeleteCase12();
		buildDeleteCase134();
	}
	
	// P168 的图 13-4构造红黑树
	public static TreeNode rootNodeP168;
	// 进入CASE 2的一组红黑树
	public static TreeNode rootDeleteCase12;
	// 跳过CASE 2的一组红黑树
	public static TreeNode rootDeleteCase134;
	
	/**
	 * P168 的图 13-4构造红黑树，目标插入的节点为4
	 */
	// RB-Tree                                          
	//                    11(B)                      
	//              2(R)          14(B)                 
	//          1(B)     7(B)          15(R)            
	//				 5(R)    8(R)
	//insert--->  4(R)
	//
	public static void buildRedBlackTreeP168(){

		RedBlackTreeNode k11 = new RedBlackTreeNode(11);
		RedBlackTreeNode k2 = new RedBlackTreeNode(2);
		RedBlackTreeNode k14 = new RedBlackTreeNode(14);
		RedBlackTreeNode k1 = new RedBlackTreeNode(1);
		RedBlackTreeNode k7 = new RedBlackTreeNode(7);
		RedBlackTreeNode k15 = new RedBlackTreeNode(15);
		RedBlackTreeNode k5 = new RedBlackTreeNode(5);
		RedBlackTreeNode k8 = new RedBlackTreeNode(8);
		
		k11.color = Color.BLACK;
		k2.color = Color.RED;
		k14.color = Color.BLACK;
		k1.color = Color.BLACK;
		k7.color = Color.BLACK;
		k15.color = Color.RED;
		k5.color = Color.RED;
		k8.color = Color.RED;
		
		k11.parent = NilNode.nilNode;
		k11.leftChild = k2;
		k11.rightChild = k14;
		
		k2.parent = k11;
		k2.leftChild = k1;
		k2.rightChild = k7;
		
		k14.parent = k11;
		k14.leftChild = NilNode.nilNode;
		k14.rightChild = k15;
		
		k1.parent = k2;
		k1.leftChild = k1.rightChild = NilNode.nilNode;
		
		k7.parent = k2;
		k7.leftChild = k5;
		k7.rightChild = k8;
		
		k15.parent = k14;
		k15.leftChild = k15.rightChild = NilNode.nilNode;
		
		k5.parent = k7;
		k5.leftChild = k5.rightChild = NilNode.nilNode;
		
		k8.parent = k7;
		k8.leftChild = k8.rightChild = NilNode.nilNode;
		
		rootNodeP168 = k11;
	}
	
	
	// RB-Tree, x is childTree, y is to delete, initial is balance                                   
	//                      3(B)                      
	//y------------>  2(B)          7(R)                 
	//x--------> 1(B)         5(B)       8(B)            
	//				      4(B)    6(B)       9(B)
	//
	public static TreeNode buildDeleteCase12(){
		
		RedBlackTreeNode k1 = new RedBlackTreeNode(1);
		RedBlackTreeNode k2 = new RedBlackTreeNode(2);
		RedBlackTreeNode k3 = new RedBlackTreeNode(3);
		RedBlackTreeNode k4 = new RedBlackTreeNode(4);
		RedBlackTreeNode k5 = new RedBlackTreeNode(5);
		RedBlackTreeNode k6 = new RedBlackTreeNode(6);
		RedBlackTreeNode k7 = new RedBlackTreeNode(7);
		RedBlackTreeNode k8 = new RedBlackTreeNode(8);
		RedBlackTreeNode k9 = new RedBlackTreeNode(9);
		
		k3.parent = NilNode.nilNode;
		k3.color = Color.BLACK;
		k3.leftChild = k2;
		k3.rightChild = k7;
		
		k2.parent = k3;
		k2.color = Color.BLACK;
		k2.leftChild = k1;
		k2.rightChild = NilNode.nilNode;
		
		k7.parent = k3;
		k7.color = Color.RED;
		k7.leftChild = k5;
		k7.rightChild = k8;
		
		k1.parent = k2;
		k1.color = Color.BLACK;
		k1.leftChild = NilNode.nilNode;
		k1.rightChild = NilNode.nilNode;
		
		k5.parent = k7;
		k5.color = Color.BLACK;
		k5.leftChild = k4;
		k5.rightChild = k6;
		
		k8.parent = k7;
		k8.color = Color.BLACK;
		k8.leftChild = NilNode.nilNode;
		k8.rightChild = k9;
		
		k4.parent = k5;
		k4.color = Color.BLACK;
		k4.leftChild = NilNode.nilNode;
		k4.rightChild = NilNode.nilNode;
		
		k6.parent = k5;
		k6.color = Color.BLACK;
		k6.leftChild = NilNode.nilNode;
		k6.rightChild = NilNode.nilNode;
		
		k9.parent = k8;
		k9.color = Color.BLACK;
		k9.leftChild = NilNode.nilNode;
		k9.rightChild = NilNode.nilNode;
		
		rootDeleteCase12 = k3;
		return rootDeleteCase12; 
	}
	
	// RB-Tree, x is childTree, y is to delete, initial is balance                                   
	//                      3(B)                      
	//y------------>  2(B)          8(R)                 
	//x--------> 1(B)         6(B)      9(B)            
	//				      5(R)    7(B)     10(B)
	//                 4(B)
	//
	public static TreeNode buildDeleteCase134(){

		RedBlackTreeNode k1 = new RedBlackTreeNode(1);
		RedBlackTreeNode k2 = new RedBlackTreeNode(2);
		RedBlackTreeNode k3 = new RedBlackTreeNode(3);
		RedBlackTreeNode k4 = new RedBlackTreeNode(4);
		RedBlackTreeNode k5 = new RedBlackTreeNode(5);
		RedBlackTreeNode k6 = new RedBlackTreeNode(6);
		RedBlackTreeNode k7 = new RedBlackTreeNode(7);
		RedBlackTreeNode k8 = new RedBlackTreeNode(8);
		RedBlackTreeNode k9 = new RedBlackTreeNode(9);
		RedBlackTreeNode k10 = new RedBlackTreeNode(10);
		
		k3.parent = NilNode.nilNode;
		k3.color = Color.BLACK;
		k3.leftChild = k2;
		k3.rightChild = k8;
		
		k2.parent = k3;
		k2.color = Color.BLACK;
		k2.leftChild = k1;
		k2.rightChild = NilNode.nilNode;
		
		k8.parent = k3;
		k8.color = Color.RED;
		k8.leftChild = k6;
		k8.rightChild = k9;
		
		k1.parent = k2;
		k1.color = Color.BLACK;
		k1.leftChild = NilNode.nilNode;
		k1.rightChild = NilNode.nilNode;
		
		k6.parent = k8;
		k6.color = Color.BLACK;
		k6.leftChild = k5;
		k6.rightChild = k7;
		
		k9.parent = k8;
		k9.color = Color.BLACK;
		k9.leftChild = NilNode.nilNode;
		k9.rightChild = k10;
		
		k5.parent = k6;
		k5.color = Color.RED;
		k5.leftChild = k4;
		k5.rightChild = NilNode.nilNode;
		
		k7.parent = k6;
		k7.color = Color.BLACK;
		k7.leftChild = NilNode.nilNode;
		k7.rightChild = NilNode.nilNode;
		
		k10.parent = k9;
		k10.color = Color.BLACK;
		k10.leftChild = NilNode.nilNode;
		k10.rightChild = NilNode.nilNode;
		
		k4.parent = k5;
		k4.color = Color.BLACK;
		k4.leftChild = NilNode.nilNode;
		k4.rightChild = NilNode.nilNode;
		
		rootDeleteCase12 = k3;
		return rootDeleteCase134;  
	}
	
	
	public static void main(String[] args){
		buildDeleteCase134();
		RedBlackTreeUtil.RB_LDR(rootDeleteCase12);
	}
}
