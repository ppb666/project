package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class EchoServer {

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
		
		Socket s ;
		public TongXunThread(Socket s) {
			
		}
		
		@Override
		public void run() {
			/*
			 * 通讯协议  : 流程 ,数据格式
			 * 
			 * UTF-8 编码
			 *  每一条数据末尾有一个换行符
			 *  
			 *  编码转换流    InputStreamReader
			 *   OutPutStreamWriter
			 *   
			 *   BR - ISR  网络输入流
			 *   PW - OSW  网络输出流
			 * 
			 */
			try {
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
			
			String line;
			while ((line=in.readLine())!=null) {
				out.println(line);  //有in 自动补换行
				out.flush();//刷出缓存
			}
			//  null断开
			} catch (Exception e) {
			// 出异常断开
			
			}
			System.out.println("客户端已经断开");
			
			
		}
		
		
	}
	
	

	public static void main(String[] args) {
		EchoServer s = new EchoServer();
		s.launch();
	}
}
