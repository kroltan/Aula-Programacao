import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.image.*;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable {

	public final static int PWIDTH = 800;
	public final static int PHEIGHT = 600;
	private Thread animator;
	public static boolean running = false;
	private BufferedImage dbImage;
	private Graphics2D dbg;
	public static boolean startGame = false;
	public static boolean restartGame = false;
	public static boolean pauseGame = false;
	public static boolean GameOver = false;
	public static GamePanel instancia;
	public int SFPS, FPS;
	public int framesSinceStartup;
	GCanvas CanvasAtivo;

	@SuppressWarnings("static-access")
	public GamePanel() {

		// TODO CRIAR METODO PRA CARREGAR TODAS AS IMAGENS DO JOGO
		// TODO CRIAR CRIAR LISTAS DO JOGO AKI...
		// TODO CRIAR PERSONNAHEM AKI...

		instancia = this;
		CanvasAtivo = new CanvasGame();
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(this.PWIDTH, this.PHEIGHT));

		// create game components
		setFocusable(true);
		requestFocus(); // JPanel now receives key events

		if (dbImage == null) {
			dbImage = new BufferedImage(PWIDTH, PHEIGHT,
					BufferedImage.TYPE_INT_ARGB);
			if (dbImage == null) {
				System.out.println("dbImage is null");
				return;
			} else {
				dbg = (Graphics2D) dbImage.getGraphics();
			}
		}

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (CanvasAtivo != null) {
					CanvasAtivo.keyPressed(e);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (CanvasAtivo != null) {
					CanvasAtivo.keyReleased(e);
				}
			}
		});

		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

				if (CanvasAtivo != null) {
					CanvasAtivo.mouseMoved(e);
				}

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				if (CanvasAtivo != null) {
					CanvasAtivo.mouseDragged(e);
				}
			}
		});

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (CanvasAtivo != null) {
					CanvasAtivo.mouseReleased(e);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (CanvasAtivo != null) {
					CanvasAtivo.mousePressed(e);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				if (CanvasAtivo != null) {
					CanvasAtivo.mouseExited(e);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				if (CanvasAtivo != null) {
					CanvasAtivo.mouseEntered(e);
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (CanvasAtivo != null) {
					CanvasAtivo.mouseClicked(e);
				}
			}
		});

	} // end of GamePanel()

	public void addNotify() {
		super.addNotify(); // creates the peer

		startGame(); // start the thread
	}

	private void startGame()
	// initialise and start the thread
	{

		if (animator == null || !running) {
			animator = new Thread(this);
			animator.start();

		}
	} // end of startGame()

	public void stopGame()
	// called by the user to stop execution
	{
		running = false;
	}

	public void run()
	/* Repeatedly update, render, sleep */
	{
		running = true;
		long DifTime, TempoAnterior;

		int segundo = 0;
		DifTime = 0;
		TempoAnterior = System.currentTimeMillis();

		while (running) {

			gameUpdate(DifTime); // game state is updated
			gameRender(); // render to a buffer
			paintImmediately(0, 0, PWIDTH, PHEIGHT); // paint with the buffer

			try {
				Thread.sleep(0); // sleep bit
			} catch (InterruptedException ex) {
			}

			DifTime = System.currentTimeMillis() - TempoAnterior;
			TempoAnterior = System.currentTimeMillis();

			if (segundo != ((int) (TempoAnterior / 1000))) {
				FPS = SFPS;
				SFPS = 1;
				segundo = ((int) (TempoAnterior / 1000));
			} else {
				SFPS++;
			}

		}
		System.exit(0); // so enclosing JFrame/JApplet exits
	} // end of run()

	int timerfps = 0;

	private void gameUpdate(long DiffTime) {

		if (CanvasAtivo != null) {
			CanvasAtivo.SimulaSe(DiffTime);
		}
	}

	private void gameRender()
	// draw the current frame to an image buffer
	{

		if (CanvasAtivo != null) {
			CanvasAtivo.DesenhaSe(dbg);
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (dbImage != null) {
			g.drawImage(dbImage, 0, 0, null);
		}
	}

	public static void main(String args[]) {
		GamePanel ttPanel = new GamePanel();

		// create a JFrame to hold the timer test JPanel
		JFrame app = new JFrame("Leonardo");
		app.getContentPane().add(ttPanel, BorderLayout.CENTER);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		app.pack();
		app.setResizable(false);
		app.setVisible(true);
	} // end of main()

} // end of GamePanel class

