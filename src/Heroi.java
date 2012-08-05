import java.awt.Color;
import java.awt.Graphics2D;

public class Heroi extends Personagem {

	public Heroi(short _posX, short _posY, short _sizeX, short _sizeY,
			short _vel) {
		super(_posX, _posY, _sizeX, _sizeY, _vel);

	}

	@Override
	public void DesenhaSe(Graphics2D dbg) {
		dbg.setColor(Color.YELLOW);
		dbg.fillRect((int) pos.x, (int) pos.y, (int) size.x, (int) size.y);
	}

	@Override
	public void SimulaSe(long DiffTime) {
		for (int i = 0; i < GerenciadorDeJogo.instancia.obstaculos.size(); i++) {
			Sprite colisor = GerenciadorDeJogo.instancia.obstaculos.get(i);
			if (Constantes.colideRetangulo(this, colisor)) {
				colidindo = true;
			} else {
				colidindo = false;
			}
		}
		oldPos.x = pos.x;
		oldPos.y = pos.y;
		if (CanvasGame.instance.DOWN) {
			pos.y += vel * DiffTime / 1000.0f;
		}
		if (CanvasGame.instance.UP && colidindo) {
			pos.y -= (vel * DiffTime / 1000.0f)/2;
		} else {
			pos.y += GerenciadorDeJogo.instancia.gravidade * DiffTime/ 100.0f;
		}
		if (CanvasGame.instance.LEFT) {
			pos.x -= (vel * DiffTime / 1000.0f)/2;
		}
		if (CanvasGame.instance.RIGHT) {
			pos.x += vel * DiffTime / 1000.0f;
		}
		for (int i = 0; i < GerenciadorDeJogo.instancia.obstaculos.size(); i++) {
			Sprite colisor = GerenciadorDeJogo.instancia.obstaculos.get(i);
			if (Constantes.colideRetangulo(this, colisor)) {
				pos.x = oldPos.x;
				pos.y = oldPos.y;
			}
		}
		if (Constantes.colideTela(this, GamePanel.PWIDTH, GamePanel.PHEIGHT)) {
			pos.x = oldPos.x;
			pos.y = oldPos.y;
		}
	}

	@Override
	public void DesenhaSe(Graphics2D dbg, int XMundo, int YMundo) {
		// TODO Auto-generated method stub

	}

}
