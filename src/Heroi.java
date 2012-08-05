import java.awt.Color;
import java.awt.Graphics2D;

public class Heroi extends Personagem {

	public float jumpSpeed = 2.0f;
	public float maxSpeed = 2.0f;
	public int pontos = 0;
	private byte ultimaMoeda;
	private byte framesMoeda = 5;

	public Heroi(short _posX, short _posY, short _sizeX, short _sizeY,
			short _vel) {
		super(_posX, _posY, _sizeX, _sizeY, _vel);

	}

	@Override
	public void DesenhaSe(Graphics2D dbg) {
		dbg.setColor(Color.YELLOW);
		dbg.fillRect((int) pos.x, (int) pos.y, (int) size.x, (int) size.y);
		if (framesMoeda > 0) {
			dbg.setColor(Color.green);
			dbg.drawString(ultimaMoeda+"", pos.x+5, pos.y-20);
			framesMoeda--;
		}
	}

	@Override
	public void SimulaSe(long DiffTime) {
		oldPos.x = pos.x;
		oldPos.y = pos.y;
		if (CanvasGame.instance.DOWN) {
			acceleration.y += vel * DiffTime / 1000.0f;
		}
		if (CanvasGame.instance.UP && colidindo) {
			acceleration.y = -jumpSpeed;
		} else {
			acceleration.y += GerenciadorDeJogo.instancia.gravidade * DiffTime
					/ 1000.0f;
		}
		if (CanvasGame.instance.LEFT) {
			acceleration.x = -(vel * DiffTime / 1000.0f);
		}
		if (CanvasGame.instance.RIGHT) {
			acceleration.x = vel * DiffTime / 1000.0f;
		}
		if (acceleration.x > maxSpeed) {
			acceleration.x = maxSpeed;
		}
		if (acceleration.y > maxSpeed) {
			acceleration.y = maxSpeed;
		}
		if (acceleration.x < -maxSpeed) {
			acceleration.x = -maxSpeed;
		}
		if (acceleration.y < -maxSpeed) {
			acceleration.y = -maxSpeed;
		}
		pos.add(acceleration);
		colidindo = false;
		for (int i = 0; i < GerenciadorDeJogo.instancia.obstaculos.size(); i++) {
			Obstaculo colisor = GerenciadorDeJogo.instancia.obstaculos.get(i);
			if (Constantes.colideRetangulo(this, colisor)) {
				Colide();
			}
		}
		if (Constantes.colideTela(this, GamePanel.PWIDTH, GamePanel.PHEIGHT)) {
			Colide();
		}
		
		for (int i = 0; i < GerenciadorDeJogo.instancia.moedas.size(); i++) {
			Moeda colisor = GerenciadorDeJogo.instancia.moedas.get(i);
			if (Constantes.colideRetangulo(this, colisor)) {
				ultimaMoeda = colisor.valor;
				framesMoeda = (byte)(4000 * DiffTime);
				pontos += colisor.valor;
				GerenciadorDeJogo.instancia.moedas.remove(colisor);
			}
		}
	}

	@Override
	public void DesenhaSe(Graphics2D dbg, int XMundo, int YMundo) {
		// TODO Auto-generated method stub

	}

	private void Colide() {
		pos.x = oldPos.x;
		pos.y = oldPos.y;
		acceleration = new Vector2D(0, 0);
		colidindo = true;
	}

}
