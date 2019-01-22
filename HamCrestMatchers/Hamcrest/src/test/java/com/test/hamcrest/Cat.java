package com.test.hamcrest;

/**
 * cat class
 * @author johni
 *
 */
public class Cat extends Animal {

	public Cat() {
		super("cat", false, "meows",4);
	}

	public String makeSound() {
		//returns cat sound
		return getSound();
	}

}
