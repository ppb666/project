package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import socket.EchoServer.TongXunThread;

public class ChatServer {

	
	private ArrayList<TongXunThread> list = new ArrayList<>();
	
	private void launch() {
		
		
		
		new Thread() {
			@Override
			public void run() {
				try {
                ServerSocket socket = new ServerSocket(8000);
                System.out.println("服务在8000端口已经启动");
                while (true) {
					Socket s = socket.accept();
					TongXunThread t = new TongXunThread(s);
					t.start();
					System.out.println("一个客户端启动");
					
				}
				} catch (Exception e) {
    System.out.println("服务无法在8000端口启动,服务异常终止");
				}

			};

		}.start();
	}
	
	class TongXunThread extends Thread{
		Socket s;
		BufferedReader in;
		PrintWriter out;
		private String name;
		public TongXunThread(Socket s) {
			this.s=s;
			
			
		}
		private void send(String msg) {
   
				out.println(msg);
				out.flush();
		}
		private void sendAll(String msg) {
 
			synchronized (list) {
				for (TongXunThread t : list) {
					t.send(msg);
				}
				
			}
		}
		
		@Override
		public void run() {
   try {
	  
	   
	   
	   in = 
				new BufferedReader   //一行一行读取
				(new InputStreamReader  //编码转换流
						(s.getInputStream(),"UTF-8"));
	   
	   out = 
				new PrintWriter  //输出自动补换行
				(new OutputStreamWriter  //编码转换流
						(s.getOutputStream(),"UTF-8") );
	
	   //从客户端接收一个昵称
	   this.name = in.readLine();
	   send("欢迎进入裸聊聊天室");
	  
	   s.setSoTimeout(3000);  // 接收数据的等待超时时间
	   synchronized (list) {
		   list.add(this); //把当前通信线程的实例,添加到list
		
	}
	   //群发一个上线消息
	   //发给所有ren
	   sendAll(name+"进入了裸聊聊天室");
	   
	   //聊天过程
	   
	   String line;
	   while((line = in.readLine())!=null) {
		   sendAll(line); // 聊天内容向所有客户端群发
	   }
	   
			} catch (Exception e) {
				
				
			}
   
synchronized (list) {
	list.remove(this); //客户端断开,删除当前通讯实例
}
sendAll(name+"离开了裸聊聊天室 当前在线人数"+list.size());

		}
	}
	public static void main(String[] args) {
		ChatServer s  = new ChatServer();
		s.launch();
		
	}
}
