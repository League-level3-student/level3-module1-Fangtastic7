package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
  /* 
	 * Create a HashMap of Integers for the keys and Strings for the values.
	 * 
	 
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	
	HashMap<Integer, String> map = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton AddEntry = new JButton("Add Entry");
	JButton SearchID = new JButton("Search by ID");
	JButton ViewList = new JButton("View List");
	JButton RemoveEntry = new JButton("Remove Entry");
	
	
	public static void main(String[] args) {
		new _02_LogSearch().createUI();
	}


	private void createUI() {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		frame.add(panel);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		panel.add(AddEntry);
		panel.add(SearchID);
		panel.add(ViewList);
		panel.add(RemoveEntry);
		AddEntry.addActionListener(this);
		SearchID.addActionListener(this);
		ViewList.addActionListener(this);
		RemoveEntry.addActionListener(this);
		frame.pack();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonpressed = (JButton) e.getSource();
		
		if(buttonpressed==AddEntry) {
			boolean test = true; 
			String number = null;
			String name = null;
			while(test) {
			 number = JOptionPane.showInputDialog("Please enter an ID number.");
			 name = JOptionPane.showInputDialog("Please enter a name.");
			 if(number.equals("")) {
				 JOptionPane.showMessageDialog(null, "You put nothing in for the ID number!");
			 }
			 else if(number.equals("")) {
				 JOptionPane.showMessageDialog(null, "You put nothing in for the name!");
			 }
			 else if( !number.chars().allMatch( Character::isDigit )) {
				JOptionPane.showMessageDialog(null, "You cannot put anything else beside numbers for the id number!");
			 }
			 else {
				 test = false;
			 }
			}
			
			int idnumber = Integer.parseInt(number);
			map.put(idnumber, name);
		}
		else if(buttonpressed==SearchID) {
			String input = JOptionPane.showInputDialog("Enter the ID number that you want to find.");
			int idnumber = Integer.parseInt(input);
			if(map.containsKey(idnumber)) {
				JOptionPane.showMessageDialog(null, "ID: " + idnumber + " Name: " + map.get(idnumber));
				//map.get(idnumber);
			}
			else {
				JOptionPane.showMessageDialog(null, "Sorry, this entry does not exist in our list.");
			}
		}
		else if(buttonpressed==ViewList) {
			String list = "";
			for( Integer i : map.keySet()) {
				list = list + "ID: " + i + " Name: " + map.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, list);
		}
		else {
			String number = JOptionPane.showInputDialog("Enter the ID number that you want to delete.");
			int idnumber = Integer.parseInt(number);
			if(map.containsKey(idnumber)) {
				JOptionPane.showMessageDialog(null, ("ID: " + idnumber + " - has been removed."));
				map.remove(idnumber);
			}
			else {
				JOptionPane.showMessageDialog(null, "Sorry, this entry does not exist in our list.");
			}
		}
	}
}
