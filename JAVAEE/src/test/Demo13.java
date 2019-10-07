package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Demo13 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();

		Collections.addAll(list, "12", "22", "33", "44", "11", "25", "166", "77");
		System.out.println(list);
		Collections.sort(list);// 集合排序
		System.out.println(list);

		Comparator<String> com = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int a = Integer.parseInt(o1);
				int b = Integer.parseInt(o2);
				return a - b;
			}
		};

		Collections.sort(list, com);
		System.out.println(list);

		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			String next = it.next();
			System.out.println(next);
		}
		System.out.println("--------------------");
		for (String string : list) {
			System.out.println(string);
		}

	}
}
