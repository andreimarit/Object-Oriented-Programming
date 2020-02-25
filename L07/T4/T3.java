package classes;
import interfaces.MyInterfaces;

public class T3 extends SuperT3 implements MyInterfaces{

	public static void main(String[] args) {
		
		T3 a = new T3();
		method1(a);
		method2(a);
		method3(a);
		method4(a);
	}
	
	public void method() {
		System.out.println("My interface");
	}

	public static void method1(I1 i)
    {
    	System.out.println("interface 1");
    }
    public static void method2(I2 i)
    {
    	System.out.println("interface 2");
    }
    public static void method3(I3 i)
    {
    	System.out.println("interface 3");
    }
    public static void method4(MyInterfaces i)
    {
    	System.out.println("main interface");
    }
	
}
