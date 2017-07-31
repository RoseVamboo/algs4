package com.princeton.cs.chapter1.part3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.princeton.cs.util.StdIn;
import com.princeton.cs.util.StdOut;


public class Stats {

	public static void main(String[] args) {
		Bag<Double> numbers=new Bag<Double>();
		List<Double> numbersList=new ArrayList<Double>();
		List<Double> linkList=new LinkedList<Double>();
		Set<Double> hashSet=new HashSet<Double>();
		Set<Double> treeSet=new TreeSet<Double>();
		while(!StdIn.isEmpty()){
			double ss=StdIn.readDouble();
			System.out.println(ss);
			numbers.add(ss);
		}
		int N=numbers.size();
		System.out.println("N="+N);
		double sum=0.0;
		for(double x:numbers){
			System.out.println("N1="+x);
			sum+=x;
		}
		double mean=sum/N;
		
		sum=0;
		for(double x:numbers)
			sum+=(x-mean)*(x-mean);
		double std=Math.sqrt(sum/(N-1));
		
		StdOut.printf("Mean: %.2f\n",mean);
		StdOut.printf("Std dev: %.2f\n",std);
	}

}
