package com.princeton.cs.chapter1.part3;

import com.princeton.cs.util.StdIn;
import com.princeton.cs.util.StdOut;


public class Evaluate {
	public static void main(String[] args) {
		
		Stack<String> ops=new Stack<String>();
		Stack<Double> vals=new Stack<Double>();
		while(!StdIn.isEmpty()){
			//读取字符，如果是云算法则压入栈
			String s=StdIn.readString();
			if(s.equals("("));
			else if(s.equals("+"))ops.push(s);
			else if(s.equals("-"))ops.push(s);
			else if(s.equals("*"))ops.push(s);
			else if(s.equals("/"))ops.push(s);
			else if(s.equals("sqrt"))ops.push(s);
			else if(s.equals(")")){
				//如果字符为)，弹出云算法和操作数,计算结果并压入栈
				String op=ops.pop();
				double v=vals.pop();
				if(op.equals("+"))v=vals.pop()+v;
				else if(op.equals("-")) v=vals.pop()-v;
				else if(op.equals("*")) v=vals.pop()*v;
				else if(op.equals("/")) v=vals.pop()/v;
				else if(op.equals("sqrt"))v=Math.sqrt(v);
				vals.push(v);
			}
			//如果字符既非运算符也不是括号，将它作为double值压入栈
			else vals.push(Double.parseDouble(s));
		}
		StdOut.println(vals.pop());
	}
}
