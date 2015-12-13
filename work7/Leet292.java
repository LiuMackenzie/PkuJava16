package com.ly.test;

public class Leet292 {
	public boolean canWinNim(int n) {
		//时间复杂度，O（1）
		//参考网上方法写出。
		//两个人游戏 ，只要1-3颗石头的情况都可以一次取净，胜利。
		//4颗石头时，一定会输。5颗时，取1颗，让对方输。6颗时，取2颗；7颗取3颗
		if (n % 4 == 0)
			return false;
		else
			return true;
	}
}
