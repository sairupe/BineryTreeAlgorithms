package bsearch.tree;

import java.util.Stack;


/**
 * @author ZH
 * ��������
 */
//B-Tree                                          
//                  15                      
//              5        16                 
//           3     12        20            
//              10        18    23        
//            6                                  
//              7 
//result 3, 7, 6, 10, 13, 12, 5, 18, 23, 20, 16, 15
public class LRD {
	public static void main(String[] args) {
		BSearchTreeRootNode root = new BSearchTreeRootNode();
		System.out.println("===========Recursive===========");
		LRDShow(root.rootNode);
		System.out.println("\n===========UnRecursive===========");
		LRD_UnRecursive(root.rootNode);
		System.out.println("\n===========UnRecursive Root Null===========");
		LRD_UnRecursive(null);
		//System.out.println("\n===========UnRecursive2===========");
		//LRD_UnRecursive2(root.rootNode);
	}
	public static void LRDShow(TreeNode rootNode){
		if(rootNode.leftChild != null)
			LRDShow(rootNode.leftChild);
		if(rootNode.rightChild != null)
			LRDShow(rootNode.rightChild);
		System.out.print(rootNode.key + "|");
	}
	
	// ��������ǵݹ�   
    public static void LRD_UnRecursive(TreeNode t) {  
        Stack<TreeNode> s = new Stack<TreeNode>(); 
        // ���ʼ�¼����ջ 0-���ʹ������� 1.���ʹ�������
        Stack<Integer> s2 = new Stack<Integer>(); 
        Integer i = new Integer(1);  
        while (t != null || !s.empty()) {  
            while (t != null) {  
                s.push(t);  
                s2.push(new Integer(0));  
                t = t.leftChild;  
            }  
           
            // ���ʹ��������������
            while (!s.empty() &&  
            		s2.peek().equals(i)) {  
                s2.pop();  
                System.out.print(s.pop().key + "|");  
            }  
   
            if (!s.empty()) {  
            	// �������ʱ�ʶ
                s2.pop();  
                s2.push(new Integer(1));  
                t = s.peek();  
                t = t.rightChild;  
            } 
        }  
    }  
    
    // ��������ǵݹ�   
    @Deprecated
    public static void LRD_UnRecursive2(TreeNode t) {  
        Stack<TreeNode> s = new Stack<TreeNode>(); 
        // ���ʼ�¼����ջ 0-���ʹ������� 1.���ʹ�������
        Stack<Integer> s2 = new Stack<Integer>(); 
        Integer i = new Integer(1);  
        while (t != null || !s.empty()) {  
            while (t != null) {  
                s.push(t);  
                s2.push(new Integer(0));  
                t = t.leftChild;  
            }  
           
            // ���ʹ��������������
            while (!s.empty() && s2.peek().equals(i)) {  
                s2.pop();  
                System.out.print(s.pop().key + "|");  
            }  
   
            // ��������λ�ã��ı��ʶ��������һ��whileѭ������
            if (s.peek().rightChild != null) {  
            	s2.pop();
            	s2.push(new Integer(1));
                t = s.peek();  
                t = t.rightChild;  
            } 
        }  
    }  
}
