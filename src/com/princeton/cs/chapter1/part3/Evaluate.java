package com.princeton.cs.chapter1.part3;

import com.princeton.cs.util.StdIn;
import com.princeton.cs.util.StdOut;


public class Evaluate {
	public static void main(String[] args) {
		
		Stack<String> ops=new Stack<String>();
		Stack<Double> vals=new Stack<Double>();
		while(!StdIn.isEmpty()){
			//��ȡ�ַ�����������㷨��ѹ��ջ
			String s=StdIn.readString();
			if(s.equals("("));
			else if(s.equals("+"))ops.push(s);
			else if(s.equals("-"))ops.push(s);
			else if(s.equals("*"))ops.push(s);
			else if(s.equals("/"))ops.push(s);
			else if(s.equals("sqrt"))ops.push(s);
			else if(s.equals(")")){
				//����ַ�Ϊ)���������㷨�Ͳ�����,��������ѹ��ջ
				String op=ops.pop();
				double v=vals.pop();
				if(op.equals("+"))v=vals.pop()+v;
				else if(op.equals("-")) v=vals.pop()-v;
				else if(op.equals("*")) v=vals.pop()*v;
				else if(op.equals("/")) v=vals.pop()/v;
				else if(op.equals("sqrt"))v=Math.sqrt(v);
				vals.push(v);
			}
			//����ַ��ȷ������Ҳ�������ţ�������Ϊdoubleֵѹ��ջ
			else vals.push(Double.parseDouble(s));
		}
		StdOut.println(vals.pop());
	}
}
