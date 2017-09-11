package com.princeton.cs.chapter2;

import com.princeton.cs.util.StdOut;

public class Shell_1 {
	public static void shellSort1(int[] a){
		int n=a.length;
		int j=0;
		for(int gap=n/2;gap>0;gap/=2){
			for(int i=gap;i<n;i++){
				int temp=a[i];
				j=i-gap;
				while(j>=0&&temp<a[j]){
					a[j+gap]=a[j];
					j-=gap;
				}
				a[j+gap]=temp;
			}
		}
	}
	public static void shellSort(int[] a){
		if(a==null||a.length<=1){
			StdOut.println("Êý×éÎª¿Õ");
			return;
		}
		int gap=a.length/2;
		while(gap>=1){
			for(int i=0;i<a.length;i++){
				for(int j=i;j<a.length-gap;j+=gap){
					if(a[j]>a[j+gap]){
						int temp=a[j];
						a[j]=a[j+gap];
						a[j+gap]=temp;
					}
				}
			}
			gap/=2;
		}
	}
	 public static void main(String[] args) {
	        int i;
	        int a[] = {80,30,60,40,20,10,50,70};

	        System.out.printf("before sort:");
	        for (i=0; i<a.length; i++)
	            System.out.printf("%d ", a[i]);
	        System.out.printf("\n");

	        shellSort(a);
	        //shellSort2(a, a.length);

	        System.out.printf("after  sort:");
	        for (i=0; i<a.length; i++)
	            System.out.printf("%d ", a[i]);
	        System.out.printf("\n");
	    }
}
