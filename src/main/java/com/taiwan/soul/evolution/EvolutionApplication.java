package com.taiwan.soul.evolution;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.xml.bind.v2.runtime.output.StAXExStreamWriterOutput;
import com.taiwan.soul.evolution.controller.Singleton;

class T1 implements Runnable {
	int sum = 0;
	public Dog dog;
	public Singleton singleton = null;
	
	public T1(Dog dog) {
		this.dog = dog;
	}
	@Override
	public void run() {
		getSingleton(Singleton.getSingleton());
//		synchronized(this) {
//			for (int i = 0; i <= 100; i++) {
//				sum = sum + i;
//				++dog.num;
//			}
//			notify();
//		}
	}
	
	public Singleton getSingleton(Singleton singleton) {
		this.singleton = singleton;
		return this.singleton;
	}
	

}


class Dog {
	int num = 0;
	
	public void bark() {
		System.out.println("bark");
	}
}

@SpringBootApplication
public class EvolutionApplication {

	public static void main(String[] args) throws InterruptedException {
//		T2 t1 = new T2("1");
//		T2 t2 = new T2("2");
//		T2 t3 = new T2("3");
//		T2 t4 = new T2("4");
//		T2 t5 = new T2("5");
//		T2 t6 = new T2("6");
//		T2 t7 = new T2("7");
//		T2 t8 = new T2("8");
//		T2 t9 = new T2("9");
//		T2 t10 = new T2("10");
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
//		t5.start();
//		t6.start();
//		t7.start();
//		t8.start();
//		t9.start();
//		t10.start();
		Dog dog = new Dog();
		// Thread 1
//		T1 t1 = new T1(dog);
//		Thread thread1 = new Thread(t1);
//		thread1.start();
//		synchronized(thread1) {
//			thread1.wait();
//		}
		
		// Thread 2
//		T1 t2 = new T1(dog);
//		Thread thread2 = new Thread(t2);
//		thread2.start();
//		synchronized(thread2) {
//			thread2.wait();
//		}

		Singleton singleton = new Singleton();
		Singleton singleton2 = new Singleton();
		System.out.println(set.size());
//		System.out.println(t1.sum);
//		System.out.println(t2.sum);
//		System.out.println(dog.num);
		
//		SpringApplication.run(EvolutionApplication.class, args);
	}

}
