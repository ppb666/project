package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args)throws Exception {
		Socket s = new Socket("服务器i地址",8000);
		
		BufferedReader in;
		PrintWriter out;
		
		in = 
				new BufferedReader   //一行一行读取
				(new InputStreamReader  //编码转换流
						(s.getInputStream(),"UTF-8"));
	out = 
			new PrintWriter  //输出自动补换行
			(new OutputStreamWriter  //编码转换流
					(s.getOutputStream(),"UTF-8") );
	
	while (true) {
		System.out.println("输入:");
		String str = new Scanner(System.in).nextLine();
		out.println(str);  //有in 自动补换行
		out.flush();
		String echo = in.readLine();
		System.out.println("回声+"+echo);
	}
	}
}
