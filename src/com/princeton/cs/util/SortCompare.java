package com.princeton.cs.util;

import com.princeton.cs.chapter2.Insertion;
import com.princeton.cs.chapter2.Selection;

public class SortCompare {
	public static double time(String alg,Double[] a){
		Stopwatch timer=new Stopwatch();
		if(alg.equals("Insertion"))Insertion.selectionSort(a);
		if(alg.equals("Selection"))Selection.sort(a);
		//if(alg.equals("Insertion"))Insertion.sort(a);
		//if(alg.equals("Insertion"))Insertion.sort(a);
		//if(alg.equals("Insertion"))Insertion.sort(a);
		//if(alg.equals("Insertion"))Insertion.sort(a);
		return timer.elapsedTime();
	}
	public static double timeRandomInput(String alg,int N,int T){
		//使用算法alg将T个长度为N的数组排序
		double total=0.0;
		Double[] a=new Double[N];
		for(int t=0;t<T;t++){
			//进行一次测试,(生成一个数组并排序)
			for(int i=0;i<N;i++){
				a[i]=StdRandom.uniform();
			}
			total+=time(alg, a);
		}
		return total;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=1000;
		int T=400;
		double t1=timeRandomInput("Insertion", N, T);
		double t2=timeRandomInput("Selection", N, T);
		System.out.println("Insertion="+t1);
		System.out.println("Selection="+t2);
		System.out.println("faster="+t2/t1);
	}

}
