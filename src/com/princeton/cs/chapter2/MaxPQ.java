package com.princeton.cs.chapter2;

import com.princeton.cs.util.StdOut;


public class MaxPQ <Key extends Comparable<Key>>{
	
	private Key[] pq;//基于堆的完全二叉树
	private int N=0;//存储于pq[1..N]中,pq[0]没有使用
	
	public MaxPQ(int maxN){
		this.pq=(Key[]) new Comparable[maxN+1];
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void insert(Key v){
		pq[++N]=v;
		swim(N);
	}

	public void print(){
		for(int i=1;i<=N;i++){
			StdOut.print(pq[i]+" ");
		}
	}
	public Key delMax(){
		Key max=pq[1];//从根节点得到最大元素
		exch(1,N--);//将其和最后一个结点交换
		pq[N+1]=null;//防止对象游离
		sink(1);//恢复堆的有序性
		return max;
	}
	//一些辅助方法
	private void swim(int k) {
		while(k>1&&less(k/2,k)){
			exch(k/2,k);
			k=k/2;
		}
	}
	private boolean less(int i, int k) {
		// TODO Auto-generated method stub
		return pq[i].compareTo(pq[k])<0;
	}

	private void sink(int k) {
		while(2*k<=N){
			int j=2*k;
			if(j<N&&less(j, j+1))j++;
			if(!less(k,j))break;
			exch(k,j);
			k=j;
		}
	}

	private void exch(int i, int j) {
		// TODO Auto-generated method stub
		Key temp=pq[i];
		pq[i]=pq[j];
		pq[j]=temp;
		
	}
	
	
}
