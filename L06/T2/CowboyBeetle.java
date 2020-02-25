
public class CowboyBeetle extends Beetle{
	private int n = printInit("CowboyBeetle.n initialized");
	 public CowboyBeetle()
	 {
	 System.out.println("n = " + n);
	 System.out.println("j = " + j);
	 }
	 private static int x5 =
	 printInit("static CowboyBeetle.x5 initialized");
	 
	 public static void main(String[] args)
	 {
	 System.out.println("CowboyBeetle constructor");
	 CowboyBeetle d = new CowboyBeetle();
	 }
}
