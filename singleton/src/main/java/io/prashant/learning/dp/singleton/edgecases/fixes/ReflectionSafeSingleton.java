package io.prashant.learning.dp.singleton.edgecases.fixes;

public class ReflectionSafeSingleton {

	private static ReflectionSafeSingleton instance;

	private ReflectionSafeSingleton() {
		System.out.println("Private Constructor Invoked:");
		// Check if instance already created. if yes, throw Exception
		if (ReflectionSafeSingleton.instance != null) {
			System.out.println("Singleton instance already initialized : Throwing Exception");
			throw new IllegalStateException("Already Instantiated: Can not invoked");
		}
	}

	public static ReflectionSafeSingleton getInstance() {
		// Created using Double Checking way of creating Singleton
		if (instance == null) {
			synchronized (ReflectionSafeSingleton.class) {
				if (instance == null) {
					instance = new ReflectionSafeSingleton();
				}
			}
		}

		return instance;
	}
}
