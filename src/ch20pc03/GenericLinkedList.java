package ch20pc03;

/**
 * 
 * @author frank
 */
public class GenericLinkedList {
 /**
    The Node class stores a list element
    and a reference to the next node.
   */

    
    
    private Node first;
    private Node last;
    
    public GenericLinkedList() {
        first = null;
        last = null;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public int size() {
        int count = 0;
        Node p = first;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }
    
    public void add(String e) {
        if (isEmpty()) {
            first = new Node(e);
            last = first;
        } else {
            last.next = new Node(e);
            last = last.next;
        }
    }
    
    public void add(int index, String e) {
        if (index < 0 || index > size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        
        if (index == 0) {
            first = new Node(e, first);
            if (last == null) {
                last = first;
            }
            return;
        }
        
        Node pred = first;
        for (int i = 1; i <= index - 1; i++) {
            pred = pred.next;
        }
        
        pred.next = new Node(e, pred.next);
        
        if (pred.next.next == null) {
            last = pred.next;
        }
    }
    
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        
        Node p = first;
        while (p != null) {
            strBuilder.append(p.value + "\n");
            p = p.next;
        }
        return strBuilder.toString();
    }
    
    public String remove(int index) {
        if (index < 0 || index >= size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        
        String element;
        if (index == 0) {
            element = first.value;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node pred = first;
            
            for (int i = 1; i <= index -1; i++) {
                pred = pred.next;
            }
            
            element = pred.next.value;
            
            pred.next = pred.next.next;
            if (pred.next == null) {
                last = pred;
            }
        }
        return element;
    }
    
    public void reverse() {
        Node previous = null;
        Node curr = first;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }
        
        last = first;
        first = previous;
    }
    
    public boolean remove(String element) {
        if (isEmpty()) {
           return false; 
        }
        if (element.equals(first.value)) {
            first = first.next;
            if (first == null) {
               last = null; 
            }
            return true;
        }
        
        Node pred = first;
        while (pred.next != null && !pred.next.value.equals(element)) {
            pred = pred.next;
        }
        
        if (pred.next == null) {
            return false;
        }
        
        pred.next = pred.next.next;
        
        if (pred.next == null) {
            last = pred;
        }
        return true;
    }
    
    public void sort() {
        first = sortUtil(first);
    }
    
    private Node sortUtil(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node middle = findMiddle(head);
        Node Middle = middle.next;
        middle.next = (null);
        Node left = sortUtil(head);
        Node right = sortUtil(Middle);
        Node sorted = merge(left, right);
        return sorted;
    }
    
    private Node merge(Node a, Node b){
        if(a == null) {
            return b;
        }
        
        if(b == null) {
            return a;
        }
        
        Node temp = null;
        if(a.value.compareTo(b.value)<0) {
            temp = a;
            temp.next = (merge(a.next, b));
        }else{
            temp = b;
            temp.next = (merge(a, b.next));
        }
        
        return temp;
    }
    
    private Node findMiddle(Node head) {
        if(head == null){
            return head;
        }
        
        Node curr = head;
        Node temp = head;
        
        while(temp != null && temp.next != null && temp.next.next != null){
            curr = curr.next;
            temp = temp.next.next;
        }
        return curr;
    }
    
    private class Node {
        String value;
        Node next;
        Node(String val, Node n) {
            value = val;
            next = n;
        }
        
        Node(String val) {
            this(val, null);
        }
    }
}