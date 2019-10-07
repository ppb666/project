package test;

import java.util.Scanner;

public class Demo01 {

//	int [] [] a  = new int[1] [];
	int [] [] a= {{1,2,3},{1,2,3}};
	public static void main(String[] args) {
		while(true) {
		Scanner s = new Scanner(System.in);
		System.out.println("输入一个递归数");
		int sum = s.nextInt();
		int math  = method(sum);
		System.out.println(math);
		if(sum ==10) {
			System.out.println("递归结束");
			break;
		}
	}
	}
	private static int method(int sum) {
		if(sum == 1) {
			return 1;
		}else {
			return sum*method(sum-1);
			/*
			 * 5*4*3*2*1
			 * sum * method (sum-1)
			 * 5 * method  (5-1)
			 */
		}
		
	}
}
