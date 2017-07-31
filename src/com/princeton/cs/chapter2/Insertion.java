package com.princeton.cs.chapter2;

import com.princeton.cs.util.StdOut;

public class Insertion {
	public static void sort(Comparable[] a){
		//��a[]��������
		int N=a.length;
		for(int i=0;i<N-1;i++){
			int min=i;
			for(int j=i+1;j<N;j++){
				if(less(a[j], a[min]))min=j;
				exch(a, i, min);
			}
		}
	}
	private static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	private static void exch(Comparable[] a,int i,int j){
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static void show(Comparable[] a){
		//�ڵ����д�ӡ����
		for(int i=0;i<a.length;i++)
			StdOut.print(a[i]+" ");
		StdOut.println();
	}
	public static boolean isSorted(Comparable[] a){
		//��������Ԫ���Ƿ�����
		for(int i=1;i<a.length;i++)
			if(less(a[i], a[i-1]))return false;
		return true;
	}
	public static void main(String[] args) {
		//�ӱ�׼�����ȡ�ַ���,�������������
		//String[] a=In.readStrings();
		String[] a={"S","O", "R" ,"T", "E", "X", "A", "M", "P", "L", "E"};
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
