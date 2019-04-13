package StackAndQueue.CatDogQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue2 {
    private Queue<PetEnterQueue> dogQueue;
    private Queue<PetEnterQueue> catQueue;
    private long count;

    public MyQueue2() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
        count = 0;
    }

    public void add(Pet pet) {
        if(pet.getPetType().equals("Cat")) {
            catQueue.add(new PetEnterQueue(pet, count++));
        }
        else if(pet.getPetType().equals("Dog")) {
            dogQueue.add(new PetEnterQueue(pet,count++));
        }
    }

    /** 必须分四种情况讨论，否则可能会出现在null上调用方法的情况 **/
    public Pet pollAll() {
        if(catQueue.isEmpty() && dogQueue.isEmpty()){
            throw new RuntimeException("Queue is Empty!");
        }
        else if(!catQueue.isEmpty() && !dogQueue.isEmpty()) {
            if(catQueue.peek().getCount() < dogQueue.peek().getCount()) {
                count--;
                return catQueue.poll().getPet();
            }
            else if(catQueue.peek().getCount() > dogQueue.peek().getCount()) {
                count--;
                return dogQueue.poll().getPet();
            }
        }
       else if(!catQueue.isEmpty()) {
           return catQueue.poll().getPet();
        }
       else {
           return dogQueue.poll().getPet();
        }
       return null;
    }

    public Dog pollDog() {
        if(dogQueue.isEmpty())
            throw new RuntimeException("Queue has no dog!");
        else {
            return (Dog)dogQueue.poll().getPet();
        }
    }

    public Cat pollCat() {
        if(catQueue.isEmpty())
            throw  new RuntimeException("Queue has no cat!");
        else {
            return (Cat)catQueue.poll().getPet();
        }
    }

    public boolean isEmpty() {
        return (dogQueue.isEmpty() && catQueue.isEmpty());
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }

}

class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getPetType() {
        return pet.getPetType();
    }
}