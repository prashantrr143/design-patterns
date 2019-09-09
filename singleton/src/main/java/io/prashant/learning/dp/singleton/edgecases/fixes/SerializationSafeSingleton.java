package io.prashant.learning.dp.singleton.edgecases.fixes;

import java.io.Serializable;

/**
 * A singleton class which handles the case of implementing Serializable
 * interface while maintaining Singleton criteria
 * 
 * @author PrashantSingh
 *
 */
public class SerializationSafeSingleton implements Serializable {

	/**
	 * Default generated SerialVersionUID
	 */
	private static final long serialVersionUID = -7189948987184975550L;

	private static SerializationSafeSingleton instance;

	/**
	 * Marking Constructor as Private to stop access from outside of this class
	 */
	private SerializationSafeSingleton() {
		System.out.println("Private Constructor : for SerializationSafeSingleton invoked");
	}

	public static SerializationSafeSingleton getInstance() {

		if (instance == null) {
			synchronized (SerializationSafeSingleton.class) {
				if (instance == null) {
					instance = new SerializationSafeSingleton();
				}
			}

		}
		return instance;
	}

	/**
	 * Implementing readResolve method to return Same singleton instance
	 * 
	 * @return
	 */
	public Object readResolve() {
		System.out.println("read Resolve method invoked");
		return instance;
	}

}
