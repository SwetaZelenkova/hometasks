package edu.pht.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Cat[] catsArray = { new Cat("Vasya", 2, Gender.MALE), new Cat("Jay", 8, Gender.MALE),
				new Cat("Jay", 18, Gender.MALE), new Cat("Mashka", 4, Gender.FEMALE),
				new Cat("Vasilisa", 16, Gender.FEMALE), new Cat("Barsik", 21, Gender.MALE),
				new Cat("Arny", 1, Gender.MALE), new Cat("Murka", 7, Gender.FEMALE), new Cat("Vasya", 6, Gender.MALE),
				new Cat("Vasya", 12, Gender.MALE), new Cat("Barsik", 5, Gender.MALE),
				new Cat("Barsik", 13, Gender.MALE), new Cat("Mashka", 8, Gender.FEMALE),
				new Cat("Jay", 18, Gender.FEMALE) };
		Set<Cat> cats = new TreeSet<>(
				new CatSortedByName().thenComparing(new CatSortedByAge()).thenComparing(new CatSortedByGender()));
		Collections.addAll(cats, catsArray);
		printCollection(cats);
		cats = new HashSet<>(Arrays.asList(catsArray));
		Iterator<Cat> it = cats.iterator(); 
		while (it.hasNext()) {
			Cat cat = it.next();
			System.out.println(cat + ".hashcode() - " + cat.hashCode());
		}
		printCollection(cats);
		System.out.println("\nCreate Priority Queue------------");
		Queue<Cat> queueCats = new PriorityQueue<>(catsArray.length,
				new CatSortedByName().thenComparing(new CatSortedByAge()).thenComparing(new CatSortedByGender()));
		Collections.addAll(queueCats, catsArray);
		System.out.println("\nThe highest priority element in Queue\n" + queueCats.peek());
		System.out.println("\nDelete Priority Queue------------");
		while (!queueCats.isEmpty()) {
			System.out.println("\nThe highest priority item in the Queue\n" + queueCats.peek());
			System.out.println(".poll() - " + queueCats.poll());
		}
		System.out.println("\nFill Priority Queue--------------");
		for (Cat cat : catsArray) {
			queueCats.offer(cat);
			System.out.print(cat);
		}
		System.out.println("\nPriority Queue to print----------");
		while (!queueCats.isEmpty()) {
			System.out.println(queueCats.poll());
		}
	}

	public static void printCollection(Collection<Cat> c) {
		for (Cat cat : c) {
			System.out.print(cat);
		}
		System.out.println();
	}
}
