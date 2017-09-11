package com.princeton.cs.chapter2;

import java.util.LinkedList;

public class TreeT {
	private NodeT root;
	LinkedList<NodeT> nodeList=null;
	public void createTree(int[] a){
		nodeList=new LinkedList<>();
		for(int i=0;i<a.length;i++){
			nodeList.add(new NodeT(a[i]));
		}
		for(int j=0;j<a.length/2-1;j++){
			//左孩子
			nodeList.get(j).lchild=nodeList.get(j*2+1);
			//右孩子
			nodeList.get(j).rchild=nodeList.get(j*2+2);
		}
		//最后一个父节点:因为最后一个父节点可能没有右孩子,故单独处理
		int lastParentIndex=a.length/2-1;
		//左孩子
		nodeList.get(lastParentIndex).lchild=nodeList.get(lastParentIndex*2+1);
		//右孩子,如果数组的长度为奇数才建立右孩子
		if(a.length%2==1){
			nodeList.get(lastParentIndex).rchild=nodeList.get(lastParentIndex*2+2);
		}
	}
	/**
	 * 先序遍历
	 */
	public static void preOrderTraverse(NodeT node){
		if(node==null){
			return;
		}
		System.out.print(node.val+" ");
		preOrderTraverse(node.lchild);
		preOrderTraverse(node.rchild);
	}
	/**
	 * 中序遍历
	 */
	public static void inOrderTraverse(NodeT node){
		if(node==null)return;
		inOrderTraverse(node.lchild);
		System.out.print(node.val+" ");
		inOrderTraverse(node.rchild);
	}
	/**
	 * 后序遍历
	 */
	public static void postOrderTraverse(NodeT node){
		if(node==null)return;
		postOrderTraverse(node.lchild);
		postOrderTraverse(node.rchild);
		System.out.print(node.val+" ");
	}
	
	public static void main(String[] args) {
		TreeT binTree=new TreeT();
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };  
		binTree.createTree(array);
		
		NodeT root=binTree.nodeList.get(0);
		
		System.out.println("先序遍历：");  
        preOrderTraverse(root);  
        System.out.println();  
  
        System.out.println("中序遍历：");  
        inOrderTraverse(root);  
        System.out.println();  
  
        System.out.println("后序遍历：");  
        postOrderTraverse(root);  
	}
}
class NodeT{
	//数据
	public int val;
	//左子树
	public NodeT lchild;
	//右子树
	public NodeT rchild;
	
	public NodeT(int data){
		val=data;
		lchild=null;
		rchild=null;
	}
}