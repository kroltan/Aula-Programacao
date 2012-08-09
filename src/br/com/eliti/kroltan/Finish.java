package br.com.eliti.kroltan;

import java.awt.Color;
import java.awt.Graphics2D;

public class Finish extends Sprite {

	public Finish(Vector2D _pos, Vector2D _size, String next) {
		super(_pos, _size);
		GerenciadorDeJogo.nextLevel = next;
	}
	
	public Finish(short _posX, short _posY, short _sizeX, short _sizeY, String next) {
		super(_posX, _posY, _sizeX, _sizeY);
		GerenciadorDeJogo.nextLevel = next;
		System.out.println(next);
	}

	@Override
	public void SimulaSe(long DiffTime) {
		Colisao c = Colisao.colideRetangulo(GerenciadorDeJogo.instancia.heroi, this);
		if (c.cima || c.baixo || c.esquerda || c.direita) {
			CanvasGame.instance.gerenciadorDeJogo = GerenciadorDeJogo.Reinicia();
		}
	}

	@Override
	public void DesenhaSe(Graphics2D dbg, int XMundo, int YMundo) {
		dbg.setColor(Color.red);
		dbg.fillRect((int)pos.x, (int)pos.y, (int)size.x, (int)size.y);
	}

}
