package redblack.tree;

import bsearch.tree.BSearchTreeUtil;
import bsearch.tree.BTreeSearch;
import bsearch.tree.TreeNode;

public class RedBlackTreeDelete {
	
	// ORIGINAL:
	// RB-Tree, x is childTree, y is to delete, initial is balance                                   
	//                      3(B)                      
	//y------------>  2(B)          8(R)                 
	//x--------> 1(B)         6(B)      9(B)            
	//				      5(R)    7(B)     10(B)
	//                 4(B)
	//
	
	// CHANGE:
	// RB-Tree, x is childTree, y is to delete, initial is balance                                   
	//                         8(B)                      
	//                   5(R)       9(B)                 
	//             3(B)       6(B)      10(B)            
	//		  1(B)	  4(B)        7(B)     
	//
	public static void redBlackTreeFixUp(RedBlackTreeNode childNode){
		RedBlackTreeNode x = childNode;
		while(x != RedBlackTreeRootNode.rootDeleteCase134 
				&& childNode.color == Color.BLACK){
			if(x == x.parent.leftChild){
				RedBlackTreeNode w = (RedBlackTreeNode) x.parent.rightChild;
				// CASE 1
				if(w != NilNode.nilNode && w.color == Color.RED){
					((RedBlackTreeNode)x.parent).color = Color.RED;
					w.color = Color.BLACK;
					RedBlackTreeUtil.leftRotate2(x.parent,  RedBlackTreeRootNode.CASE134);
					w = (RedBlackTreeNode) x.parent.rightChild;
					continue;// 参考INSERT的另外一种写法
				}
				// CASE 2
				if(//w.leftChild != NilNode.nilNode && w.rightChild != NilNode.nilNode && 
						((RedBlackTreeNode)w.leftChild).color == Color.BLACK
						&& ((RedBlackTreeNode)w.rightChild).color == Color.BLACK){
					w.color = Color.RED;
					x = (RedBlackTreeNode) x.parent;
					continue;// 参考INSERT的另外一种写法
				}
				// CASE 3
				else if(((RedBlackTreeNode)w.rightChild).color == Color.BLACK){// w的左子树颜色为红
					w.color = Color.RED;
					((RedBlackTreeNode)w.leftChild).color = Color.BLACK;
					RedBlackTreeUtil.rightRotate2(w, RedBlackTreeRootNode.CASE134);
					w = (RedBlackTreeNode) x.parent.rightChild;
				}
				// CASE 4 实际属于CASE 3的一个分支，参考INSERT
				w.color = ((RedBlackTreeNode)x.parent).color;
				((RedBlackTreeNode)x.parent).color = Color.BLACK;
				((RedBlackTreeNode)w.rightChild).color = Color.BLACK;
				RedBlackTreeUtil.leftRotate2(x.parent, RedBlackTreeRootNode.CASE134);
				x = (RedBlackTreeNode) RedBlackTreeRootNode.rootDeleteCase134; 
			}
			else{//x == x.parent.rightChild
				RedBlackTreeNode w = (RedBlackTreeNode) x.parent.leftChild;
				// CASE 1
				if(w != NilNode.nilNode && w.color == Color.RED){
					((RedBlackTreeNode)x.parent).color = Color.RED;
					w.color = Color.BLACK;
					RedBlackTreeUtil.rightRotate2(x.parent, RedBlackTreeRootNode.CASE134);
					w = (RedBlackTreeNode) x.parent.leftChild;
					continue;
				}
				// CASE 2
				if(//w.leftChild != NilNode.nilNode && w.rightChild != NilNode.nilNode && 
						((RedBlackTreeNode)w.leftChild).color == Color.BLACK
						&& ((RedBlackTreeNode)w.rightChild).color == Color.BLACK){
					w.color = Color.RED;
					x = (RedBlackTreeNode) x.parent;
					continue;
				}
				// CASE 3
				else if(((RedBlackTreeNode)w.leftChild).color == Color.BLACK){// w的左子树颜色为红
					w.color = Color.RED;
					((RedBlackTreeNode)w.rightChild).color = Color.BLACK;
					RedBlackTreeUtil.leftRotate2(w, RedBlackTreeRootNode.CASE134);
					w = (RedBlackTreeNode) x.parent.rightChild;
				}
				// CASE 4
				w.color = ((RedBlackTreeNode)x.parent).color;
				((RedBlackTreeNode)x.parent).color = Color.BLACK;
				((RedBlackTreeNode)w.leftChild).color = Color.BLACK;
				RedBlackTreeUtil.rightRotate2(x.parent, RedBlackTreeRootNode.CASE134);
				x = (RedBlackTreeNode) RedBlackTreeRootNode.rootDeleteCase134; 
			}
		}
		x.color = Color.BLACK;
	}
	
	public static TreeNode RB_DELETE(TreeNode rootNode, int deleteKeyValue){
		TreeNode dNode = BTreeSearch.searchNodeByKey(
				RedBlackTreeRootNode.rootDeleteCase134, deleteKeyValue);
		// 检测是否存在删除节点
		if (dNode == null) {
			return null;
		}
		TreeNode toDeleteNode = null;
		TreeNode tmpNode = null;
		if(dNode.leftChild == NilNode.nilNode || dNode.rightChild == NilNode.nilNode){
			toDeleteNode = dNode;
		}
		else{
			toDeleteNode = BSearchTreeUtil.searchSuccessor(dNode);
		}
		
		// 因为上面说了，这个节点是后继节点，故最多只有一个孩子（也可能没有），
		// tmpNode就是那个唯一的子树孩子
		if(toDeleteNode.leftChild != NilNode.nilNode){
			tmpNode = toDeleteNode.leftChild;
		}
		else{
			tmpNode = toDeleteNode.rightChild;// 如果删除节点有两棵子树那么一定进这个逻辑
		}
		if(tmpNode != NilNode.nilNode){// 把后继节点的唯一子树替换掉tmpNode
			toDeleteNode.singleChilNodeReplayceParentNode(tmpNode);
		}
		
		// 交换节点数据
		if(toDeleteNode.parent == NilNode.nilNode){// 若删除的是根节点
			RedBlackTreeRootNode.rootDeleteCase134 = tmpNode;
		}
		
		// 第三种情况，toDeleteNode肯定不是传进来的原始节点了，而是传进来结点的后继
		if(toDeleteNode != dNode){
			dNode.key = toDeleteNode.key;
		}
		
		// RB平衡性调整
		RedBlackTreeNode childNode = (RedBlackTreeNode)tmpNode;
		if(childNode.color == Color.BLACK){
			redBlackTreeFixUp(childNode);
		}
		return toDeleteNode;
	}
	
	public static void main(String[] args){
		RedBlackTreeRootNode.buildDeleteCase134();
		RB_DELETE(RedBlackTreeRootNode.rootDeleteCase134, 2);
		RedBlackTreeUtil.RB_LDR(RedBlackTreeRootNode.rootDeleteCase134);
	}
}
