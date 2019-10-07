package reflect;

import java.util.Scanner;

public class Demo01 {

	
	public static void main(String[] args) throws Exception {
		System.out.println("输入类名");
		String s = new Scanner(System.in).nextLine();
		Class<?> c = Class.forName(s);
		System.out.println(c.getName());
		System.out.println(c.getPackage().getName());
		System.out.println(c.getSimpleName());
	}
}
