package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton ViewNames = new JButton("View Names");
	JButton AddNames = new JButton("Add Names");
	ArrayList <String> list = new ArrayList <String>();
	public static void main(String[] args) {
		new _02_GuestBook().createUI();
		
	}
	void createUI() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(ViewNames);
		panel.add(AddNames);
		list.add("Bob Banders");
		list.add("Sandy Summers");
		list.add("Greg Ganders");
		list.add("Donny Doners");
		ViewNames.addActionListener(this);
		AddNames.addActionListener(this);
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonpressed = (JButton) e.getSource();
		if(buttonpressed==ViewNames) {
			String entirelist = " ";
			for(int i=0; i < list.size(); i++) {
				entirelist = entirelist + "\n" + "Guest #" + (i+1) + ": " + list.get(i); 
			}
			JOptionPane.showMessageDialog(null, entirelist);
		}
		else if(buttonpressed==AddNames){
			String inputname = JOptionPane.showInputDialog("What is your name?");
			
			list.add(inputname);
			
		}
	}
	
	
	
}
