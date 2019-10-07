package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class ChatClient {
	Socket s;
	BufferedReader in;
	PrintWriter out;
	String name;

	LinkedList<String> list = new LinkedList<String>();

	private void launch() {

		try {
			s = new Socket("服务器i地址", 8000);

			in = new BufferedReader // 一行一行读取
			(new InputStreamReader // 编码转换流
			(s.getInputStream(), "UTF-8"));
			out = new PrintWriter // 输出自动补换行
			(new OutputStreamWriter // 编码转换流
			(s.getOutputStream(), "UTF-8"));
			System.out.println("给自己取一个名字");
			name = new Scanner(System.in).nextLine();
			out.println(name);
			out.flush();

			// 反复在控制台输入聊天内容,输入线程
			new Thread() {
				public void run() {
					input();
				}

			}.start();

			// 反复从服务器接收聊天数据,接收线程
			new Thread() {
				public void run() {
					receive();

				}

			}.start();

			// 打印线程

			new Thread() {
				public void run() {

					print();
				};

			}.start();
		} catch (Exception e) {
			System.out.println("无法连接到聊天室");
			e.printStackTrace();
		}

	}

	boolean flag = false;

	protected void input() {

		System.out.println("按回车输入聊天内容");
		while (true) {
			new Scanner(System.in).nextLine();
			flag = true;// 输入的开关,正在输入
			System.out.println("输入聊天内容:");
			String str = new Scanner(System.in).nextLine();
			out.println(str); // 有in 自动补换行
			out.flush();

			flag = false;
			synchronized (list) {
				list.notifyAll();

			}
		}

	};

	protected void receive() {
		try {
			String line;
			while ((line = in.readLine()) != null) {
				synchronized (list) {

					list.add(line);
					list.notifyAll();
				}
			}
		} catch (Exception e) {

		}
		System.out.println("已经与服务器断开连接");
	}

	protected void print() {
		while (true) {
			synchronized (list) {
				while (list.isEmpty() || flag) {
					try {
						list.wait();
					} catch (Exception e) {

					}

				}
				String msg = list.removeFirst();
				System.out.println(msg);
			}

		}

	}

	public static void main(String[] args) {

		ChatClient c = new ChatClient();
		c.launch();
	}

}
