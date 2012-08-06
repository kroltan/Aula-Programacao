import java.awt.Color;
import java.awt.Graphics2D;

public class Obstaculo extends Sprite {

	public Obstaculo(short _posX, short _posY, short _sizeX, short _sizeY) {
		super(_posX, _posY, _sizeX, _sizeY);
	}

	@Override
	public void SimulaSe(long DiffTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DesenhaSe(Graphics2D dbg, int XMundo, int YMundo) {
		dbg.setColor(Color.BLUE);
		dbg.fillRect((int) pos.x, (int) pos.y, (int)size.x, (int)size.y);
	}

}
