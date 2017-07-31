package com.princeton.cs.chapter1.part3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @ClassName:  Bag   
 * @Description:TODO   
 * @author: RoseVorchid  
 * @date:   2017年5月6日 下午7:52:12   
 *   
 * @param <Item>
 */
public class Bag<Item> implements Iterable<Item> {

	private Node<Item> first;//背包的开始节点
	private int n;//背包元素的数量
	
	//节点
	private static class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	/**
	 * 
	 * @Title:  Bag   
	 * @Description:初始化一个空背包
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
	 * @return: 背包元素的数量      
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
	 * @Description: 返回迭代器，该迭代器包含任意顺序的项目
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
