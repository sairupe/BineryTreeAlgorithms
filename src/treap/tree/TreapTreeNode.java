package treap.tree;

import bsearch.tree.TreeNode;

public class TreapTreeNode extends TreeNode {

	public int fix;// ����ֵ
	
	public TreapTreeNode(int key) {
		super(key);
	}
	
	@Override
	public String toString() {
		return key + ":" + fix + "|";
	}
}
