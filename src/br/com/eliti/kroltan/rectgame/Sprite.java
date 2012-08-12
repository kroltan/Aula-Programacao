package br.com.eliti.kroltan.rectgame;


import java.awt.Graphics2D;

public abstract class Sprite {

	public Vector2D pos;
	public Vector2D size;

	public Sprite(short _posX, short _posY, short _sizeX, short _sizeY) {
		this.pos = new Vector2D(_posX, _posY);
		this.size = new Vector2D(_sizeX, _sizeY);
	}
	public Sprite(Vector2D _pos, Vector2D _size) {
		this.pos = _pos;
		this.size = _size;
	}

	public abstract void SimulaSe(long DiffTime);

	public abstract void DesenhaSe(Graphics2D dbg, int XMundo, int YMundo);

	
}
