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

	// 用于判断当前省的颜色与相邻省区颜色是否冲突
	public boolean isOK(int provinceColor[]) {
		for (int j = 0; j < current; j++) {
			// 判断当前省和j省区是临接省以及以及当前省的颜色是否会和当前所选颜色相同
			if (metrix[current][j] == 1
					&& provinceColor[j] == provinceColor[current]) {
				return false;
			}
		}
		return true;
	}

	// 深度优先遍历
	public int dfs(int provinceColor[]) {
		int i = 0;
		if (current <= 33)
			for (; i < 4; i++) {
				// 对省份进行颜色赋值
				provinceColor[current] = i;
				// 获取填充颜色的画板对象
				Graphics g = mc.getGraphics();
				// 对当前省份进行颜色填充
				mc.fillColor(g, current, i);
				if (isOK(provinceColor)) {// 用于处理相邻省区
					current++;// 跳转到下一个省
					int j = dfs(provinceColor);
					// 当j==-1时表示4种颜色已经用完
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
