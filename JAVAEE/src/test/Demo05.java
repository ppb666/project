package test;

import java.util.Scanner;

/**
 * 斐波那契数
 * @author lenovo
 *
 */
public class Demo05 {

	public static void main(String[] args) {
		while(true) {
		System.out.println("输入第几个斐波那契数------方法1");
		int s = new Scanner(System.in).nextInt();
//		Long sum = f(s);
//		System.out.println(sum);
		System.out.println("输入第几个斐波那契数------方法2");
		Long sum2=f2(s);
		System.out.println(sum2);
	}
	}

	private static Long f2(int s) {
		long a = 1;
		long b = 1;
		for (int i = 3; i < s; i++) {
			b=a+b;
			a=b-a;
		}
		return b;
	}

	private static long f(int s) {
		if(s==1||s==2) {
			return 1;
		}
		
		return f(s-1)+f(s-2);
		
		
	}
}
