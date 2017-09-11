package com.princeton.cs.chapter2;

import com.princeton.cs.util.StdOut;

public class MinPQ <Key extends Comparable<Key>>{
	private Key[] pq;
	private int N=0;
	
	public MinPQ(int minN){
		pq=(Key[]) new Comparable[minN+1];
	}
	public boolean isEmpty(){
		return N==0;
	}
	
	public int size(){
		return N;
	}
	
	public void print(){
		for(int i=1;i<=N;i++){
			StdOut.print(pq[i]+" ");
		}
	}
	public void insert(Key key){
		pq[++N]=key;
		swim(N);
	}
	private void swim(int i) {
		// TODO Auto-generated method stub
		while(i>1&&less(i,i/2)){
			exch(i/2,i);
			i=i/2;
		}
	}
	private void exch(int i, int i2) {
		Key temp=pq[i];
		pq[i]=pq[i2];
		pq[i2]=temp;
	}
	private boolean less(int i, int i2) {
		// TODO Auto-generated method stub
		return pq[i].compareTo(pq[i2])<0;
	}
	public Key delMin(){
		Key v=pq[1];
		exch(1,N--);
		pq[N+1]=null;
		sink(1);
		return v;
	}
	private void sink(int k) {
		while(2*k<=N){
			int j=2*k;
			if(j<N&&less(j+1, j))j++;
			if(!less(j,k))break;
			exch(k,j);
			k=j;
		}
	}
}
