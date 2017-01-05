package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Monitor implements ActionListener {
	private MapColor mc;
	private int[][] metrix;

	public Monitor(MapColor mc, int[][] metrix) {
		this.mc = mc;
		this.metrix = metrix;
	}

	public void actionPerformed(ActionEvent event) {
		MPaint de = new MPaint(mc, metrix);
		de.backtrack();
	}
}
