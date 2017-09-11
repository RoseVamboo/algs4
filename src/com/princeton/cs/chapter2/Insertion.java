package com.princeton.cs.chapter2;

import com.princeton.cs.util.StdOut;

public class Insertion {
	public static void sort(Comparable[] a){
		//��a[]��������
		int N=a.length;
		for(int i=1;i<N;i++){
			for(int j=i;j>0&&less(a[j], a[j-1]);j--){
				exch(a, j, j-1);
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
		//int[] inta={1,7,3,4,8,1,4,0};
		//selectionSort1(inta);
	}
	/**
	 * ��������-int���͵�����
	 */
	public static void selectionSort(Double[] a){
		if(a==null||a.length==0){
			System.out.println("����Ϊ��");
		}else{
			for(int i=1;i<a.length;i++){
				double temp=a[i];
				int p=i;
				for(int j=i-1;j>=0;j--){
					if(temp<a[j]){
						a[j+1]=a[j];
						p-=1;
					}else{
						continue;
					}
				}
				a[p]=temp;
			}
//			for(int i=0;i<a.length;i++){
//				System.out.print(a[i]+" ");
//			}
		}
	}
	
	public static void selectionSort1(Double[] a){
		if(a==null||a.length==0){
			System.out.println("����Ϊ��");
		}else{
			for(int i=1;i<a.length;i++){
				double temp=a[i];
				//int p=i;
				for(int j=i-1;j>=0;j--){
					if(temp<a[j]){
						a[j+1]=a[j];
						a[j]=temp;
						//p-=1;
					}else{
						continue;
					}
				}
				//a[p]=temp;
			}
			/*for(int i=0;i<a.length;i++){
				System.out.print(a[i]+" ");
			}*/
		}
	}
}
