package StackAndQueue.CatDogQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue1 {
    private Queue<Pet> q1;
    private Queue<Pet> q2;

    public MyQueue1() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void add(Pet pet) {
        if(!q1.isEmpty()){
            q1.add(pet);
        }else{
            q2.add(pet);
        }
    }

    public Pet pollAll() {
        if(q1.isEmpty() && q2.isEmpty()){
            throw new RuntimeException("Queue is Empty!");
        }
        else{
            if(q1.isEmpty())return q2.poll();
            else return q1.poll();
        }
    }

    public Dog pollDog() {
        Dog result = null;
        if(q1.isEmpty() && q2.isEmpty()){
            throw new RuntimeException("Queue is Empty!");
        }
        else {
            boolean alreadyPoll = false;
            if (q1.isEmpty()) {
                while (!q2.isEmpty()) {
                    Pet tmp = q2.poll();
                    if (tmp.getPetType().equals("Dog") && !alreadyPoll) {
                        result = (Dog) tmp;
                        alreadyPoll = true;
                    } else {
                        q1.add(tmp);
                    }
                }
            } else {
                while (!q1.isEmpty()) {
                    Pet tmp = q1.poll();
                    if (tmp.getPetType().equals("Dog") && !alreadyPoll) {
                        result = (Dog) tmp;
                        alreadyPoll = true;
                    } else {
                        q2.add(tmp);
                    }
                }
            }
        }
           return result;
    }
    public Cat pollCat() {
        Cat result = null;
        if(q1.isEmpty() && q2.isEmpty()){
            throw new RuntimeException("Queue is Empty!");
        }
        else {
            boolean alreadyPoll = false;
            if (q1.isEmpty()) {
                while (!q2.isEmpty()) {
                    Pet tmp = q2.poll();
                    if (!alreadyPoll && tmp.getPetType().equals("Cat") ) {
                        result = (Cat) tmp;
                        alreadyPoll = true;
                    } else {
                        q1.add(tmp);
                    }
                }
            } else {
                while (!q1.isEmpty()) {
                    Pet tmp = q1.poll();
                    if (!alreadyPoll && tmp.getPetType().equals("Cat") ) {
                        result = (Cat) tmp;
                        alreadyPoll = true;
                    } else {
                        q2.add(tmp);
                    }
                }
            }
        }
        return result;
    }

    public boolean isEmpty() {
        return (q1.isEmpty() && q2.isEmpty());
    }

    public boolean isDogEmpty() {
        boolean result = true;
        if(q1.isEmpty() && q2.isEmpty())return true;
        else {
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    Pet tmp = q1.poll();
                    if(result && tmp.getPetType().equals("Dog") )result = false;
                    q2.add(tmp);
                }
            }
            else {
                while(!q2.isEmpty()) {
                    Pet tmp = q2.poll();
                    if(result && tmp.getPetType().equals("Dog") )result = false;
                    q1.add(tmp);
                }
            }
        }
        return result;
    }
    public boolean isCatEmpty() {
        boolean result = true;
        if(q1.isEmpty() && q2.isEmpty())return true;
        else {
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    Pet tmp = q1.poll();
                    if(result && tmp.getPetType().equals("Cat") )result = false;
                    q2.add(tmp);
                }
            }
            else {
                while(!q2.isEmpty()) {
                    Pet tmp = q2.poll();
                    if(result && tmp.getPetType().equals("Cat") )result = false;
                    q1.add(tmp);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MyQueue1 q = new MyQueue1();
        for(int i = 0; i < 3; i++){
            Dog dog = new Dog();
            Cat cat = new Cat();
            q.add(dog);
            q.add(cat);
        }
//        for(int i = 0; i < 6; i++) {
//            System.out.println(q.pollAll());
//        }
        System.out.println(q.pollCat());
        System.out.println(q.pollDog());
        System.out.println(q.pollDog());
        System.out.println(q.pollAll());
        System.out.println(q.isCatEmpty());
        System.out.println(q.isDogEmpty());
        System.out.println(q.isEmpty());
        System.out.println(q.pollAll());
        System.out.println(q.isDogEmpty());
        System.out.println(q.pollAll());
        System.out.println(q.isCatEmpty());
        System.out.println(q.isEmpty());
    }
}
