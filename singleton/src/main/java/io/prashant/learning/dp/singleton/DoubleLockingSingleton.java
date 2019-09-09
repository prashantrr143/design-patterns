package io.prashant.learning.dp.singleton;

/**
 * Singleton Design Pattern Implementation : Using Double Checked Locking Pattern
 * 
 * @author prasingh26
 *
 */
public class DoubleLockingSingleton {

	private static DoubleLockingSingleton instance;

	private DoubleLockingSingleton() {
		// Constructor made private , so that no access allowed from outside this class
		System.out.println("Private constructor Invoked: Should be invoked only once : from getInstance() method");
	}

	/**
	 * Static method to provide Instance
	 * 
	 * @return
	 */
	public static DoubleLockingSingleton getInstance() {

		if (instance == null) { // Check 1
			synchronized (DoubleLockingSingleton.class) {
				if (instance == null) { // Check 2 : Double Checked
					instance = new DoubleLockingSingleton();
				}
			}
		}

		return instance;
	}

}
