package com.princeton.cs.chapter2;


import com.princeton.cs.util.StdOut;

public class QuickSort {
	public static void quickSort(int arr[],int _left,int _right){
		int left=_left;
		int right=_right;
		int temp=0;
		if(left<right){
			temp=arr[left];
			while(left!=right){
				while(right>left&&arr[right]>=temp){
					right--;
				}
				arr[left]=arr[right];
				while(left<right&&arr[left]<=temp){
					left++;
				}
				arr[right]=arr[left];
			}
			arr[right]=temp;
			quickSort(arr, _left, left-1);
			quickSort(arr, right+1, _right);
		}
		
	}
	public static void main(String[] args) {
		int arr[]={5,10,3,1,7,2,8};
		StdOut.println("排序之前");
		for(int element:arr){
			StdOut.print(element+" ");
		}
		StdOut.println("");
		quick(arr, 0, arr.length-1);
		StdOut.println("排序之后");
		for(int element:arr){
			StdOut.print(element+" ");
		}
	}
	
	public static void quick(int arr[],int _left,int _right){
		int temp=0;
		int left=_left;
		int right=_right;
		
		if(left<right){
			temp=arr[left];
		while(left!=right){
			while(right>left&&arr[right]>=temp){
				right--;
			}
			arr[left]=arr[right];
			while(left<right&&arr[left]<=temp){
				left++;
			}
			arr[right]=arr[left];
		}
		arr[left]=temp;
		StdOut.println("left="+left+" right="+right+" temp="+temp);
		quick(arr,_left,left-1);
		quick(arr, right+1, _right);
	}		
	}
}
