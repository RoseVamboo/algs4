package com.princeton.cs.chapter2;

import com.princeton.cs.util.StdOut;

public class Main extends MinPQ<Integer> {

	public Main(int maxN) {
		super(maxN);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main1=new Main(10);
		main1.insert(1);
		main1.insert(4);
		main1.insert(6);
		main1.insert(0);
		main1.insert(5);
		main1.insert(3);
		main1.insert(8);
		main1.insert(9);
		main1.insert(2);
		main1.insert(7);
		main1.print();
		StdOut.println();
		int N=main1.size();
		for(int i=1;i<N+1;i++){
			int value=main1.delMin();
			StdOut.print(value+" ");
		}/**/
	}
}
