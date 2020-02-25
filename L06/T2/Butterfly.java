
public class Butterfly extends Insect {

	private int l = printInit("Butterfly.l initialized");
	 {
	 System.out.println("l = " + l);
	 System.out.println("j = " + j);
	 }
	 private static int x3 =
	 printInit("static Beetle.x3 initialized");
	 public static void main(String[] args)
	 {
	 System.out.println("Butterfly constructor");
	 Butterfly but = new Butterfly();
	 }
}
