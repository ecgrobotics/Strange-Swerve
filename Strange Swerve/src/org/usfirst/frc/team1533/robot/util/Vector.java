package org.usfirst.frc.team1533.robot.util;

public class Vector {
	public double x, y;

	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getAngle() {
		return Math.atan2(y, x);
	}

	public double getMagnitude() {
		return Math.hypot(x, y);
	}

	public Vector multiply(double scalar) {
		x *= scalar;
		y *= scalar;
		return this;
	}

	public Vector add(Vector v) {
		x += v.x;
		y += v.y;
		return this;
	}

	public Vector subtract(Vector v) {
		x -= v.x;
		y -= v.y;
		return this;
	}

	public Vector rotate(double radians) {
		double tempx = x;
		x = x * Math.cos(radians) - y * Math.sin(radians);
		y = tempx * Math.sin(radians) + y * Math.cos(radians);
		return this;
	}
	
	public Vector clone() {
		return new Vector(x, y);
	}
}
