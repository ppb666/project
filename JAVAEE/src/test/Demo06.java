package test;

import java.util.Random;
import java.util.Scanner;

public class Demo06 {

	public static void main(String[] args) {
		//产生随机值
		String s = suiji();
		//显示提示
		tishi(); 
		//比较c和随机值
		while(true) {
		System.out.println("猜");
		String out = new Scanner(System.in).nextLine();
		String result = bijiao(s,out);
		//查看结果
		if(caidui(result)) {
			break;
		}
		}
		
		
	}

	private static boolean caidui(String result) {
		
		return result.equals("对了");
	}

	private static String bijiao(String s, String out) {
		int suiji = Integer.parseInt(s);
		int shuchu = Integer.parseInt(out);
		if(shuchu>suiji) {
			System.out.println("大了");
		}else if(shuchu<suiji) {
			System.out.println("小了");
		}
		
		System.out.println("sdqwdqwd");
		return "对了";
		    
		
	}

	private static void tishi() {
		System.out.println("1-1000随机数已经产生");
		System.out.println("猜一猜");
	}

	private static String suiji() {
		int  suiji =1 + new Random().nextInt(10);
		return String.valueOf(suiji);
	}
}
