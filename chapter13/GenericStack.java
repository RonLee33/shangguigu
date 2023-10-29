package chapter13;

import java.util.ArrayList;

/**泛型栈*/
public class GenericStack<E> {
    private ArrayList<E> list = new ArrayList<E>();

    public int getSize(){
        return list.size();
    }

    public E peek(){
        return list.get(getSize() - 1);
    }

    public void push(E e){
        list.add(e);
    }

    public E pop(){
        E e = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return e;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "GenericStack [list=" + list + "]";
    }

}
