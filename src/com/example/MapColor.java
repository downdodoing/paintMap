package com.example;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class MapColor extends Canvas {
	private static final long serialVersionUID = 1L;

	private Color[] color = { Color.yellow, Color.blue, Color.green, Color.red,
			Color.white };
	private Polygon[] p;

	public MapColor(Polygon[] p) {
		this.p = p;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		for (int i = 0; i < 34; i++)
			g.drawPolygon(p[i]);
	}

	// 对图形进行颜色填充
	public void fillColor(Graphics g, int whichPolygon, int whichColor) {
		g.setColor(color[whichColor]);
		g.fillPolygon(p[whichPolygon]);
	}
}
