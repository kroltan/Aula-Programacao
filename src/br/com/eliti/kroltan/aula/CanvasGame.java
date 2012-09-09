package br.com.eliti.kroltan.aula;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class CanvasGame extends GCanvas {
	public static CanvasGame instance = null;
	public boolean LEFT;
	public boolean RIGHT;
	public boolean UP;
	public boolean DOWN;
	public GerenciadorDeJogo gerenciadorDeJogo;

	private boolean cliqueMouse;
	public static int Xmouse, Ymouse;

	/**
	 * @return the clicou
	 */
	public boolean isClicou() {
		return cliqueMouse;
	}

	/**
	 * @param clicou
	 *            the clicou to set
	 */
	public void setClicou(boolean clicou) {
		this.cliqueMouse = clicou;
	}

	public static GCanvas CanvasAtivo = null;

	public CanvasGame() {
		
		instance = this;
	}

	@Override
	public void DesenhaSe(Graphics2D dbg) {
		
	}

	@Override
	public void SimulaSe(long diffTime) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
			LEFT = true;
		}

		if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
			RIGHT = true;
		}
		if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
			UP = true;
		}
		if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
			DOWN = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
			LEFT = false;
		}

		if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
			RIGHT = false;
		}
		if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
			UP = false;
		}
		if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
			DOWN = false;
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		Xmouse = e.getX();
		Ymouse = e.getY();
		// System.out.println("x "+ Xmouse + "y "+ Ymouse);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("released");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("pressed");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("mouseExit");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("mouseEntered");
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void DesenhaSe(Graphics2D dbg, int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e, GCanvas canvas) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e, GCanvas canvas) {
		// TODO Auto-generated method stub

	}

}
