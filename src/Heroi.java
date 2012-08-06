import java.awt.Color;
import java.awt.Graphics2D;

public class Heroi extends Personagem {

	public float jumpSpeed = 2.9f;
	public float maxSpeed = 2.9f;
	public int pontos = 0;
	private boolean jumped;
	private byte ultimaMoeda;
	private byte framesMoeda = 5;

	public Heroi(short _posX, short _posY, short _sizeX, short _sizeY, short _vel) {
		super(_posX, _posY, _sizeX, _sizeY, _vel);
	}

	@Override
	public void DesenhaSe(Graphics2D dbg) {
		dbg.setColor(Color.orange);
		dbg.fillRect((int) pos.x, (int) pos.y, (int) size.x, (int) size.y);
		if (framesMoeda > 0) {
			dbg.setColor(Color.green);
			dbg.drawString(ultimaMoeda+"", pos.x+5, pos.y-20);
			framesMoeda--;
		}
		//DEBUG DA AREA DE COLISAO
		//dbg.setColor(Color.red);
		//dbg.fillRect((int)pos.x, (int)pos.y, (int)size.x, (int)size.y);
	}
	@Override
	public void DesenhaSe(Graphics2D dbg, int XMundo, int YMundo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SimulaSe(long DiffTime) {
		if (ultimaMoeda > Moeda.gold) {
			maxSpeed += 0.001f;
			jumpSpeed += 0.001f;
		}
		oldPos.x = pos.x;
		oldPos.y = pos.y;
		if (CanvasGame.instance.DOWN) {
			acceleration.y += vel * DiffTime / 1000.0f;
		}
		if (CanvasGame.instance.UP && !jumped) {
			jumped = true;
			acceleration.y = -jumpSpeed;
		} else {
			acceleration.y += GerenciadorDeJogo.instancia.gravidade * DiffTime
					/ 1000.0f;
		}
		if (!CanvasGame.instance.LEFT || !CanvasGame.instance.RIGHT) {
			acceleration.x = 0;
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
		colidindo = new Colisao(false, false, false, false);
		for (int i = 0; i < GerenciadorDeJogo.instancia.obstaculos.size(); i++) {
			Obstaculo colisor = GerenciadorDeJogo.instancia.obstaculos.get(i);
			Colide(Colisao.colideRetangulo(this, colisor));
		}
		Colisao cTela = Colisao.colideTela(this, GamePanel.PWIDTH, GamePanel.PHEIGHT);
		if (cTela.cima || cTela.baixo || cTela.esquerda || cTela.direita) {
			Colide(cTela);
		}
		
		for (int i = 0; i < GerenciadorDeJogo.instancia.moedas.size(); i++) {
			Moeda colisor = GerenciadorDeJogo.instancia.moedas.get(i);
			Colisao cMoeda = Colisao.colideRetangulo(this, colisor);
			if (cMoeda.cima || cMoeda.baixo || cMoeda.esquerda || cMoeda.direita) {
				ultimaMoeda = colisor.valor;
				framesMoeda = (byte)(4000 * DiffTime);
				pontos += colisor.valor;
				GerenciadorDeJogo.instancia.moedas.remove(colisor);
			}
		}
	}
	
	private void Colide(Colisao c) {
		if (c.esquerda || c.direita) {
			pos.x = oldPos.x;
			//acceleration.x = 0;
		}
		if (c.cima || c.baixo) {
			pos.y = oldPos.y;
			acceleration.y = 0;
		}
		if (c.baixo) {
			acceleration.y = 0;
			jumped = false;
		}
		colidindo = c;
	}
}
