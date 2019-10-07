package test;

import java.util.Random;

public class Demo10 {
	public static String main(String[] args) {
		StringBuilder sb = new StringBuilder("asdasdasdasdasdasdgdsgdfg");
	for (int i = 0; i < 5; i++) {
		//随机选择位置
		int j = 
			i+ new Random().nextInt(sb.length()-i);
		char t = sb.charAt(i);//i j 交换
		sb.setCharAt(i, sb.charAt(j));
		sb.setCharAt(j, t);
		
	}
	sb.delete(5, sb.length()); // 删除后面
	return sb.toString(); // 转换成字符串
	
	}

}
