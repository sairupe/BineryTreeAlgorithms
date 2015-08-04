package bsearch.tree;
/**
 * @author Zh
 * ��������������㷨(Ŀǰֻ֧�ֲ��ظ�KEY����)
 */
public class BTreeInsert {

	// B-Tree                                          
	//                  15                      
	//              5        16                 
	//           3     12        20            
	//              10        18    23        
	//            6                                  
	//              7          
	public static void main(String[] args) {
		BSearchTreeRootNode root = new BSearchTreeRootNode();
		insert(root.rootNode, 11);
		LDR.LDR_UnRecursive(root.rootNode);
		System.out.println();
		LDR.LDRShow(root.rootNode);
	}

	/**
	 * 
	 * @param root ���������ڵ�
	 * @param key �ؼ��ֵ�ֵ
	 * @return �²���Ľڵ�
	 */
	public static TreeNode insert(TreeNode root, int key){
		TreeNode newNode = new TreeNode(key);
		TreeNode insertParentNode = root;
		TreeNode lastCheckNode = null;
		while(insertParentNode != null){// �ҵ�ĳ���ڵ㣬����ڵ㣬���ҽڵ�Ϊ��
			lastCheckNode = insertParentNode;
			if(key < insertParentNode.key)
				insertParentNode = insertParentNode.leftChild;
			else
				insertParentNode = insertParentNode.rightChild;
		}
		newNode.parent = lastCheckNode;// ���︳ֵע����lastCheckNode
		if(lastCheckNode == null){
			BSearchTreeRootNode.rootNode = newNode;
		}
		else if(newNode.key < lastCheckNode.key){
			lastCheckNode.leftChild = newNode;
		}
		else{
			lastCheckNode.rightChild = newNode;
		}
		return newNode;
	}
}
