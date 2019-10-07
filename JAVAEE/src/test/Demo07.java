package test;

import java.util.Iterator;
import java.util.LinkedList;

public class Demo07 {

	public static void main(String[] args) {
		LinkedList<String> linked = new LinkedList<String>();
		linked.add("123123");
		linked.add("sdadasd");
		linked.add("asdasfdsf");
		linked.add("gdffh");
		linked.add("fghfgh");
		linked.add("ghjhj");
		linked.add("123ghjgh123");
		linked.add("ghjgh");
		linked.add("123ghjghj123");
		linked.add("ghjg");
		for (int i = 0; i < linked.size(); i++) {
			String s = linked.get(i);
			System.out.println(s);
			
		}
		System.out.println("666666666666666666");
		Iterator<String> it =linked.iterator();
		while (it.hasNext()) {
			String str = it.next();
			System.out.println(str);
			
		}
	}
}
