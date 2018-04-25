package com.dauflo.www;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	public static final int width = 500, height = 500;
	
	public static void main(String[] args) {
		int[][] gestion = new int[100][100];
		for (int i = 0; i < gestion.length; i++) {
			for (int j = 0; j < gestion.length; j++) {
				gestion[i][j] = 1;
			}
		}
		
		JFrame myFrame = new JFrame("Langton's Ant");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(width, height);
		myFrame.setResizable(false);
		
		Container myPanel = myFrame.getContentPane();
		myPanel.setPreferredSize(new Dimension(width, height));
		
		DisplayPanel display = new DisplayPanel(gestion, gestion.length / 2, gestion.length / 2);
		myPanel.add(display);
		
		myFrame.setContentPane(myPanel);
		
		myFrame.pack();
		myFrame.show();
	}
}
