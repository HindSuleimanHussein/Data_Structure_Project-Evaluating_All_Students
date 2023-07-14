package com.example.firstdatastructureproject;

public class LinkedList<E extends Comparable<E>> {
    private Node<E> head;

    public Node<E> getHead() {
        return head;
    }

    public void insertSorted(E data) {
        Node<E> newNode = new Node(data);
        Node<E> curr = head;
        Node<E> prev = null;
        if (head == null) {
            head = newNode;
        } else {
            while (curr != null && curr.getData().compareTo(data) > 0) {
                prev = curr;
                curr = curr.getNext();

            }
            if (prev == null) {
                head = newNode;
                head.setNext(curr);
            } else {
                newNode.setNext(curr);
                prev.setNext(newNode);

            }
        }
    }

    public String search(E data) {
        Node<E> curr = head;
        while (curr != null) {
            if (curr.getData()==data)
                return curr.getData() + ":" + curr.getData() + ":" + curr.getData();
            else{
                curr = curr.getNext();
            }
        }

        return null;
    }

    public void delete(E data) {
        if (head.getData() == data) {
            head = head.getNext();
            return;
        }

        Node<E> previous = null;
        Node<E> current = head;

        while (current != null) {
            if (current.getData() == data) {
                previous.setNext(current.getNext());
                break;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

    }

    @Override
    public String toString() {
        String s = "Head ";
        Node<E> curr = head;
        while (curr != null) {
            s += curr.toString();
            curr = curr.getNext();
        }
        return s + " -->Null";
    }

}
