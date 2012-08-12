package br.com.eliti.kroltan.rectgame;

import java.awt.Color;
import java.awt.Graphics2D;


public class Finish extends Sprite {

	private String next;
	public Finish(Vector2D _pos, Vector2D _size, String _next) {
		super(_pos, _size);
		next = _next;
	}
	
	public Finish(short _posX, short _posY, short _sizeX, short _sizeY, String _next) {
		super(_posX, _posY, _sizeX, _sizeY);
		next = _next;
	}

	@Override
	public void SimulaSe(long DiffTime) {
		if (Colisao.colideRetangulo(GerenciadorDeJogo.instancia.heroi, this)) {
			GerenciadorDeJogo.nextLevel = next;
			CanvasGame.instance.gerenciadorDeJogo = GerenciadorDeJogo.Reinicia();
		}
	}

	@Override
	public void DesenhaSe(Graphics2D dbg, int XMundo, int YMundo) {
		dbg.setColor(Color.red);
		dbg.fillRect((int)pos.x, (int)pos.y, (int)size.x, (int)size.y);
	}

}
