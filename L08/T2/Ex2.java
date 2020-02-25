
public class Ex2 {
	
	String myOrder;
	
	public Ex2()
	{
		this.myOrder = "Today's menu";
	}
	
	public void bringOrder(String order) throws WrongOrderException {
		
		System.out.println("Here is your " + order);
		if(!order.equals(this.myOrder)) {
			throw new WrongOrderException("This is not what I ordered");
		}
		
	}

	public static void main(String[] args) {
		
		Ex2 newClient = new Ex2();
		
		try {
			newClient.bringOrder("Ananas pizza");
		}
		catch(WrongOrderException e){
			e.printMsg();
		}
	}

}
