package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	JFrame frame = new JFrame("Hangman");
	JPanel panel = new JPanel();
	int lives = 10;
	JLabel showlives = new JLabel("Lives Remaining: " + lives);
	JLabel blank = new JLabel();
	int length2;
	int input;
	int wordlength;
	int wordsamount = 0;
	String word;
	//char[] ch;
	char[] underscroll;
	public static void main(String[] args) {
		new HangMan().createUI();
		}
	private void createUI() {
		// TODO Auto-generated method stub
		String length = JOptionPane.showInputDialog("WELCOME TO HANGMAN!\nHow many words would you like to guess?");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		input =0;
		frame.setVisible(false);
		frame.add(panel);
		panel.add(blank);
		panel.add(showlives);
		length2 = Integer.parseInt(length);
		while(input==0) {
		if(length2>0&&length2<267) {
			input=1;
			frame.setVisible(true);
			frame.addKeyListener(this);
			execute();
			frame.pack();
			
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Please enter a number larger than 0 and smaller than 267");
		}
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyChar();
		int success = 0;
		for(int i=0;i<word.length(); i++) {
			if(keyCode==word.charAt(i)) {
			//	underscroll.replace(underscroll.indexOf( i), keyCode);
				underscroll[i] = word.charAt(i);
				//underscroll.valueOf(i);
				//underscroll[i] = word.charAt(i);
				
				System.out.println(new String(underscroll));
				blank.setText(new String(underscroll));
				 success=1;
				 if(new String(underscroll).equals(word)) {
						length2 = length2 -1;
						if(length2 ==0) {
							JOptionPane.showMessageDialog(null, "You win!");
							restart();
						}
						else {
							 execute();
						}
				 }
				 
			}
			
			
			
		}
		if(success==0) {
			lives = lives -1; 
			showlives.setText("Lives Remaining: " + lives);
			if(lives==0) {
				JOptionPane.showMessageDialog(null, "You ran out of lives! The word was: " + word);
				//int dialog = JOptionPane.YES_NO_CANCEL_OPTION;
				//dialog = JOptionPane.showConfirmDialog(null, "Would you like to play again?");
				createUI();
			}
					}
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	void restart() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Want to play again?", "Confirm?", dialogButton);
		if(dialogResult == 0) {
		  System.out.println("Yes option");
		 createUI();
		  
		} else {
		  System.out.println("No Option");
		  System.exit(0);
		} 
	}
	void execute () {

		wordlength = Utilities.getTotalWordsInFile("dictionary.txt");
		word = Utilities.readRandomLineFromFile("dictionary.txt");
		underscroll = new char[word.length()];
		for(int i=0;i< word.length(); i++) {
			underscroll[i] = '_';
		}
		System.out.println(new String(underscroll));
		System.out.println(word);
		//word = testSting.
		for(int i=0; i<word.length(); i++) {
	//	underscroll = underscroll + "_";
		blank.setText(new String(underscroll));
		}
	}
	
	
}
