package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<Character> input = new Stack<Character>();
	Stack<Character> deleted = new Stack<Character>();
//	char c;
	String a = "";
	public static void main(String[] args) {
		new _02_TextUndoRedo().createUI();
	}

	private void createUI() {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(keyCode== KeyEvent.VK_BACK_SPACE) {
			if(input.size()>=1) {
			char b = input.pop();
			//label.remove(label.getText().charAt(label.getText().length()-1));
			
			String text = label.getText();
			label.setText(text.substring(0, text.length()-1));
			//System.out.println(b);
			deleted.push(b);
			
			}
		}
		else if(keyCode==KeyEvent.VK_UP) {
			char x = deleted.pop();
			input.push(x);
			String y = Character.toString(x);
			label.setText(label.getText() + y);
		}
		else {
			String word = label.getText() + KeyEvent.getKeyText(keyCode);
        label.setText(word);
        char b = word.charAt(word.length()-1);
        input.push(b);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
