import java.util.LinkedList;

/*cc150 3.7
 * An animal shelter holds only dogs and cats, and operates on a strictly 
 * "first in first out" basis. People must adopt either the "oldest"(based on arrival time)
 * of all animals at the shelter, or they can select whether they would prefer
 * a dog or a cat (and will receive the oldest animal of that type). They cannot select 
 * which specific animal they would like. Create the data structures to maintain
 * this system and implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat.
 * You may use the built-in LinkedList data Structure*/
public class AnimalQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnimalQueue queue = new AnimalQueue();
		queue.enqueue(new Dog("dog1"));
		queue.enqueue(new Dog("dog2"));
		queue.enqueue(new Cat("cat1"));
		queue.enqueue(new Dog("dog3"));
		queue.enqueue(new Cat("cat2"));
		queue.enqueue(new Cat("cat3"));
		
		System.out.println(queue.dequeueAny().getName());
		System.out.println(queue.dequeueAny().getName());
		System.out.println(queue.dequeueDogs().getName());
		System.out.println(queue.dequeueCats().getName());

	}

    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
	void enqueue(Animal a){
		if (a instanceof Dog) dogs.addLast((Dog)a);
		else if (a instanceof Cat) cats.addLast((Cat)a);
	}
	
	Animal dequeueAny(){
		if (dogs.size() == 0)dequeueCats();
		else if (cats.size()== 0) dequeueDogs();
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.getOrder() <= cat.getOrder())
			return dequeueDogs();
		else return dequeueCats();
	}
	
	public Dog dequeueDogs(){
		return dogs.poll();
	}
	
	public Cat dequeueCats(){
		return cats.poll();
	}
}

abstract class Animal{
	private String name;
	private int order;
	public static int number = 0;
	
	
	Animal(String n){
		setName(n);
		setOrder();
	}
	
	public void setName(String _name ){
		this.name = _name;
		}
	
	public String getName(){
		return this.name;
	}
	
	public void setOrder(){
		order = number;
		number++;
	}
	
	public int getOrder(){
		return order;
	}
}

class Dog extends Animal{
	Dog(String n){
		super(n);
	}
}

class Cat extends Animal{
	Cat(String n){
		super(n);
	}
}
