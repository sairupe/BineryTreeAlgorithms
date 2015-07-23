package avl.tree;

import bsearch.tree.BSearchTreeRootNode;
import bsearch.tree.BTreeDelete;
import bsearch.tree.BTreeSearch;
import bsearch.tree.LDR;
import bsearch.tree.TreeNode;

public class AVLDelete {
	
	public static void avlDelete(int deleteKeyValue){
		BSearchTreeRootNode root = new BSearchTreeRootNode();
		TreeNode treeNode = BTreeSearch.searchNodeByKey(BSearchTreeRootNode.rootNode, 5);
		BTreeDelete.delete(treeNode);
		LDR.LDRShow(root.rootNode);
	}
	
	public static void main(String[] args){
		avlDelete(5);
	}
}
