package br.com.eliti.kroltan.rectgame;

import java.awt.Color;
import java.awt.Graphics2D;

public class Botao extends Sprite {

	public Color cor;
	public Color corHover;
	public boolean hover = false;
	public String texto;
	
	public Botao(Vector2D pos, Vector2D size, Color _cor, Color _corHover, String _texto) {
		super(pos, size);
		cor = _cor;
		corHover = _corHover;
		texto = _texto;
	}

	@Override
	public void SimulaSe(long DiffTime) {
		
	}

	@Override
	public void DesenhaSe(Graphics2D dbg, int XMundo, int YMundo) {
		if (hover) {
			dbg.setColor(corHover);
		} else {
			dbg.setColor(cor);
		}
		dbg.fillRect((int)pos.x, (int)pos.y, (int)size.x, (int)size.y);
		dbg.setColor(Color.black);
		dbg.drawString(texto, pos.x+2, pos.y+size.y-2);
	}

}
