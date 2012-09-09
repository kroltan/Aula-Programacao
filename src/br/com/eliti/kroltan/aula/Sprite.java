package br.com.eliti.kroltan.aula;


import java.awt.Graphics2D;
import java.awt.Point;

public abstract class Sprite {

	public Point pos;
	public Point size;

	public Sprite(short _posX, short _posY, short _sizeX, short _sizeY) {
		this.pos = new Point(_posX, _posY);
		this.size = new Point(_sizeX, _sizeY);
	}
	public Sprite(Point _pos, Point _size) {
		this.pos = _pos;
		this.size = _size;
	}

	public abstract void SimulaSe(long DiffTime);

	public abstract void DesenhaSe(Graphics2D dbg, int XMundo, int YMundo);

	
}
