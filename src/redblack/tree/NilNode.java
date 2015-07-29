package redblack.tree;

import bsearch.tree.TreeNode;


/**
 * @author SyrianaZh
 *
 * 2015-7-29
 * 
 * 红黑树哨兵空节点,单例
 */
public class NilNode extends RedBlackTreeNode{
	
	/**
	 * 单例实例
	 */
	public static TreeNode nilNode = new NilNode(-1);
	
	/**
	 * 颜色
	 */
	public Color color = Color.BLACK;
	
	public NilNode(int key) {
		super(key);
	}
}
