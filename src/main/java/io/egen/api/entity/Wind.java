package io.egen.api.entity;

import javax.persistence.Embeddable;

/**
 * @author mayurnayak
 *  "wind": {
    "speed": 3.1,
    "degree": 240
  },
 *
 */
@Embeddable
public class Wind {
	private double speed;
	private Integer degree;
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public Integer getDegree() {
		return degree;
	}
	public void setDegree(Integer degree) {
		this.degree = degree;
	}
}
