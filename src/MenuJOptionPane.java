import javax.swing.*;

public class MenuJOptionPane
{
	public static void main(String[] args)
	{
		int choice = mainMenu();//initialise choice
		int quit = 0;
		
		while(choice != 4)
		{
		  switch(choice)
			{
			  case 1:
					createAccount();
					break;
			  case 2:
			  		deposit();
					break;
			  case 3:
			  		withdraw();
					break;
					
			  case -99:
					JOptionPane.showMessageDialog(null,"You must enter something, 4 to exit", 
													"ERROR", JOptionPane.ERROR_MESSAGE);
					break;
			  case -100:
					JOptionPane.showMessageDialog(null,"You have selected cancel");
					break;			
			  default:
					JOptionPane.showMessageDialog(null,"Not a valid option, select again");  
											
			}//end of switch
									
			choice = mainMenu();//change value in choice
						
		}//end of while

		System.exit(0);	//close down JOptionPane
		
	}//end of main = exit point for application 
	

	public static int mainMenu()
	{
		String menu = "1. Create Account\n2. Deposit\n3. Withdraw\n4. Exit";
		String userSelection = JOptionPane.showInputDialog(null, menu, "HOLMESGLEN BANK", JOptionPane.PLAIN_MESSAGE);
		int option = validateSelection(userSelection); 
		//validate and converts to integer
	
		return option;
	}
	
	public static int validateSelection(String selection)
	{
		//entered cancel
		if(selection == null)
			return -100;
		//hit enter without entry = zero-length string
		if(selection.length() < 1)
			return - 99;
		//entered more than one character
		if(selection.length() > 1)
			return -101;
		//entered less than 1 or greater than 4
		if((int)selection.charAt(0) < 49 ||(int)selection.charAt(0) > 52)
			return -101;
		else
			return Integer.parseInt(selection);	 
	}
	
	public static void createAccount()
	{
		JOptionPane.showMessageDialog(null, 
						"Create Account option - Under Construction...",
							"HOLMESGLEN BANK", JOptionPane.WARNING_MESSAGE);
	}
	
	public static void deposit()
	{
		JOptionPane.showMessageDialog(null, "Under Construction...");
	}
	
	public static void withdraw()
	{
		JOptionPane.showMessageDialog(null, "Under Construction...");
	}
	
}