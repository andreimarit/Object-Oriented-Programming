public class T3 {

	public static void main(String[] args) {
		
		byte b = Byte.MAX_VALUE;
		int i = Integer.MAX_VALUE;
		short s = Short.MAX_VALUE;
		long l = Long.MAX_VALUE;
		float f = Float.MAX_VALUE;
		double d = Double.MAX_VALUE;
		
		System.out.println("byte max value:" + b);
		System.out.println("integer max value:" + i);
		System.out.println("short max value:" + s);
		System.out.println("long max value:" + l);
		System.out.println("float max value:" + f);
		System.out.println("double max value:" + d);
		
		System.out.println("byte max value + 1:" + ++b);
		System.out.println("integer max value + 1:" + ++i);
		System.out.println("short max value + 1:" + ++s);
		System.out.println("long max value + 1:" + ++l);
		System.out.println("float max value + 1:" + ++f);
		System.out.println("double max value + 1:" + ++d);
		
		b = Byte.MIN_VALUE;
		i = Integer.MIN_VALUE;
		s = Short.MIN_VALUE;
		l = Long.MIN_VALUE;
		f = Float.MIN_VALUE;
		d = Double.MIN_VALUE;
		
		System.out.println("byte min value:" + b);
		System.out.println("integer min value:" + i);
		System.out.println("short min value:" + s);
		System.out.println("long min value:" + l);
		System.out.println("float min value:" + f);
		System.out.println("double min value:" + d);
		
		System.out.println("byte max value - 1:" + --b);
		System.out.println("integer max value - 1:" + --i);
		System.out.println("short max value - 1:" + --s);
		System.out.println("long max value - 1:" + --l);
		System.out.println("float max value - 1:" + --f);
		System.out.println("double max value - 1:" + --d);
		
		b = Byte.MAX_VALUE;
		i = Integer.MAX_VALUE;
		s = Short.MAX_VALUE;
		l = Long.MAX_VALUE;
		f = Float.MAX_VALUE;
		d = Double.MAX_VALUE;
		
		System.out.println("byte max value * 2:" + b*2);
		System.out.println("integer max value * 2:" + i*2);
		System.out.println("short max value * 2:" + s*2);
		System.out.println("long max value * 2:" + l*2);
		System.out.println("float max value * 2:" + f*2);
		System.out.println("double max value * 2:" + d*2);
		
		//d = 1.7976931348623157E3085;   -- the maximum number represented in a variable of type double is 1.7976931348623157E308, so when i
		//                               -- added the 5 at the end i got an error (type double is out of range)
	}

}
