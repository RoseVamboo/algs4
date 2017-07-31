package com.princeton.cs.chapter1.part3;

import com.princeton.cs.util.StdIn;
import com.princeton.cs.util.StdOut;

public class Average {
	public static void main(String[] args){
		double sum=0.0;
		int cnt=0;
		//ctrl-zΩ· ¯‘À––
		while(!StdIn.isEmpty()){
			sum+=StdIn.readDouble();
			cnt++;
		}
		double avg=sum/cnt;
		StdOut.printf("Average is %.5f\n", avg);
	}
}
