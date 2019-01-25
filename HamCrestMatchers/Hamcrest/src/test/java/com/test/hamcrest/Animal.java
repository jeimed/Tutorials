package com.test.hamcrest;

/**
 * 
 * @author johni
 *
 */
public class Animal {
	String name;
	boolean wild;
	String sound;
	int legs;
	
	public Animal(String name, boolean wild, String sound, int legs) {
		super();
		this.name = name;
		this.wild = wild;
		this.sound = sound;
		this.legs = legs;
	}
	public String getName() {
		return name;
	}
	//will get the nr of legs of animal
	public int getLegs() {
		return legs;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isWild() {
		return wild;
	}
	public void setWild(boolean wild) {
		this.wild = wild;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	// will set nr of legs of animal
	public void setNrOfLegs(int legs) {
		this.legs = legs;
	}
	
}
