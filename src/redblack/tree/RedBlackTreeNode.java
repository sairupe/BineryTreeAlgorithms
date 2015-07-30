package redblack.tree;

import bsearch.tree.TreeNode;


public class RedBlackTreeNode extends TreeNode{

	public RedBlackTreeNode(int key) {
		super(key);
	}
	/**
	 * 颜色
	 */
	Color color;
	
	@Override
	public String toString() {
		String str = "" + key;
		if(color == Color.RED){
			str += "(R) | ";
		}
		else{
			str += "(B) | ";
		}
		return str;
	}
}
