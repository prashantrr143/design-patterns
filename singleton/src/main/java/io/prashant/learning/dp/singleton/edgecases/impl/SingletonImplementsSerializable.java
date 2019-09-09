package io.prashant.learning.dp.singleton.edgecases.impl;

import java.io.Serializable;

/**
 * Singleton class implementing Serializable interface: Makes this class
 * eligible for serialization
 * 
 * @author prasingh26
 *
 */
public class SingletonImplementsSerializable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static SingletonImplementsSerializable instance;

	private SingletonImplementsSerializable() {
		// Constructor made private , so that no access allowed from outside this class
		System.out.println("Private constructor Invoked: Should be invoked only once : from getInstance() method");
	}

	/**
	 * Static method to provide Instance
	 * 
	 * @return
	 */
	public static SingletonImplementsSerializable getInstance() {

		if (instance == null) { // Check 1
			synchronized (SingletonImplementsSerializable.class) {
				if (instance == null) { // Check 2 : Double Checked
					instance = new SingletonImplementsSerializable();
				}
			}
		}

		return instance;
	}

}
