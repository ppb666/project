package test;

import java.util.Scanner;

public class Demo03 {
	
	static Item [] item= {
			new Item(1,"vivo","55",22),
			new Item(2,"lianxiang","666",33),
			new Item(3,"huawei","777",44),
			new Item(4,"jd","888",55),
			new Item(5,"bd","999",77) 
			 
			
			};
	public static void main(String[] args) {
		other:
			while (true) {
				int c = caidan();
				int sum = new Scanner(System.in).nextInt();
				switch(sum) {
				case 1:f1();break;
				case 2:f2();break;
				case 3:f3();break;
				case 4:f4();break;
				case 5:f5();break;
				}
				
			}
	}
	private static void f5() {
		// TODO Auto-generated method stub
		
	}
	private static void f4() {
		// TODO Auto-generated method stub
		
	}
	private static void f3() {
		// TODO Auto-generated method stub
		
	}
	private static void f2() {
		// TODO Auto-generated method stub
		
	}
	private static void f1() {
		// TODO Auto-generated method stub
		
	}
	private static int caidan() {
		// TODO Auto-generated method stub
		return 0;
	}		

}
