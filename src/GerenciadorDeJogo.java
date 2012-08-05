import java.awt.Color;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

public class GerenciadorDeJogo {

	public static GerenciadorDeJogo instancia;
	public double scoreJogador;
	public int mouseX, mouseY;
	public short gravidade = 10;
	Heroi heroi;
	public ArrayList<Obstaculo> obstaculos = new ArrayList<Obstaculo>();
	Random r = new Random();
	
	public GerenciadorDeJogo() {
		instancia = this;
		InstanciaObjetos();
	}

	/**
	 * colocar os personagens sempre depois do mapa e objetos
	 */
	private void InstanciaObjetos() {
		heroi = new Heroi((short)20, (short)20, (short)20, (short)20, (short) 100);
		for (int i = 0; i < 15; i++) {
			obstaculos.add(new Obstaculo((short)r.nextInt(GamePanel.PWIDTH), (short)r.nextInt(GamePanel.PWIDTH), (short)50, (short)50));
		}
	}

	public void desenhaSe(Graphics2D dbg, int sizeX, int sizeY) {
		dbg.setColor(new Color(0.0f, 0.0f, 0.0f, 0.1f));
		dbg.fillRect(0, 0, sizeX, sizeY);
		for (int i = 0; i < obstaculos.size(); i++) {
			obstaculos.get(i).DesenhaSe(dbg, 0, 0);
		}
		heroi.DesenhaSe(dbg);
	}

	public void simulaSe(long diffTime, int Xmouse, int Ymouse,
			boolean cliqueMouse) {
		heroi.SimulaSe(diffTime);
	}

}
