package com.tan_nai.javaversionbreakapp;

public class BugObject {
	int x,y = 0;
	int type; //SA = 0, CPU = 1, LU = 2
	public BugObject(int x, int type) {
		super();
		this.x = x;
		this.type = type;
	}
}
