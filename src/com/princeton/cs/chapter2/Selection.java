package com.princeton.cs.chapter2;

import com.princeton.cs.util.StdOut;

public class Selection {
	public static void sort(Comparable[] a){
		//将a[]升序排列
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
		//在单行中打印数组
		for(int i=0;i<a.length;i++)
			StdOut.print(a[i]+" ");
		StdOut.println();
	}
	public static boolean isSorted(Comparable[] a){
		//测试数组元素是否有序
		for(int i=1;i<a.length;i++)
			if(less(a[i], a[i-1]))return false;
		return true;
	}
	public static void main(String[] args) {
		//从标准输入读取字符串,将它们排序并输出
		//String[] a=In.readStrings();
		String[] a={"S","O", "R" ,"T", "E", "X", "A", "M", "P", "L", "E"};
		sort(a);
		//assert isSorted(a);
		//show(a);
		int[] inta={1,7,3,4,8,1,4,0};
		selectionSort(inta);
	}
	/**
	 * 选择排序-int类型的数据
	 */
	public static void selectionSort(int[] a){
		if(a==null||a.length==0){
			System.out.println("数组不存在或没有值");
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
