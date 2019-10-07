package test;

import java.util.LinkedList;
import java.util.Scanner;


public class Demo08 {

	public static void main(String[] args) {
		System.out.println("丑数");
		int a  = new Scanner(System.in).nextInt();
		long r = f(a);
		System.out.println(r);
	}

	private static long f(int a) {
		if(a==1) {
			return 1;
		}
		LinkedList<Long> link1 = new LinkedList<Long>();
		LinkedList<Long> link2 = new LinkedList<Long>();
		LinkedList<Long> link3 = new LinkedList<Long>();
		link1.add(2L);
		link2.add(3L);
		link3.add(5L);
		long r  = 0;
		//从第2个求到第n个
		for (int i = 2; i <= a ; i++) {
			//移除头部最小值
			Long l1 = link1.getFirst();
			Long l2 = link2.getFirst();
			Long l3 = link3.getFirst();
			r = Math.min(l1, Math.min(l2, l3));
			if(r==l1) link1.removeFirst();
			if(r==l2) link2.removeFirst();
			if(r==l3) link3.removeFirst();
			//乘 2 3 5 放入集合
			link1.add(r*2);
			link1.add(r*3);
			link1.add(r*5);
			
		}
		return r;
	}
}
