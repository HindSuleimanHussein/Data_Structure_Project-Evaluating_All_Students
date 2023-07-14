package com.example.firstdatastructureproject;

public class Node<E extends Comparable<E>>{

    private E data;
    private Node<E> next;


    public Node(E data) {
        super();
        this.data =  data;
    }


    public E getData() {
        return data;
    }


    public void setData(E data) {
        this.data = data;
    }


    public Node<E> getNext() {
        return next;
    }


    public void setNext(Node<E> next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return "-->" + data;
    }


}