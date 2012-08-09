package br.com.eliti.kroltan;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Moeda extends Sprite {

	public byte valor;
	public static byte gold = 8;
	private Random r = new Random();

	public Moeda(short _posX, short _posY, short _sizeX, short _sizeY,
			byte _valor) {
		super(_posX, _posY, _sizeX, _sizeY);
		valor = _valor;
		size = new Vector2D(valor*2, valor*2);
	}

	public Moeda(Vector2D _pos, Vector2D _size, byte _valor) {
		super(_pos, _size);
		valor = _valor;
		size = new Vector2D(valor*2, valor*2);
	}

	@Override
	public void SimulaSe(long DiffTime) {
		
	}

	@Override
	public void DesenhaSe(Graphics2D dbg, int XMundo, int YMundo) {
		if (valor > gold) {
			dbg.setColor(Color.yellow);
		} else {
			dbg.setColor(Color.white);
		}
		dbg.fillRect((int) pos.x + (r.nextInt(4) - 2), (int) pos.y + (r.nextInt(4) - 2), valor * 2, valor * 2);
		//DEBUG DA AREA DE COLISAO
		//dbg.setColor(Color.red);
		//dbg.fillRect((int)pos.x, (int)pos.y, (int)size.x, (int)size.y);
	}

}
