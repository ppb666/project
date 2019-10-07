package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo02 {
	public static void main(String[] args)throws Exception {
		
		
		Class<Student> c = Student.class;
	    Student s = new Student();
	    
	    System.out.println(s);
	    //获取属性变量
	    Field f
	    = c.getDeclaredField("name");
	    f.setAccessible(true); //私有值可以访问
	    f.set(s, "托尼");  //反射赋值
	    System.out.println(s);
	    Object r = f.get(s); //反射取值
	    System.out.println(r);
	    
	    
	    
	   Method setId = c.getMethod("setId", int.class);
	   Method getId = c.getMethod("getId");
	   setId.invoke(s, 22);
	   System.out.println(s);
	   
	   Object v = getId.invoke(s);
	   System.out.println(v);
	  
	    
	    
	    
	    
	}

}
