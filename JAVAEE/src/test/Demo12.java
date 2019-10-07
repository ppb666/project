package test;
//局部内部类
public class Demo12 {

	public static void main(String[] args) {
		aa a = f1();
		a.kill();
		
		//匿名内部类
		aa a2 = f2("你爷爷在此");
		a2.kill();
		System.out.println(a2);
		
	}

	
     //匿名内部类
	private static aa f2(String name) {
		aa a2 = new aa() {
			@Override
			public void kill() {
				System.out.println("你的"+name+"哈哈");
			}
		};
		return a2;
	}



	private static aa f1() {
		class A1 implements aa{

			@Override
			public void kill() {
				System.out.println("0000");
				
			}
			
		}
		A1 a1 = new A1();
		
		
		return a1;
	}
}
