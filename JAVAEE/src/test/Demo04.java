package test;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Demo04 {

	public void Student() {
		Integer id;
		Weapon  weapon;
		
	}
	public static void main(String[] args) {
		String s = "wdkajsddshfkdsjkfhdshf";
		String  s1 = "";
		Long t = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			s1+=s;
		}
		t = System.currentTimeMillis()-t;
		System.out.println(t);
		System.out.println(s);
		
		
		
		String s2 = "wdkajsddshfkwdqdqwdqdqdqwdwqdsjkfhdshf";
		StringBuilder s3 = new StringBuilder();
		Long t1 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			s3.append(s2);
		}
		t1 = System.currentTimeMillis()-t1;
		System.out.println(t1);
		System.out.println(s2);
	   
	}
}
