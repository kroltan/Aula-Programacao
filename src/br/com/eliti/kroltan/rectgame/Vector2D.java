package br.com.eliti.kroltan.rectgame;

public class Vector2D {
	public float x, y;
	public Vector2D(float _x, float _y) {
		x = _x;
		y = _y;
	}
	public void add(Vector2D o) {
		x+=o.x;
		y+=o.y;
	}
	public String toString() {
		return "X"+x+" Y"+y;
	}
}
