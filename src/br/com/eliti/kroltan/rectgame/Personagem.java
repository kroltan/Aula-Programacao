package br.com.eliti.kroltan.rectgame;
import java.awt.Graphics2D;


public abstract class Personagem extends Sprite {

	public short vel;
	public Vector2D oldPos;
	public Vector2D acceleration;
	public boolean vivo;
	public boolean LEFT;
	public boolean RIGHT;
	public boolean UP;
	public boolean DOWN;
	public Colisao colidindo;

	public Personagem(short _posX, short _posY, short _sizeX, short _sizeY,
			short _vel) {
		super(_posX, _posY, _sizeX, _sizeY);
		vel = _vel;
		oldPos = new Vector2D(_posX,_posY);
		acceleration = new Vector2D(0, 0);
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
