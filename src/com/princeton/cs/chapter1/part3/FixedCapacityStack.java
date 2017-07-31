package com.princeton.cs.chapter1.part3;

import com.princeton.cs.util.StdIn;
import com.princeton.cs.util.StdOut;

public class FixedCapacityStack<Item> {
	private int N;
	private Item[] a;
	public FixedCapacityStack(int cap){
		a=(Item[]) new Object[cap];
	}
	
	public void push(Item item){
		a[N++]=item;
	}
	
	public Item pop(){
		return a[--N];
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	
	public static void main(String[] args){
		FixedCapacityStack<String> s;
		s=new FixedCapacityStack<String>(100);
		while(!StdIn.isEmpty()){
			String item=StdIn.readString();
			if(!item.equals("-")){
				s.push(item);
			}else if(!s.isEmpty()){
				StdOut.println(s.pop()+" ");
			}
		}
		StdOut.println("("+s.size()+" left on stack)");
	}
}
