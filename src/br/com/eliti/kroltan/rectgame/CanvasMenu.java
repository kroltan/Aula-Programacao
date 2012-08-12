package br.com.eliti.kroltan.rectgame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CanvasMenu extends GCanvas {

	public ArrayList<Botao> botoes = new ArrayList<Botao>();
	public int selected;
	Obstaculo mouseSensor = new Obstaculo((short)0, (short)0, (short)1, (short)1);
	
	public CanvasMenu() {
		selected = 0;
		//botoes.add(new Botao(new Vector2D(0, 0), new Vector2D(0, 0), Color.black, Color.black, ""));
		botoes.add(new Botao(new Vector2D(5, GamePanel.PHEIGHT-50), new Vector2D(100, 20), Color.orange, Color.yellow, "Jogar"));
		botoes.add(new Botao(new Vector2D(5, GamePanel.PHEIGHT-25), new Vector2D(100, 20), Color.orange, Color.yellow, "Sair"));
	}
	
	@Override
	public void DesenhaSe(Graphics2D dbg) {
		DesenhaSe(dbg, 0, 0);
		
	}

	@Override
	public void DesenhaSe(Graphics2D dbg, int arg0, int arg1) {
		dbg.fillRect(0, 0, GamePanel.PWIDTH, GamePanel.PHEIGHT);
		for (int i = 0; i < botoes.size(); i++) {
			botoes.get(i).hover = false;
		}
		botoes.get(selected).hover = true;
		for (int i = 0; i < botoes.size(); i++) {
			botoes.get(i).DesenhaSe(dbg, 0, 0);
		}
	}

	@Override
	public void SimulaSe(long diffTime) {
		for (int i = 0; i < botoes.size(); i++) {
			if (Colisao.colideRetangulo(mouseSensor, botoes.get(i))) {
				selected = i;
			}
			botoes.get(i).SimulaSe(diffTime);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e, GCanvas canvas) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e, GCanvas canvas) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseSensor.pos.x = e.getPoint().x;
		mouseSensor.pos.y = e.getPoint().y;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for (int i = 0; i < botoes.size(); i++) {
			if (Colisao.colideRetangulo(mouseSensor, botoes.get(i))) {
				Actions(i);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	public void Actions(int i) {
		if (i == 0) {
			GamePanel.instancia.CanvasAtivo = new CanvasGame();
		} else if (i == 1) {
			GamePanel.running = false;
		}
	}

}
