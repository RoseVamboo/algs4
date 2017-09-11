package com.princeton.cs.chapter2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.princeton.cs.util.StdOut;

public class Tree {
	private Node root;
	
	public Tree(){
		root=null;
	}
	public Node getRoot(){
		return root;
	}
	public Node find(int key){
		Node current=root;
		while(current.iData!=key){
			if(key<current.iData){
				current=current.leftChild;
			}else{
				current=current.rightChild;
			}
			if(current==null){
				return null;
			}
		}
		return current;
	}
	public void insert(int id,double dd){
		Node newNode=new Node();
		newNode.iData=id;
		newNode.dData=dd;
		if(root==null){
			root=newNode;
		}else{
			Node current=root;
			Node parent;
			while(true){
				parent=current;
				if(id<current.iData){
					current=current.leftChild;
					if(current==null){
						parent.leftChild=newNode;
						return;
					}
				}else{
					current=current.rightChild;
					if(current==null){
						parent.rightChild=newNode;
						return;
					}
				}
			}
		}
	}
	public boolean delete(int key){
		Node current=root;
		Node parent=root;
		boolean isLeftChild=true;
		//找到需要删除的节点
		while(current.iData!=key){
			parent=current;
			if(key<current.iData){
				isLeftChild=true;
				current=current.leftChild;
			}else{
				isLeftChild=false;
				current=current.rightChild;
			}
			if(current==null){
				return false;
			}
		}
		
		if(current.leftChild==null&&current.rightChild==null){
			if(current==root){
				root=null;
			}else if(isLeftChild){
				parent.leftChild=null;
			}else{
				parent.rightChild=null;
			}
		}else if(current.rightChild==null){
			if(current==root){
				root=current.leftChild;
			}else if(isLeftChild){
				parent.leftChild=current.leftChild;
			}else{
				parent.rightChild=current.leftChild;
			}
		}else if(current.leftChild==null){
			if(current==root){
				root=current.rightChild;
			}else if(isLeftChild){
				parent.leftChild=current.rightChild;
			}else{
				parent.rightChild=current.rightChild;
			}
		}else{
			Node successor=getSuccessor(current);
			if(current==root){
				root=successor;
			}else if(isLeftChild){
				parent.leftChild=successor;
			}else{
				parent.rightChild=successor;
			}
			successor.leftChild=current.leftChild;
		}
		return true;
	}
	private Node getSuccessor(Node delNode) {
		Node successorParent=delNode;
		Node successor=delNode;
		Node current=delNode.rightChild;
		while(current!=null){
			successorParent=successor;
			successor=current;
			current=current.leftChild;
		}
		if(successor!=delNode.rightChild){
			successorParent.leftChild=successor.rightChild;
			successor.rightChild=delNode.rightChild;
		}
		return successor;
	}
	
	public void traverse(int traverseType){
		switch (traverseType) {
		case 1:
			StdOut.print("\nPreOrder traverse: ");
			preOrder(root);
			break;
		case 2:
			StdOut.print("\nInOrder traverse: ");
			inOrder(root);
			break;
		case 3:
			StdOut.print("\nPostOrder traverse: ");
			postOrder(root);
			break;
		}
	}
	private void postOrder(Node localRoot) {
		if(localRoot!=null){
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			StdOut.print(localRoot.iData+" ");
		}
	}
	private void inOrder(Node localRoot) {
		if(localRoot!=null){
			inOrder(localRoot.leftChild);
			StdOut.print(localRoot.iData+" ");
			inOrder(localRoot.rightChild);
		}
	}
	private void preOrder(Node localRoot) {
		if(localRoot!=null){
			StdOut.print(localRoot.iData+" ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void displayTree(){
		
		Stack globalStack=new Stack();
		globalStack.push(root);
		int nBlanks=32;
		boolean isRowEmpty=false;
		StdOut.println("......................................");
		while(isRowEmpty==false){
			Stack localStack=new Stack<>();
			isRowEmpty=true;
			
			for(int j=0;j<nBlanks;j++)
				StdOut.print(" ");
			while(globalStack.isEmpty()==false){
				Node temp=(Node) globalStack.pop();
				if(temp!=null){
					StdOut.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					
					if(temp.leftChild!=null||temp.rightChild!=null)
						isRowEmpty=false;
				}else{
					StdOut.print("..");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0;j<nBlanks;j++)
					StdOut.print(" ");
			}
			StdOut.println("");
			nBlanks/=2;
			while(localStack.isEmpty()==false){
				globalStack.push(localStack.pop());
			}
		}
		StdOut.println("......................................");	
	}
	
	/**
	 * 从顶部开始逐层打印二叉树节点数据
	 */
	public static void printTree1(Node nodeRoot){
		if(nodeRoot==null)return;
		Node temp=null;
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(nodeRoot);
		while(!queue.isEmpty()){
			temp=queue.poll();
			StdOut.print(temp.iData+" ");
			if(temp.equals(nodeRoot)){
				StdOut.println("");
				nodeRoot=nodeRoot.rightChild;
			}
			
			if(temp.leftChild!=null)
				queue.add(temp.leftChild);
			if(temp.rightChild!=null)
				queue.add(temp.rightChild);
		}
	}
	
	public static void printTree2(Node root){
		if(root==null)return;
		Link head=new Link(null, root);
		Link first=head;
		Link second=head;
		while(first!=null){
			if(first.node.leftChild!=null){
				second.next=new Link(null, first.node.leftChild);
				second=second.next;
			}
			if(first.node.rightChild!=null){
				second.next=new Link(null, first.node.rightChild);
				second=second.next;
			}
			StdOut.print(first.node.iData+" ");
			if(first.node.equals(root)){
				
				StdOut.println("");
				root=root.rightChild;
				
			}
			
			first=first.next;
		}
	}
}
class Node{
	public int iData;
	public double dData;
	public Node leftChild;
	public Node rightChild;
	public void displayNode(){
		System.out.print("{");
		System.out.print(iData);
		System.out.print(",");
		System.out.print(dData);
		System.out.print("}");
	}
}

class Link{
	public Link next;
	public Node node;
	public Link(Link link,Node node){
		this.next=link;
		this.node=node;
	}
}
