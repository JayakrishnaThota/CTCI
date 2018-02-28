import java.util.*;

public class AnimalShelter {

    int time = 0;
    Queue<Animal> catq;
    Queue<Animal> dogq;

    class Animal{
        String name;
        int timestamp;

        public Animal(String name, int timestamp) {
            this.name = name;
            this.timestamp = timestamp;
        }
    }

    public AnimalShelter(){
        catq = new LinkedList<>();
        dogq = new LinkedList<>();
    }

    //This is used to enqueue a cat into the queue
    public void enqueueCat(String name){
        Animal cat = new Animal(name,++time);
        catq.offer(cat);
    }

    public void enqueueDog(String name){
        Animal dog = new Animal(name,++time);
        dogq.offer(dog);
    }

    public Animal dequeueCat(){
        Animal cat = catq.poll();
        return cat;
    }

    public Animal dequeueDog(){
        Animal dog = dogq.poll();
        return dog;
    }

    public Animal dequeue(){
        int cattime = catq.isEmpty()? Integer.MAX_VALUE:catq.peek().timestamp;
        int dogtime = dogq.isEmpty()?Integer.MAX_VALUE:dogq.peek().timestamp;
        if(cattime<dogtime) return dequeueCat();
        else return dequeueDog();
    }

    public static void main(String[] args) {
        AnimalShelter a = new AnimalShelter();
        a.enqueueCat("cat1");
        a.enqueueCat("cat2");
        a.enqueueDog("dog1");
        a.enqueueDog("dog2");
        System.out.println(a.dequeue().name);
        System.out.println(a.dequeue().name);
        System.out.println(a.dequeueDog().name);
    }
}
