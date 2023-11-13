package entity.mobile;


import javax.swing.*;
import java.awt.*;


public class Deplacement extends JPanel implements Runnable {
	final int originalTilesSize = 16; // résoulition de l'image 16x16
	final int scale = 3;
	public final int tileSize = originalTilesSize * scale; // 48x48 tiles
	final int maxScreencol = 17;
	final int maxScrenRow = 13;
	final int screenWidth = tileSize * maxScreencol; // le nombre de pixel largeur 768 p
	final int screenHeight = tileSize * maxScrenRow; // le nombre de pixel hauteur 576 pixel
	Direction keyH = new Direction();
	Thread gameThread;
	// FPS
	double FPS = 60.0;
	Player player = new Player(this,keyH);

	// les positions du joueurs
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;

	public Deplacement() {

		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		this.addKeyListener(keyH);

	}
	public void 	startGameThread(){
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		long drawCount = 0;
		while (gameThread != null){

			currentTime  = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			timer += (currentTime - lastTime);
			if(delta >= 1) {
				update();
				repaint();
				delta --;
				drawCount ++;
			}
			if (timer >= 1000000000){
				System.out.println("FPS:" + drawCount);
				drawCount = 0;
				timer = 0;
			}


		}

	}
	public void update(){
		if (keyH.upPressed == true){
			playerY -= playerSpeed;
		}
		else if(keyH.downPressed == true){
			playerY += playerSpeed;
		}
		else if(keyH.leftPressed == true){
			playerX -= playerSpeed;
		}
		else if(keyH.rightPressed == true){
			playerX += playerSpeed;
		}
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.dispose();
		player.draw(g2);
	}
}