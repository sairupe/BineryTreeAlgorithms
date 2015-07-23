package bsearch.tree;

/**
 * 封装函数版本
 * @author Administrator
 *
 */
public class BTreeDelete2 {

	// B-Tree                                          
	//                  15                      
	//              5        16                 
	//           3     12        20            
	//              10        18    23        
	//            6                                  
	//              7          
	public static void main(String[] args) {
		BSearchTreeRootNode root = new BSearchTreeRootNode();
		LDR.LDRShow(root.rootNode);
		TreeNode key5 = BTreeSearch.searchNodeByKey(root.rootNode, 5);
		delete(key5);
		LDR.LDRShow(root.rootNode);
	}
	
	
	// 1. 如果删除节点没有子女，直接将它删除即可
	// 2. 如果山谷节点只有一个子女，直接删除，让孩子节点替换删除节点位置
	// 3. 如果删除节点有两个子女，则删除后继Y，让它至多有一个子女（后继性质最多有个右孩子）
	// 	      用Y的关键字图案换掉dNode的节点和附加数据
	public static void delete(TreeNode dNode){
		TreeNode toDeleteNode = null;
		TreeNode tmpNode = null;
		if(dNode.leftChild == null || dNode.rightChild == null){
			toDeleteNode = dNode;
		}
		else{
			toDeleteNode = BSearchTreeUtil.searchSuccessor(dNode);
		}
		
		// B-Tree                                          
		//                  15                      
		//              5        16                 
		//           3     12        20            
		//              10        18    23        
		//            6                                  
		//   
		
		// 因为上面说了，这个节点是后继节点，故最多只有一个孩子（也可能没有），
		// tmpNode就是那个唯一的子树孩子
		if(toDeleteNode.leftChild != null){
			tmpNode = toDeleteNode.leftChild;
		}
		else{
			tmpNode = toDeleteNode.rightChild;
		}
		if(tmpNode != null){// 把后继节点的唯一子树替换掉tmpNode
			toDeleteNode.singleChilNodeReplayceParentNode(tmpNode);
		}
		
		// 交换节点数据
		if(toDeleteNode.parent == null){// 若删除的是根节点
			BSearchTreeRootNode.rootNode = tmpNode;
		}
		
		// 第三种情况，toDeleteNode肯定不是传进来的原始节点了，而是传进来结点的后继
		if(toDeleteNode != dNode){
			dNode.changeDataKey(toDeleteNode);
		}
	}
}
