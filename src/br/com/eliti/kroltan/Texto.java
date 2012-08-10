package br.com.eliti.kroltan;

import java.awt.Color;
import java.awt.Graphics2D;

public class Texto extends Sprite {

	public String content;
	
	public Texto(short _posX, short _posY, String _text) {
		super(_posX, _posY, (short)0, (short)0);
		content = _text;
	}

	@Override
	public void SimulaSe(long DiffTime) {
		
	}

	@Override
	public void DesenhaSe(Graphics2D dbg, int XMundo, int YMundo) {
		dbg.setColor(Color.white);
		dbg.drawString(content, pos.x, pos.y);
	}

}
