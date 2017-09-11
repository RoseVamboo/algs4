package com.princeton.cs.chapter2;

import com.princeton.cs.util.StdOut;

public class Merge {
	public static void merge(int[] a,int low,int mid,int hight){
		int i=low;
		int j=mid+1;
		int[] aux=new int[hight+1];
		for(int l=low;l<=hight;l++)
			aux[l]=a[l];
		for(int k=low;k<=hight;k++){
			if(i>mid){
				a[k]=aux[j++];
			}else if(j>hight){
				a[k]=aux[i++];
			}else if(less(a[i],a[j])){
				a[k]=aux[i++];
			}else{
				a[k]=aux[j++];
			}
		}
	}
	private static boolean less(int i, int j) {
		// TODO Auto-generated method stub
		return i<j;
	}
	public static void mergeSort(int[] a,int start,int end){
		if(start>=end){
			return;
		}
		int mid=start+(end-start)/2;
		mergeSort(a, start, mid);
		mergeSort(a, mid+1, end);
		merge(a, start, mid, end);
		
	}
	public static void main(String[] args) {
		int[] b = { 49, 38, 65, 97, 76, 13, 27, 50 };
		mergeSort(b,0,7);
		for(int i=0;i<b.length;i++){
			StdOut.print(b[i]+" ");
		}
	}
}
