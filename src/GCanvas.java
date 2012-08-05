
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class GCanvas {

	/**
	 * 
	 * @param dbg
	 */
	public abstract void DesenhaSe(Graphics2D dbg);

	/**
	 * 
	 * @param dbg
	 * @param arg0
	 *            - Normalmente o Width
	 * @param arg1
	 *            - Normalmente o Heigh
	 */
	public abstract void DesenhaSe(Graphics2D dbg, int arg0, int arg1);

	/**
	 * 
	 * @param diftime
	 */
	public abstract void SimulaSe(long diftime);

	/**
	 * 
	 * @param e
	 */
	public abstract void keyPressed(KeyEvent e);

	/**
	 * 
	 * @param e
	 * @param canvas
	 */
	public abstract void keyReleased(KeyEvent e, GCanvas canvas);

	/**
	 * 
	 * @param e
	 * @param canvas
	 */
	public abstract void keyPressed(KeyEvent e, GCanvas canvas);

	/**
	 * 
	 * @param e
	 */
	public abstract void keyReleased(KeyEvent e);

	/**
	 * 
	 * @param e
	 */
	public abstract void mouseMoved(MouseEvent e);

	/**
	 * 
	 * @param e
	 */
	public abstract void mouseDragged(MouseEvent e);

	/**
	 * 
	 * @param e
	 */
	public abstract void mouseReleased(MouseEvent e);

	/**
	 * 
	 * @param e
	 */
	public abstract void mousePressed(MouseEvent e);

	/**
	 * 
	 * @param e
	 */
	public abstract void mouseExited(MouseEvent e);

	/**
	 * 
	 * @param e
	 */
	public abstract void mouseEntered(MouseEvent e);

	/**
	 * 
	 * @param e
	 */
	public abstract void mouseClicked(MouseEvent e);

}
