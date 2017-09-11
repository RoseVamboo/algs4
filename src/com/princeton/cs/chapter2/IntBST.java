package com.princeton.cs.chapter2;

import java.util.LinkedList;
import java.util.Stack;




import com.princeton.cs.chapter1.part3.Queue;
import com.princeton.cs.util.StdOut;
/**
 * 1、求二叉树中的节点个数（222）    
2、求二叉树的深度（104）        
    求二叉树的最小深度（111）    
3、前中后序遍历（94/144/145）    
4、分层遍历二叉树（102/107）    
   之字形遍历（103）        
5、将二叉查找树变为有序的双向链表（114）
6、求二叉树第k层节点个数    
7、求二叉树中叶子节点的个数    
8、判断两个二叉树的结构是否相同（100）    
9、判断二叉树是否为平衡二叉树（110）        
10、求二叉树的镜像（226）                
    判断二叉树是否对称（101）
    11、求二叉树两个节点的最低公共祖先节点 
    12、求二叉树中节点的最大距离
13、由前序遍历和中序遍历重建二叉树（105）
    由中序和后序遍历重建二叉树（106）
14、判断二叉树是否为完全二叉树（）
15、将一个有序数组转化为二叉查找树（108）
 * @ClassName:  IntBST   
 * @Description:TODO   
 * @author: RoseVorchid  
 * @date:   2017年9月11日 下午8:45:05   
 *
 */
public class IntBST {
	private IntBSTNode root;
	LinkedList<IntBSTNode> nodeList=null;
	/**
	 * 1.求二叉树的节点数
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
	 * 创建二叉树
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
			//左孩子
			nodeList.get(j).left=nodeList.get(j*2+1);
			//右孩子
			nodeList.get(j).right=nodeList.get(j*2+2);
		}
		//最后一个父节点:因为最后一个父节点可能没有右孩子,故单独处理
		int lastParentIndex=a.length/2-1;
		//左孩子
		nodeList.get(lastParentIndex).left=nodeList.get(lastParentIndex*2+1);
		//右孩子,如果数组的长度为奇数才建立右孩子
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
	//搜索
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
	 * 广度优先搜索
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
	 * 递归
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
	 * 非递归后序遍历
	 */
	public void non_postOrder(IntBSTNode localRoot){
		IntBSTNode p=localRoot,q=localRoot;
		Stack travStack=new Stack<>();
		while(p!=null){
			//左子树入栈
			for(;p.left!=null;p=p.left){
				travStack.push(p);
			}
			//当前节点无右孩子或右孩子已经输出
			while(p!=null&&(p.right==null||p.right==q)){
				display(p);
				q=p;//记录上一个已输出的节点
				if(travStack.isEmpty())
					return;
				p=(IntBSTNode) travStack.pop();
			}
			//处理右孩子
			travStack.push(p);
			p=p.right;
		}
	}
	/**
	 * 非递归 后序遍历 双栈法
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
	 * 非递归 后序遍历 单栈法
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
	 * 非递归 后序遍历4
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
	    while (temp.size() > 0) {//把插入序列都插入到了temp。  
            node = temp.pop();    
            display(node);    
        } 
	}
	/**
	 * 非递归 先序遍历1
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
	 * 非递归 先序遍历2
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