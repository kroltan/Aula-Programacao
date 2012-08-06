import java.awt.Color;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

public class GerenciadorDeJogo {

	public static GerenciadorDeJogo instancia;
	public double scoreJogador;
	public int mouseX, mouseY;
	public short gravidade = 4;
	Heroi heroi;
	public ArrayList<Obstaculo> obstaculos = new ArrayList<Obstaculo>();
	public ArrayList<Moeda> moedas = new ArrayList<Moeda>();
	Random r = new Random();

	public GerenciadorDeJogo() {
		instancia = this;
		InstanciaObjetos();
	}
	
	/**
	 * Reinicia o gerenciador de jogo.
	 * @return Instância do Gerenciador 
	 */
	public static GerenciadorDeJogo Reinicia() {
		instancia = new GerenciadorDeJogo();
		return instancia;
	}

	/**
	 * Coloque aqui a inicialização dos elementos de jogo básicos, ou a geração do mapa <br />
	 * Sempre coloque personagens após objetos
	 */
	private void InstanciaObjetos() {
		MapLoader.Load("C:/level.txt");
		if (heroi == null) {
			heroi = new Heroi((short) 20, (short) 20, (short) 20, (short) 20, (short) 100);
		}
//		for (int i = 0; i < 15; i++) {
//			obstaculos.add(new Obstaculo((short) r.nextInt(GamePanel.PWIDTH), (short) r.nextInt(GamePanel.PWIDTH), (short) 50, (short) 50));
//		}
//		for (int i = 0; i < 50; i++) {
//			moedas.add(new Moeda((short) r.nextInt(GamePanel.PWIDTH), (short) r.nextInt(GamePanel.PWIDTH), (short) 5, (short) 5, (byte) r.nextInt(10)));
//		}
//		heroi = new Heroi((short) 20, (short) 20, (short) 20, (short) 20, (short) 100);
	}

	public void desenhaSe(Graphics2D dbg, int sizeX, int sizeY) {
		dbg.setColor(new Color(0.0f, 0.0f, 0.0f, 0.25f));
		dbg.fillRect(0, 0, sizeX, sizeY);
		dbg.setColor(new Color(1.0f, 1.0f, 1.0f, 0.25f));
		for (int i = 0; i < 20; i++) {
			dbg.drawArc(r.nextInt(GamePanel.PWIDTH), r.nextInt(GamePanel.PHEIGHT), r.nextInt(GamePanel.PWIDTH), r.nextInt(GamePanel.PHEIGHT), r.nextInt(10), r.nextInt(10));
		}
		for (int i = 0; i < moedas.size(); i++) {
			moedas.get(i).DesenhaSe(dbg, 0, 0);
		}
		for (int i = 0; i < obstaculos.size(); i++) {
			obstaculos.get(i).DesenhaSe(dbg, 0, 0);
		}
		heroi.DesenhaSe(dbg);
		dbg.setColor(Color.yellow);
		dbg.drawString("Aceleração: " + heroi.acceleration, 10, 10);
		dbg.drawString("Colide: " + heroi.colidindo, 10, 20);
		dbg.drawString("FPS: " + GamePanel.instancia.FPS, 200, 10);
		dbg.setColor(Color.white);
		dbg.drawString("Aperte R para reiniciar", 10, 40);
		dbg.drawString("Pontos: " + heroi.pontos, 10, 50);
	}

	public void simulaSe(long diffTime, int Xmouse, int Ymouse,
			boolean cliqueMouse) {
		heroi.SimulaSe(diffTime);
	}

}
