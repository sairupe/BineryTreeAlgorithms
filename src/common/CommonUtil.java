package common;

import bsearch.tree.TreeNode;

public class CommonUtil {
	
	/**
	 * 根据传入的数据构建二叉查找树（数据下标从0开始）
	 * @param array
	 * @return
	 */
	@Deprecated
	public static TreeNode buildBinarySearchTreeByIntArray(int[] array){
		TreeNode root = null;
		root = new TreeNode(array[0]);
		int lastParentIndex = array.length / 2;
		for(int i = lastParentIndex; i >= 0 ; i--){
			TreeNode parent = new TreeNode(array[lastParentIndex]);
			int leftChildIndex = 2 * lastParentIndex + 1;
			int rightChildIndex = 2 * lastParentIndex + 2;
			if(leftChildIndex < array.length - 1){
				TreeNode leftChild = new TreeNode(array[leftChildIndex]);
				parent.leftChild = leftChild;
				leftChild.parent = parent;
			}
			if(rightChildIndex < array.length - 1){
				TreeNode rightChild = new TreeNode(array[rightChildIndex]);
				parent.rightChild = rightChild;
				rightChild.parent = parent;
			}
		}
		return root;
	}
}
