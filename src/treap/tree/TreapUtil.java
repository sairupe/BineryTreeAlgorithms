package treap.tree;

import java.util.Random;

import bsearch.tree.TreeNode;

public class TreapUtil {
	
	private static Random random = new Random();
	
	public static int getRandomIntByRange(int range){
		return random.nextInt(range);
	}
	
	public static void treapLDRShow(TreeNode rootNode){
		TreapTreeNode ttn = (TreapTreeNode) rootNode;
		if(rootNode.leftChild != null)
			treapLDRShow(rootNode.leftChild);
		System.out.print(rootNode.key + ":" + ttn.fix + "|");
		if(rootNode.rightChild != null)
			treapLDRShow(rootNode.rightChild);
	}
}
