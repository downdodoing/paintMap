package com.example;

import java.awt.Graphics;

public class MPaint {
	private MapColor mc;
	private int current = 0;
	int[][] metrix;

	public MPaint(MapColor mc, int[][] metrix) {
		this.mc = mc;
		this.metrix = metrix;
	}

	// �����жϵ�ǰʡ����ɫ������ʡ����ɫ�Ƿ��ͻ
	public boolean isOK(int provinceColor[]) {
		for (int j = 0; j < current; j++) {
			// �жϵ�ǰʡ��jʡ�����ٽ�ʡ�Լ��Լ���ǰʡ����ɫ�Ƿ��͵�ǰ��ѡ��ɫ��ͬ
			if (metrix[current][j] == 1
					&& provinceColor[j] == provinceColor[current]) {
				return false;
			}
		}
		return true;
	}

	// ������ȱ���
	public int dfs(int provinceColor[]) {
		int i = 0;
		if (current <= 33)
			for (; i < 4; i++) {
				// ��ʡ�ݽ�����ɫ��ֵ
				provinceColor[current] = i;
				// ��ȡ�����ɫ�Ļ������
				Graphics g = mc.getGraphics();
				// �Ե�ǰʡ�ݽ�����ɫ���
				mc.fillColor(g, current, i);
				if (isOK(provinceColor)) {// ���ڴ�������ʡ��
					current++;// ��ת����һ��ʡ
					int j = dfs(provinceColor);
					// ��j==-1ʱ��ʾ4����ɫ�Ѿ�����
					if (j == -1) {
						current--;
						provinceColor[current] = -1;
					}
					if (current > 33) {
						return 1;
					}
				}
			}
		if (i >= 4) {
			return -1;
		}
		return 1;
	}

	public void backtrack() {
		int[] provinceColor = new int[34];
		dfs(provinceColor);
	}

}
