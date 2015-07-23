package avl.tree;

import bsearch.tree.LDR;

public class AVLUtil {
	
	public static void buildAVLTree(int[] array){
		for(int node : array){
			if(node == 19){
				System.out.println();
			}
			AVLInsert.avlInsert2(null, AVLTreeRootNode.avlRoot , node);
		}
		System.out.println("================>>�������߶ȵ�AVL�����");
	}
	
	public static void main(String[] args){
		buildAVLTree(AVLTreeRootNode.avlTreeArray);
		LDR.LDRShow(AVLTreeRootNode.avlRoot);
	}
}
