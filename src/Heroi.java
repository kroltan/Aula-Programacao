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
		dbg.fillRect((int) posX, (int) posY, (int) sizeX, (int) sizeY);
	}

	@Override
	public void SimulaSe(long DiffTime) {

		oldX = posX;
		oldY = posY;
		if (CanvasGame.instance.DOWN) {
			posY += vel * DiffTime / 1000.0f;
		}
		if (CanvasGame.instance.UP) {
			posY -= vel * DiffTime / 1000.0f;
		} else {
			posY += GerenciadorDeJogo.instancia.gravidade * DiffTime/ 100.0f;
		}
		if (CanvasGame.instance.LEFT) {
			posX -= vel * DiffTime / 1000.0f;
		}
		if (CanvasGame.instance.RIGHT) {
			posX += vel * DiffTime / 1000.0f;
		}
		for (int i = 0; i < GerenciadorDeJogo.instancia.obstaculos.size(); i++) {
			Sprite colisor = GerenciadorDeJogo.instancia.obstaculos.get(i);
			if (posX+sizeX >= colisor.posX && posX <= colisor.posX+colisor.sizeX && 
					posY+sizeY >= colisor.posY && posY <= colisor.posY+colisor.sizeY) {
				posX = oldX;
				posY = oldY;
			}
		}
		if (Constantes.colideTela(this, GamePanel.PWIDTH, GamePanel.PHEIGHT)) {
			posX = oldX;
			posY = oldY;
		}
	}

	@Override
	public void DesenhaSe(Graphics2D dbg, int XMundo, int YMundo) {
		// TODO Auto-generated method stub

	}

}
