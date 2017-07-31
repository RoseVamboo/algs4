package com.princeton.cs.chapter1.part3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import com.princeton.cs.util.In;
import com.princeton.cs.util.StdIn;
import com.princeton.cs.util.StdOut;


public class BinarySearch {
	public static void main(String[] args){
		//int[] whiteList=In.readInts(args[0]);
		//tinyW.txt
		int[] whiteList=In.readInts("src/data/largeW.txt");
		Arrays.sort(whiteList);
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/data/largeT.txt");
			System.setIn(fis);  
	          
	        Scanner sc=new Scanner(System.in); 
	        new StdIn(sc);
	        int index=0;
			while(!StdIn.isEmpty()){
				int key=StdIn.readInt();
				if(rank(key,whiteList)<0){
					index++;
					StdOut.println(key);
				}
			}
			StdOut.println("index="+index);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
	}
	public static int rank(int key,int[] a){
		//数组必须是有序的
		int lo=0;
		int hi=a.length-1;
		while(lo<=hi){
			int mid=lo+(hi-lo)/2;
			if(key<a[mid]){
				hi=mid-1;
			}else if(key>a[mid]){
				lo=mid+1;
			}else{
				return mid;
			}
			
		}
		return -1;
	}
}
