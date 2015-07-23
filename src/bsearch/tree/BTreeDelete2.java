package bsearch.tree;

/**
 * ��װ�����汾
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
	
	
	// 1. ���ɾ���ڵ�û����Ů��ֱ�ӽ���ɾ������
	// 2. ���ɽ�Ƚڵ�ֻ��һ����Ů��ֱ��ɾ�����ú��ӽڵ��滻ɾ���ڵ�λ��
	// 3. ���ɾ���ڵ���������Ů����ɾ�����Y������������һ����Ů�������������и��Һ��ӣ�
	// 	      ��Y�Ĺؼ���ͼ������dNode�Ľڵ�͸�������
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
		
		// ��Ϊ����˵�ˣ�����ڵ��Ǻ�̽ڵ㣬�����ֻ��һ�����ӣ�Ҳ����û�У���
		// tmpNode�����Ǹ�Ψһ����������
		if(toDeleteNode.leftChild != null){
			tmpNode = toDeleteNode.leftChild;
		}
		else{
			tmpNode = toDeleteNode.rightChild;
		}
		if(tmpNode != null){// �Ѻ�̽ڵ��Ψһ�����滻��tmpNode
			toDeleteNode.singleChilNodeReplayceParentNode(tmpNode);
		}
		
		// �����ڵ�����
		if(toDeleteNode.parent == null){// ��ɾ�����Ǹ��ڵ�
			BSearchTreeRootNode.rootNode = tmpNode;
		}
		
		// �����������toDeleteNode�϶����Ǵ�������ԭʼ�ڵ��ˣ����Ǵ��������ĺ��
		if(toDeleteNode != dNode){
			dNode.changeDataKey(toDeleteNode);
		}
	}
}
