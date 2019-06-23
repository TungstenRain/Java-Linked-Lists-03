package ch20pc03;

/**
 * 
 * @author frank
 */
public class Ch20pc03 {

    /**
     * The Main Method
     * @param args String[] The command line arguments
     */
    public static void main(String[] args) {
        // Instantiate the GenericLinkedList
        GenericLinkedList linkedList = new GenericLinkedList();
        
        // Add to linkedList
        linkedList.add("Amy");
        linkedList.add("Bob");
        linkedList.add(0, "Al");
        linkedList.add(2, "Beth");
        linkedList.add(4, "Carol");
        
        System.out.println("Welcome to the Linked List Sorting and Reversing program.");
        System.out.println("The members of the list are:");
        System.out.print(linkedList);
        
        System.out.println("The Members of the list after reversing are:");
        linkedList.reverse();
        System.out.print(linkedList);
        
        System.out.println("The members of the list after sorting are:");
        linkedList.sort();
        System.out.print(linkedList);
    }
}
