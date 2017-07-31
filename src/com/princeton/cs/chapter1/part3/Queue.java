package com.princeton.cs.chapter1.part3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.princeton.cs.util.StdIn;
import com.princeton.cs.util.StdOut;

/**
 * 
 * @ClassName:  Queue   
 * @Description:TODO   
 * @author: RoseVorchid  
 * @date:   2017年5月9日 上午9:08:43   
 * @param <Item>
 */
public class Queue<Item> implements Iterable<Item> {
	private Node<Item> first;//begining of queue
	private Node<Item> last;//end of queue
	private int n;
	
	private static class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	//Initializes an empty queue
	public Queue(){
		first=null;
		last=null;
		n=0;
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public int size(){
		return n;
	}
	/**
	 * 
	 * @Title: peek   
	 * @Description: TODO
	 * @param: @return      
	 * @return: Return the item least recently added to this queue      
	 * @throws
	 */
	public Item peek(){
		if(isEmpty())throw new NoSuchElementException("Queue underflow");
		return first.item;
	}
	//入队列
	public void enqueue(Item item){
		/*Node<Item> oldlast=last;
		last=new Node<Item>();
		last.item=item;
		last.next=null;
		if(isEmpty()) first=last;
		else oldlast.next=last;*/
		Node<Item> newLast=new Node<Item>();
		newLast.item=item;
		newLast.next=null;
		
		if(isEmpty()) {
			last=newLast;
			first=last;
		
		}else{
			last.next=newLast;
			last=last.next;
		}
		
		//else oldlast.next=last;
		
		n++;
	}
	//出队列
	public Item dequeue(){
		if(isEmpty())throw new NoSuchElementException("Queue underflow");
		Item item=first.item;
		first=first.next;
		n--;
		if(isEmpty())last=null;
		return item;
	}
	public String toString(){
		StringBuilder s=new StringBuilder();
		for(Item item:this){
			s.append(item);
			s.append(' ');
		}
		return s.toString();
	}
	/**
	 * 
	 * <p>Title: iterator</p>   
	 * <p>Description: </p>   
	 * @return  an iterator that 
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<Item> iterator(){
		return new ListIterator<Item>(first);
	}
	
	private class ListIterator<Item> implements Iterator<Item>{
		private Node<Item> current;
		public ListIterator(Node<Item> first) {
			current=first;
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		@Override
		public Item next() {
			if(!hasNext())throw new NoSuchElementException();
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
	 public static void main(String[] args) {
	        Queue<String> queue = new Queue<String>();
	        while (!StdIn.isEmpty()) {
	            String item = StdIn.readString();
	            if (!item.equals("-"))
	                queue.enqueue(item);
	            else if (!queue.isEmpty())
	                StdOut.print(queue.dequeue() + " ");
	        }
	        StdOut.println("(" + queue.size() + " left on queue)");
	    }
}
