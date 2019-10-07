package test;

import java.util.Scanner;

// 2 8  16  位运算
public class Demo09 {
	public static void main(String[] args) {
		System.out.println("输入一个值");
		int n = new Scanner(System.in).nextInt();
		String s = Integer.toBinaryString(n);
		System.out.println(s);
		
		System.out.println("二进制");
		s = new Scanner(System.in).nextLine();
		n = Integer.parseInt(s,2);
		System.out.println(n);
		
		System.out.println("输入整数");
		int math = new Scanner(System.in).nextInt();
		int h =  f(math);
		System.out.println(h);
		
		System.out.println("输入整数--------");
		int x = new Scanner(System.in).nextInt();
		byte [] b = f1(x);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		//合并
		int xx = f2(x);
		System.out.println(xx);
	}

	private static int f2(int x) {
		byte[] b = new byte [4] ;
		int r = 0;
		for (int i = 0; i < b.length; i++) {
			r |=  ((b[i]&0x000000ff) <<(8*(3-1)));
		}
		return r;
	}

	private static byte[] f1(int x) {
		byte[] b = new byte [4] ;
		for (int i = 0; i < b.length; i++) {
			// 24 26 8 0
			b[i] = (byte) (x>>(8*(b.length-1)));
		}
		return b;
	}

	private static int f(int math) {
		int r = math<<24>>>24;
		return r;  // 交互10 进制
	}

}
