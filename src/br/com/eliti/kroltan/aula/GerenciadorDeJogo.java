package br.com.eliti.kroltan.aula;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;


public class GerenciadorDeJogo {

	public static GerenciadorDeJogo instancia;
	public double scoreJogador;
	public int mouseX, mouseY;
	public short gravidade = 4;

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
		
	}

	public void desenhaSe(Graphics2D dbg, int sizeX, int sizeY) {
		
	}

	public void simulaSe(long diffTime, int Xmouse, int Ymouse, boolean cliqueMouse) {
		
	}
	
}
