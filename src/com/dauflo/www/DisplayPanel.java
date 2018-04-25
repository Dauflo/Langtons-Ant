package com.dauflo.www;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class DisplayPanel extends Component implements Runnable {
	private int[][] gestion;

	// Ant
	// Dir : between 1 and 4, 1 pointing up, 2 east...
	private int x, y, dir;

	public DisplayPanel(int[][] gestion, int x, int y) {
		this.gestion = gestion;
		this.x = x;
		this.y = y;
		this.dir = 1;
		new Thread(this).start();
	}

	@Override
	public void paint(Graphics g) {
		for (int i = 0; i < gestion.length; i++) {
			for (int j = 0; j < gestion.length; j++) {
				if (gestion[i][j] == -1) {
					g.setColor(Color.BLACK);
				} else if (gestion[i][j] == 1) {
					g.setColor(Color.WHITE);
				}
				g.fillRect(MainFrame.width / gestion.length * i, MainFrame.height / gestion.length * j,
						MainFrame.width / gestion.length, MainFrame.width / gestion.length);

				// Ant display
				g.setColor(Color.RED);
				g.fillRect(MainFrame.width / gestion.length * x, MainFrame.height / gestion.length * y,
						MainFrame.width / gestion.length, MainFrame.width / gestion.length);
			}
		}
		repaint();
	}

	@Override
	public void run() {
		while(true) {
			try {
				updateAnt();
				repaint();
				Thread.sleep(1);
			} catch (Exception e) {
				break;
			}
		}
	}

	private void updateAnt() {
		gestion[x][y] *= -1;
		switch (dir) {
		case 1:
			y--;
			break;
		case 2:
			x++;
			break;
		case 3:
			y++;
			break;
		case 4:
			x--;
			break;
		}
		
		dir += gestion[x][y];
		
		if (dir == 0) {
			dir = 4;
		} else if (dir == 5) {
			dir = 1;
		}
	}

}
