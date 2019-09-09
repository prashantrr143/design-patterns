package io.prashant.learning.dp.singleton;

public class Singleton {

	private static Singleton instance;

	/**
	 * Making Constructor private
	 */
	private Singleton() {
	}

	public Singleton getInstance() {
	if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

}
