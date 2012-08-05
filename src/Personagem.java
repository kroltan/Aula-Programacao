import java.awt.Graphics2D;

public abstract class Personagem extends Sprite {

	public short vel;
	public double angle;
	public short oldX, oldY;
	public boolean Vivo;
	public boolean LEFT;
	public boolean RIGHT;
	public boolean UP;
	public boolean DOWN;
	public boolean LEFTUP;
	public boolean RIGHTUP;
	public boolean LEFTDOWN;
	public boolean RIGHTDOWN;

	public Personagem(short _posX, short _posY, short _sizeX, short _sizeY,
			short _vel) {
		super(_posX, _posY, _sizeX, _sizeY);
		vel = _vel;
	}

	/**
	 * Simula o personagem
	 */
	@Override
	public abstract void SimulaSe(long DiffTime);

	/**
	 * DesenhaSe
	 * 
	 * @param Buffer
	 *            da tela
	 */
	public abstract void DesenhaSe(Graphics2D dbg);

}
