package com.princeton.cs.chapter2;

import java.util.LinkedList;
import java.util.Stack;




import com.princeton.cs.chapter1.part3.Queue;
import com.princeton.cs.util.StdOut;
/**
 * 1����������еĽڵ������222��    
2�������������ȣ�104��        
    �����������С��ȣ�111��    
3��ǰ�к��������94/144/145��    
4���ֲ������������102/107��    
   ֮���α�����103��        
5���������������Ϊ�����˫������114��
6�����������k��ڵ����    
7�����������Ҷ�ӽڵ�ĸ���    
8���ж������������Ľṹ�Ƿ���ͬ��100��    
9���ж϶������Ƿ�Ϊƽ���������110��        
10����������ľ���226��                
    �ж϶������Ƿ�Գƣ�101��
    11��������������ڵ����͹������Ƚڵ� 
    12����������нڵ��������
13����ǰ���������������ؽ���������105��
    ������ͺ�������ؽ���������106��
14���ж϶������Ƿ�Ϊ��ȫ����������
15����һ����������ת��Ϊ�����������108��
 * @ClassName:  IntBST   
 * @Description:TODO   
 * @author: RoseVorchid  
 * @date:   2017��9��11�� ����8:45:05   
 *
 */
public class IntBST {
	private IntBSTNode root;
	LinkedList<IntBSTNode> nodeList=null;
	/**
	 * 1.��������Ľڵ���
	 * @Title: countNodes   
	 * @Description: TODO
	 * @param: @param localRoot
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public int countNodes(IntBSTNode localRoot){
		if(localRoot==null)return 0;
		return countNodes(localRoot.left)+countNodes(localRoot.right);
	}
	/**
	 * ����������
	 * @Title: createTree   
	 * @Description: TODO
	 * @param: @param a      
	 * @return: void      
	 * @throws
	 */
	public void createTree(int[] a){
		nodeList=new LinkedList<>();
		for(int i=0;i<a.length;i++){
			nodeList.add(new IntBSTNode(a[i]));
		}
		for(int j=0;j<a.length/2-1;j++){
			//����
			nodeList.get(j).left=nodeList.get(j*2+1);
			//�Һ���
			nodeList.get(j).right=nodeList.get(j*2+2);
		}
		//���һ�����ڵ�:��Ϊ���һ�����ڵ����û���Һ���,�ʵ�������
		int lastParentIndex=a.length/2-1;
		//����
		nodeList.get(lastParentIndex).left=nodeList.get(lastParentIndex*2+1);
		//�Һ���,�������ĳ���Ϊ�����Ž����Һ���
		if(a.length%2==1){
			nodeList.get(lastParentIndex).right=nodeList.get(lastParentIndex*2+2);
		}
	}
	public IntBST(){
		root=null;
	}
	public IntBST(IntBSTNode root){
		this.root=root;
	}
	//����
	public IntBSTNode search(IntBSTNode p,int el){
		while(p!=null){
			if(p.key==el){
				return p;
			}else if(p.key<el){
				p=p.right;
			}else{
				p=p.left;
			}
		}
		return null;
	}
	/**
	 * �����������
	 */
	public void breadthFirst(){
		IntBSTNode p=root;
		Queue queue=new Queue();
		if(p!=null){
			queue.enqueue(p);
			while(!queue.isEmpty()){
				p=(IntBSTNode) queue.dequeue();
				display(p);
				if(p.left!=null){
					queue.enqueue(p.left);
				}
				if(p.right!=null){
					queue.enqueue(p.right);
				}
			}
		}
	}
	/**
	 * �ݹ�
	 * @Title: preOrder
	 */
	public void preOrder(IntBSTNode p){
		if(p==null)return;
		display(p);
		preOrder(p.left);
		preOrder(p.right);
	}
	
	public void inOrder(IntBSTNode  p){
		if(p==null)return;
		inOrder(p.left);
		display(p);
		inOrder(p.right);
	}
	
	public void postOrder(IntBSTNode p){
		if(p==null)return;
		postOrder(p.left);
		postOrder(p.right);
		display(p);
	}
	
	/**
	 * �ǵݹ�������
	 */
	public void non_postOrder(IntBSTNode localRoot){
		IntBSTNode p=localRoot,q=localRoot;
		Stack travStack=new Stack<>();
		while(p!=null){
			//��������ջ
			for(;p.left!=null;p=p.left){
				travStack.push(p);
			}
			//��ǰ�ڵ����Һ��ӻ��Һ����Ѿ����
			while(p!=null&&(p.right==null||p.right==q)){
				display(p);
				q=p;//��¼��һ��������Ľڵ�
				if(travStack.isEmpty())
					return;
				p=(IntBSTNode) travStack.pop();
			}
			//�����Һ���
			travStack.push(p);
			p=p.right;
		}
	}
	/**
	 * �ǵݹ� ������� ˫ջ��
	 * @Title: non_postOrder_1
	 */
	public void non_postOrder_1(IntBSTNode localRoot){
		Stack<IntBSTNode> lstack=new Stack<>();
		Stack<IntBSTNode> rstack=new Stack<>();
		IntBSTNode node=localRoot,right;
		do{
			while(node!=null){
				right=node.right;
				lstack.push(node);
				rstack.push(right);
				node=node.left;
			}
			node=lstack.pop();
			right=rstack.pop();
			if(right==null){
				display(node);
			}else{
				lstack.push(node);
				rstack.push(null);
			}
			node=right;
		}while(lstack.size()>0||rstack.size()>0);
	}
	/**
	 * �ǵݹ� ������� ��ջ��
	 */
	public void non_postOrder_2(IntBSTNode localRoot){
		Stack<IntBSTNode> stack=new Stack<>();
		IntBSTNode node=localRoot,prev=localRoot;
		while(node!=null||stack.size()>0){
			while(node!=null){
				stack.push(node);
				node=node.left;
			}
			if(stack.size()>0){
				IntBSTNode temp=stack.peek().right;
				if(temp==null||temp==prev){
					node=stack.pop();
					display(node);
					prev=node;
					node=null;
				}else{
					node=temp;
				}
			}
		}
	}
	/**
	 * �ǵݹ� �������4
	 * @Title: non_postOrder_3   
	 * @Description: TODO
	 * @param: @param localRoot      
	 * @return: void      
	 * @throws
	 */
	public void non_postOrder_3(IntBSTNode localRoot){
		Stack<IntBSTNode> stack=new Stack<>();
		Stack<IntBSTNode> temp=new Stack<>();
		IntBSTNode node=localRoot;
		while(node!=null||stack.size()>0){
			while(node!=null){
				temp.push(node);
				stack.push(node);
				node=node.right;
			}
			if(stack.size()>0){
				node=stack.pop();
				node=node.left;
			}
		}
	    while (temp.size() > 0) {//�Ѳ������ж����뵽��temp��  
            node = temp.pop();    
            display(node);    
        } 
	}
	/**
	 * �ǵݹ� �������1
	 * @Title: non_preOrder
	 */
	public void non_preOrder(IntBSTNode localRoot){
		IntBSTNode p=localRoot;
		Stack travStack=new Stack<>();
		if(p!=null){
			travStack.push(p);
			while(!travStack.isEmpty()){
				p=(IntBSTNode) travStack.pop();
				display(p);
				if(p.right!=null){
					travStack.push(p.right);
				}
				if(p.left!=null){
					travStack.push(p.left);
				}
			}
		}
	}
	/**
	 * �ǵݹ� �������2
	 * @Title: non_preOrder1   
	 * @Description: TODO
	 * @param: @param localRoot      
	 * @return: void      
	 * @throws
	 */
	public void non_preOrder1(IntBSTNode localRoot){
		Stack<IntBSTNode> stack=new Stack<>();
		IntBSTNode node=localRoot;
		while(node!=null||stack.size()>0){
			while(node!=null){
				display(node);
				stack.push(node);
				node=node.left;
			}
			if(stack.size()>0){
				node=stack.pop();
				node=node.right;
			}
		}
	}
	public void non_inOrder(IntBSTNode localRoot){
		IntBSTNode p=localRoot;
		Stack<IntBSTNode> travStack=new Stack<>();
		
	}
	private void display(IntBSTNode p) {
		StdOut.print(p.key+" ");
	}
	public static void main(String[] args) {
		IntBST intBST=new IntBST();
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };  
		intBST.createTree(array);
		
		IntBSTNode root=intBST.nodeList.get(0);
		intBST.root=root;
		intBST.non_postOrder(root);
		StdOut.println("");
		intBST.non_postOrder_1(root);
		StdOut.println("");
		intBST.non_postOrder_2(root);
		StdOut.println("");
		intBST.non_postOrder_3(root);
		
		StdOut.println("");
		intBST.breadthFirst();
		
		StdOut.println("");
		intBST.non_preOrder(root);
		StdOut.println("");
		intBST.non_preOrder1(root);
	}
}
class IntBSTNode{
	protected int key;
	protected IntBSTNode left,right;
	
	public IntBSTNode(){
		left=right=null;
	}
	
	public IntBSTNode(int val){
		this(val,null,null);
	}
	
	public IntBSTNode(int val,IntBSTNode lt,IntBSTNode rt){
		key=val;
		left=lt;
		right=rt;
	}
}