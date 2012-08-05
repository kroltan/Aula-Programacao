

import java.awt.Graphics2D;

public abstract class Sprite {

	public short posX;
	public short posY;
	public short sizeX;
	public short sizeY;

	public Sprite(short _posX, short _posY, short _sizeX, short _sizeY) {
		this.posX = _posX;
		this.posY = _posY;
		this.sizeX = _sizeX;
		this.sizeY = _sizeY;
	}

		public abstract void SimulaSe(long DiffTime);

		public abstract void DesenhaSe(Graphics2D dbg, int XMundo, int YMundo);

	
}
