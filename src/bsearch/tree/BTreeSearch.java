package bsearch.tree;

public class BTreeSearch {
	// B-Tree                                          
	//                  15                      
	//              5        16                 
	//           3     12        20            
	//              10        18    23        
	//            6                                  
	//              7                                
	public static void main(String[] args) {
		BSearchTreeRootNode root = new BSearchTreeRootNode();
		TreeNode key23 = searchNodeByKey(root.rootNode, 5);
		searchSuccessor(key23);
		searchPredecessor(key23);
	}
	
	public static TreeNode searchNodeByKey(TreeNode root, int key){
		if(root.key == key){
			System.out.println("====Hit====");
			return root;
		}
		else if(root.key > key && root.leftChild != null)
			return searchNodeByKey(root.leftChild, key);
		else if(root.key < key && root.rightChild != null)
			return searchNodeByKey(root.rightChild, key);
		else
			return null;
	}
	
	public static int searchMin(TreeNode root){
		if(root.leftChild != null){
			return searchMin(root.leftChild);
		}
		return root.key;
	}
	
	public static int searchMax(TreeNode root){
		if(root.rightChild != null){
			return searchMin(root.rightChild);
		}
		return root.key;
	}
	
	/**
	 * ���Һ�̽ڵ�
	 * @param root
	 */
	public static void searchSuccessor(TreeNode root){
		int successor = -1;
		/* ������������ڵĻ����򷵻������������Ľڵ㣬��Ϊ����С��֮�е����Ľڵ� */
		if(root.rightChild != null){
			successor = searchMin(root.rightChild);
		}
		else{// ͬ��������ǰ��
			TreeNode paramNode = root;
			while(paramNode.parent != null && paramNode != paramNode.parent.leftChild){
				paramNode = paramNode.parent;
			}
			if(paramNode.parent != null)
				successor = paramNode.parent.key;
		}
		System.out.println("====>>>Tree Node " + root.key + " successor is " + successor);
	}
	
	/**
	 * ����ǰ���ڵ�
	 * @param root
	 */
	public static void searchPredecessor(TreeNode root){
		int predecessor = -1;
		if(root.leftChild != null){
			predecessor = searchMax(root.leftChild);// correct
		}
		else{
			TreeNode paramNode = root;
			/* ��������������ڵĻ�������Ҫ�����ң�ֱ���ҵ�Ŀ��ڵ���Ŀ��ڵ㸸�׽ڵ���Һ��� */
			/* paramNode != paramNode.parent.rightChild �Ѿ����Լ�Ϊ��ʼ�ڵ�Ƚ���
			 * ���� 20-18-23����һ�αȽϣ���������Լ����Ǹ��׵��Һ��ӣ�����Ҫ����һ��ȥ����
			 * ����Լ��Ѿ����Һ�ֽ����ֱ��������Ǹ��ڵ�*/
			while(paramNode.parent != null && paramNode != paramNode.parent.rightChild){
				paramNode = paramNode.parent;
			}
			if(paramNode.parent != null)
				predecessor = paramNode.parent.key;
			
		}
		System.out.println("====>>>Tree Node " + root.key + " predecessor is " + predecessor);
	}
}

