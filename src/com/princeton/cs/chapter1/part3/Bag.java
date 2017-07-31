package com.princeton.cs.chapter1.part3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @ClassName:  Bag   
 * @Description:TODO   
 * @author: RoseVorchid  
 * @date:   2017��5��6�� ����7:52:12   
 *   
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item> {

	private Node<Item> first;//�����Ŀ�ʼ�ڵ�
	private int n;//����Ԫ�ص�����
	
	//�ڵ�
	private static class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	/**
	 * 
	 * @Title:  Bag   
	 * @Description:��ʼ��һ���ձ���
	 * @param:    
	 * @throws
	 */
	public Bag(){
		first=null;
		n=0;
	}
	
	/**
	 * 
	 * @Title: isEmpty   
	 * @Description: TODO
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public boolean isEmpty(){
		return first==null;
	}
	/**
	 * 
	 * @Title: size   
	 * @Description: TODO
	 * @param: @return      
	 * @return: ����Ԫ�ص�����      
	 * @throws
	 */
	public int size(){
		return n;
	}
	
	public void add(Item item){
		Node<Item> oldfirst=first;
		first=new Node<Item>();
		first.item=item;
		first.next=oldfirst;
		n++;
	}
	/**
	 * 
	 * @Title: iterator   
	 * @Description: ���ص��������õ�������������˳�����Ŀ
	 * @param: @return      
	 * @return: Iterator<Item>      
	 * @throws
	 */
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator<Item>(first);
	}

	private class ListIterator<Item> implements Iterator<Item>{

		private Node<Item> current;
		 
		public ListIterator(Node<Item> first){
			current=first;
		}
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			Item item=current.item;
			current=current.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
	}
}
