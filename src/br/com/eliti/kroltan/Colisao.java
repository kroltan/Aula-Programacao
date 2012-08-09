package br.com.eliti.kroltan;
//import java.awt.Graphics2D;

/**
 * Guarda informações sobre uma colisão retangular
 * @author Kroltan
 */
public class Colisao {
	public boolean cima;
	public boolean baixo;
	public boolean esquerda;
	public boolean direita;
	
	/**
	 * Cria uma nova Colisão
	 * @param _cima Colidindo na parte superior? (-y)
	 * @param _baixo Colidindo na parte inferior? (+y)
	 * @param _esquerda Colidindo na parte lateral esquerda? (-x)
	 * @param _direita Colidindo na parte lateral direita? (+x)
	 */
	public Colisao(boolean _cima, boolean _baixo, boolean _esquerda, boolean _direita) {
		cima = _cima;
		baixo = _baixo;
		esquerda = _esquerda;
		direita = _direita;
	}
	public Colisao() {
		cima = false;
		baixo = false;
		esquerda = false;
		direita = false;
	}
	/**
	 * Verifica se duas Sprites estão se sobrepondo<br />
	 * Analogia: bola bate em um muro
	 * @param colidindo Sprite a retornada informação de colisão (Analogia: bola)
	 * @param colisor Sprite a ser colidida (Analogia: muro)
	 * @return Informações de colisão de <b>colidindo</b>
	 */
	//FIXME colide todos os lados junto.
	public static Colisao colideRetangulo(Sprite colidindo, Sprite colisor) {
		boolean u = false, d = false, l = false, r = false;
		if (colidindo.pos.x+colidindo.size.x >= colisor.pos.x && colidindo.pos.x <= colisor.pos.x+colisor.size.x && colidindo.pos.y+colidindo.size.y >= colisor.pos.y && colidindo.pos.y <= colisor.pos.y+colisor.size.y) {
			if (colidindo.pos.x+colidindo.size.x >= colisor.pos.x) {
				r = true;
			}
			if (colidindo.pos.x <= colisor.pos.x+colisor.size.x) {
				l = true;
			}
			if (colidindo.pos.y+colidindo.size.y >= colisor.pos.y) {
				d = true;
			}
			if (colidindo.pos.y <= colisor.pos.y+colisor.size.y) {
				u = true;
			}
		}
		return new Colisao(u, d, l, r);
	}
	/**
	 * Verifica se algo está fora da tela
	 * @param colidindo Sprite a ser checada
	 * @param sizeTelaX Tamanho horizontal da tela
	 * @param sizeTelaY Tamanho vertical da tela
	 * @return Uma Colisão informando que lados da tela estão sendo tocados pelo <b>colidindo</b>
	 */
	public static Colisao colideTela(Sprite colidindo, int sizeTelaX, int sizeTelaY) {
		boolean u = false, d = false, l = false, r = false;
		
		if (colidindo.pos.x+colidindo.size.x >= sizeTelaX) {
			r = true;
		}
		if (colidindo.pos.x <= 0) {
			l = true;
		}
		if (colidindo.pos.y+colidindo.size.y >= sizeTelaY) {
			d = true;
		}
		if (colidindo.pos.y <= 0) {
			u = true;
		}
		return new Colisao(u, d, l, r);
	}
	/**
	 * Mistura as duas colisões em uma só, permitindo cálculos mais genéricos
	 * @param b A colisão a ser fundida
	 * @return Uma nova colisão, com as informações da colisão original e de <b>b</b>
	 */
	public Colisao Mix(Colisao b) {
		boolean u=false, d=false, l=false, r=false;
		if (b.cima) {
			u = true;
		}
		if (b.baixo) {
			d = true;
		}
		if (b.esquerda) {
			l = true;
		}
		if (b.direita) {
			r = true;
		}
		return new Colisao(u, d, l, r);
	}
	
	public String toString() {
		return "U"+cima+" D"+baixo+" L"+esquerda+" R"+direita;
	}
}
