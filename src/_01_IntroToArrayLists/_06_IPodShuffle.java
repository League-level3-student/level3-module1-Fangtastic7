package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("Suprise Me!");
	ArrayList<Song> songs = new ArrayList<Song>();
	boolean isplaying = false;
	Random randomindex = new Random();
	int repeat =0;
	Song rock = new Song("americanidiot.mp3");
	Song electric = new Song("nitrofun.mp3");
	Song USSR = new Song("USSR.mp3");
	
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
				frame.setVisible(true);
				frame.add(panel);
				panel.add(button);
				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
				songs.add(electric);
				songs.add(rock);
				songs.add(USSR);
				button.addActionListener(this);
				frame.pack();
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(isplaying==false) {
		int number = randomindex.nextInt(3);
		while(number == repeat) {
		number = randomindex.nextInt(3);
		}
		songs.get(number).play();
		repeat = number;
		System.out.println("Plays");
		isplaying=true;
		}
		else {
			isplaying =false; 
			songs.get(repeat).stop();
			System.out.println("stop");
		}
		
	}
}