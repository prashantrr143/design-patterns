package io.prashant.learning.dp.singleton.edgecases;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import io.prashant.learning.dp.singleton.DoubleLockingSingleton;
import io.prashant.learning.dp.singleton.edgecases.fixes.ReflectionSafeSingleton;

public class BreakSingletonByCloneable {


	public static void main(String args[]) {

		System.out.println(" \t Case 1 : Cloneabel unsafe singleton class");
		DoubleLockingSingleton singleton = DoubleLockingSingleton.getInstance();
		DoubleLockingSingleton anotherSingleton = null;
		System.out.println("Created Singleton :  " + singleton);

		try {
			Class<?> loadedClass = Class.forName("io.prashant.learning.dp.singleton.DoubleLockingSingleton");

			// getDeclaredConstructors() will get the declared private constructors as well.
			// i.e. constructors declared by user in the class: public ,private, default,
			// protected
			for (Constructor<?> constructor : loadedClass.getDeclaredConstructors()) {

				// need to set constructor as accessible , if not the IllegalAccessException
				// will be thrown as displayed below

				constructor.setAccessible(true);
				/**
				 * java.lang.IllegalAccessException: Class
				 * io.prashant.learning.dp.singleton.edgecases.BreakSingletonByReflection can
				 * not access a member of class
				 * io.prashant.learning.dp.singleton.DoubleLockingSingleton with modifiers
				 * "private"
				 */
				// Creating a new instance of singleton class reflectively
				anotherSingleton = (DoubleLockingSingleton) constructor.newInstance();
				break;

			}

			System.out.println("Reflectively Created Singleton Instance :  " + anotherSingleton);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException
				| SecurityException e) {
			e.printStackTrace();
		}

		System.out.println("Are both instances equal ?  " + (singleton == anotherSingleton));

		System.out.println(" \t Case 2 :  Reflection Safe Singleton class");

		ReflectionSafeSingleton refSafeSingleton = ReflectionSafeSingleton.getInstance();
		System.out.println("Created Singleton :  " + refSafeSingleton);
		ReflectionSafeSingleton anotherRefSafeSingleton = null;

		try {
			Class<?> refLoadedClass = Class
					.forName("io.prashant.learning.dp.singleton.edgecases.fixes.ReflectionSafeSingleton");
			for (Constructor<?> constructor : refLoadedClass.getDeclaredConstructors()) {
				// setting constructor access to true
				constructor.setAccessible(true);
				anotherRefSafeSingleton = (ReflectionSafeSingleton) constructor.newInstance();
			}
		} catch (Exception ie) {
			System.out.println(" Exception : ******** : Unable to create Singleton : because: " + ie.getMessage());
			ie.printStackTrace();
		}

		System.out.println("Reflectively Created Singleton Instance :  " + anotherRefSafeSingleton);
		System.out.println("Are both instances equal ?  " + (refSafeSingleton == anotherRefSafeSingleton));

	}


	
	
}
