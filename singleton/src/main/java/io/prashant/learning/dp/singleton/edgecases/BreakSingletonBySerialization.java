package io.prashant.learning.dp.singleton.edgecases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import io.prashant.learning.dp.singleton.edgecases.fixes.SerializationSafeSingleton;
import io.prashant.learning.dp.singleton.edgecases.impl.SingletonImplementsSerializable;

public class BreakSingletonBySerialization {

	public static final String CASE1_FILE_PATH = "case1.dat";
	public static final String CASE2_FILE_PATH = "case2.dat";

	public static void main(String args[]) {

		System.out.println(" \t Case 1 : Serialization unsafe singleton class");
		SingletonImplementsSerializable singleton = SingletonImplementsSerializable.getInstance();
		SingletonImplementsSerializable anotherSingleton = null;
		System.out.println("Created Singleton :  " + singleton);

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CASE1_FILE_PATH))) {
			System.out.println("Writing Singleton Object to Stream");
			oos.writeObject(singleton);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CASE1_FILE_PATH))) {
			anotherSingleton = (SingletonImplementsSerializable) ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Using Serialization Created Singleton Instance :  " + anotherSingleton);

		System.out.println("Are both instances equal ?  " + (singleton == anotherSingleton));

		System.out.println(" \n\n\t Case 2 :  Serialization Safe Singleton class");

		SerializationSafeSingleton ssSingleton = SerializationSafeSingleton.getInstance();
		SerializationSafeSingleton anotherSerializedSingleton = null;

		System.out.println("Created Singleton :  " + ssSingleton);

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CASE2_FILE_PATH))) {
			System.out.println("Writing Singleton Object to Stream");
			oos.writeObject(ssSingleton);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CASE2_FILE_PATH))) {
			anotherSerializedSingleton = (SerializationSafeSingleton) ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Using Serialization  Created Singleton Instance :  " + anotherSerializedSingleton);
		System.out.println("Are both instances equal ?  " + (ssSingleton == anotherSerializedSingleton));

	}

}
