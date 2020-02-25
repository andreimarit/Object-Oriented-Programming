// CalcController.java - Controller
//    Handles user interaction with listeners.
//    Calls View and Model as needed.
// Fred Swartz -- December 2004

import java.awt.event.*;

public class CalcController {
    //... The Controller needs to interact with both the Model and View.
    private CalcModel m_model;
    private CalcView  m_view;
    
    //========================================================== constructor
    /** Constructor */
    CalcController(CalcModel model, CalcView view) {
        m_model = model;
        m_view  = view;
        
        //... Add listeners to the view.
        view.addMultiplyListener(new MultiplyListener());
        view.addClearListener(new ClearListener());
        view.addAddListener(new AddListener());
        view.addSubtractListener(new SubtractListener());
        view.addDivideListener(new DivideListener());
    }
    
    
    ////////////////////////////////////////// inner class MultiplyListener

  
    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput();
                m_model.multiplyBy(userInput);
                m_view.setTotal(m_model.getValue());
                
            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }//end inner class MultiplyListener
    

    class AddListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String userInput = "";
    		try {
    			userInput = m_view.getUserInput();
    			m_model.add(userInput);
    			m_view.setTotal(m_model.getValue());
    		} catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
    	}
    }
    
    class SubtractListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String userInput = "";
    		try {
    			userInput = m_view.getUserInput();
    			m_model.subtract(userInput);
    			m_view.setTotal(m_model.getValue());
    		} catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
    	}
    }
    
    class DivideListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		String userInput = "";
    		try {
    			userInput = m_view.getUserInput();
    			m_model.div(userInput);
    			m_view.setTotal(m_model.getValue());
    		} catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
    	}
    }
    
    
    //////////////////////////////////////////// inner class ClearListener
    /**  1. Reset model.
     *   2. Reset View.
     */    
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.reset();
        }
    }// end inner class ClearListener
}
