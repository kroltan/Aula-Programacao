package br.com.eliti.kroltan.rectgame;
//import java.awt.Graphics2D;

/**
 * Guarda informações sobre uma colisão retangular
 * @author Kroltan
 */
public class Colisao {
	
	public static boolean colideRetangulo(Sprite colidindo, Sprite colisor) {
		if (colidindo.pos.x+colidindo.size.x >= colisor.pos.x && colidindo.pos.x <= colisor.pos.x+colisor.size.x && colidindo.pos.y+colidindo.size.y >= colisor.pos.y && colidindo.pos.y <= colisor.pos.y+colisor.size.y) {
			return true;
		}
		return false;
	}
	public static Boolean colideTela(Sprite colidindo, int sizeTelaX, int sizeTelaY) {
		
		if (colidindo.pos.x+colidindo.size.x >= sizeTelaX || colidindo.pos.x <= 0 || colidindo.pos.y+colidindo.size.y >= sizeTelaY || colidindo.pos.y <= 0) {
			return true;
		}
		return false;
	}
}
