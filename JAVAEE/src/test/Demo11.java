package test;

import test.A.Inner1;
import test.A.Inner2;

//内部类
public class Demo11 {
	public static void main(String[] args) {
		Inner1 i = new Inner1();
		System.out.println(i);
		A a = new A();
		Inner2 ii  = a.new Inner2();
		System.out.println(ii);
	}

}
class A{
	static class Inner1 {
		
	}
class Inner2{
		
	}
}
