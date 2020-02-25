
public class MetalMarks extends Butterfly {
	
	private int m = printInit("Metalmarks.m initialized");
	 public MetalMarks()
	 {
	 System.out.println("m = " + m);
	 System.out.println("j = " + j);
	 }
	 private static int x4 =
	 printInit("static Metalmarks.x3 initialized");
	 public static void main(String[] args)
	 {
	 System.out.println("Metalmarks constructor");
	 MetalMarks cost = new MetalMarks();
	 }

}
