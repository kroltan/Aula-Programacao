//import java.awt.Graphics2D;


public class Colisao {
	public boolean cima;
	public boolean baixo;
	public boolean esquerda;
	public boolean direita;
	public Sprite colisor;
	
	public Colisao(boolean _cima, boolean _baixo, boolean _esquerda, boolean _direita, Sprite _colisor) {
		cima = _cima;
		baixo = _baixo;
		esquerda = _esquerda;
		direita = _direita;
		colisor = _colisor;
	}
	public Colisao(boolean _cima, boolean _baixo, boolean _esquerda, boolean _direita) {
		cima = _cima;
		baixo = _baixo;
		esquerda = _esquerda;
		direita = _direita;
		colisor = null;
	}
	
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
		return new Colisao(u, d, l, r, colisor);
	}
	
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
