import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CurrencyController {
	
	private CurrencyView view;
	CurrencyModel[] currArray;
	
	CurrencyController(CurrencyView v){
		this.view = v;
		
		currArray = new CurrencyModel[3]; 
		currArray[0] = new CurrencyModel("RON - Leul Romanesc", 0.2152f);
		currArray[1] = new CurrencyModel("EUR - Euro", 1f);
		currArray[2] = new CurrencyModel("USD - Dolarul SUA", 0.8758f);	
		
		view.addConvertListener(new ConvertListener());
		
	}
	
	public CurrencyModel find(String money) {
		for(int i = 0; i < 3; i++) {
			if(currArray[i].getName().equals(money)) {
				return currArray[i];
			}
		}
		return null;
	}
	
	public int findTitle(String from, String to) {
		CurrencyModel m = find(from);
		CurrencyModel n = find(to);
		int nb = 0;
		for(int i = 0; i < 3; i++) {
			if(currArray[i].getName().equals(m.getName())) {
				nb = 3 * i;
				break;
			}
		}
		for(int i = 0; i < 3; i++){
			if(currArray[i].getName().equals(n.getName())) {
				nb += i;
				break;
			}
		}
		return nb;
	}
	
	class ConvertListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String userInput = "";
			try {
				userInput = view.getT_suma().getText();
				int value = Integer.parseInt(userInput);
				String from = view.getL_from().getText();
				String to = view.getL_to().getText();
				float result = find(from).convert(value, find(to));
				view.setT_rez(String.valueOf(result));
				view.setl_moneyFrom(from);
				view.setl_moneyTo(to);
				view.setl_currencyLabel(findTitle(from, to));
			} 
			catch (NumberFormatException nfex) {
                view.showError("Bad input: '" + userInput + "'");
            }
		}
		
	}
	

	

}
