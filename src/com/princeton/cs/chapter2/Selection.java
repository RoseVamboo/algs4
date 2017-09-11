package com.princeton.cs.chapter2;

import com.princeton.cs.util.StdOut;

public class Selection {
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
		//assert isSorted(a);
		//show(a);
		int[] inta={1,7,3,4,8,1,4,0};
		selectionSort(inta);
	}
	/**
	 * ѡ������-int���͵�����
	 */
	public static void selectionSort(int[] a){
		if(a==null||a.length==0){
			System.out.println("���鲻���ڻ�û��ֵ");
		}else{
			for(int i=0;i<a.length-1;i++){
				int min=a[i];
				int index=i;
				for(int j=i+1;j<a.length;j++){
					if(a[j]<min){
						min=a[j];
						index=j;
					}
				}
				a[index]=a[i];
				a[i]=min;
			}
			for(int i=0;i<a.length;i++){
				System.out.print(a[i]+" ");
			}
		}
	}
}
