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
			//����
			nodeList.get(j).lchild=nodeList.get(j*2+1);
			//�Һ���
			nodeList.get(j).rchild=nodeList.get(j*2+2);
		}
		//���һ�����ڵ�:��Ϊ���һ�����ڵ����û���Һ���,�ʵ�������
		int lastParentIndex=a.length/2-1;
		//����
		nodeList.get(lastParentIndex).lchild=nodeList.get(lastParentIndex*2+1);
		//�Һ���,�������ĳ���Ϊ�����Ž����Һ���
		if(a.length%2==1){
			nodeList.get(lastParentIndex).rchild=nodeList.get(lastParentIndex*2+2);
		}
	}
	/**
	 * �������
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
	 * �������
	 */
	public static void inOrderTraverse(NodeT node){
		if(node==null)return;
		inOrderTraverse(node.lchild);
		System.out.print(node.val+" ");
		inOrderTraverse(node.rchild);
	}
	/**
	 * �������
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
		
		System.out.println("���������");  
        preOrderTraverse(root);  
        System.out.println();  
  
        System.out.println("���������");  
        inOrderTraverse(root);  
        System.out.println();  
  
        System.out.println("���������");  
        postOrderTraverse(root);  
	}
}
class NodeT{
	//����
	public int val;
	//������
	public NodeT lchild;
	//������
	public NodeT rchild;
	
	public NodeT(int data){
		val=data;
		lchild=null;
		rchild=null;
	}
}