package io.prashant.learning.dp.singleton.edgecases.impl;

public class CloneableSingleton implements Cloneable {

	private static CloneableSingleton instance;

	private CloneableSingleton() {
		// Constructor made private , so that no access allowed from outside this class
		System.out.println("Private constructor Invoked: Should be invoked only once : from getInstance() method");
	}

	/**
	 * Static method to provide Instance
	 * 
	 * @return
	 */
	public static CloneableSingleton getInstance() {

		if (instance == null) { // Check 1
			synchronized (CloneableSingleton.class) {
				if (instance == null) { // Check 2 : Double Checked
					instance = new CloneableSingleton();
				}
			}
		}

		return instance;
	}

	@Override
	public Object clone() {
		return null;
	}

}
