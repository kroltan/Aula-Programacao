import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Moeda extends Sprite {

	public byte valor;
	private Random r = new Random();

	public Moeda(short _posX, short _posY, short _sizeX, short _sizeY,
			byte _valor) {
		super(_posX, _posY, _sizeX, _sizeY);
		valor = _valor;
	}

	public Moeda(Vector2D _pos, Vector2D _size, byte _valor) {
		super(_pos, _size);
		valor = _valor;
	}

	@Override
	public void SimulaSe(long DiffTime) {
		
	}

	@Override
	public void DesenhaSe(Graphics2D dbg, int XMundo, int YMundo) {
		dbg.setColor(Color.white);
		dbg.fillRect((int) pos.x - valor/2 + (r.nextInt(4) - 2), (int) pos.y - valor/2 + (r.nextInt(4) - 2), valor * 2, valor * 2);
	}

}
