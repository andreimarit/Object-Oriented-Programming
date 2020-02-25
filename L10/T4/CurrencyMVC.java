
public class CurrencyMVC {
	
	 public static void main(String[] args) {

	        CurrencyView       view       = new CurrencyView();
	        CurrencyController controller = new CurrencyController(view);

	        view.setVisible(true);
	    }

}
