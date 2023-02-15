import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringList myList = new ArrayList(10);
        // Adding elements to the list
        myList.add("apple");
        myList.add("banana");
        myList.add("cherry");

        // Getting the size of the list
        System.out.println(myList.size());

        // Accessing elements of the list by index
        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));

        // Removing an element from the list by index
        myList.remove(1);

        // Checking if an element is contained in the list
        System.out.println(myList.contains("apple"));
        System.out.println(myList.contains("banana"));

        // Searching for the index of an element in the list
        System.out.println(myList.indexOf("cherry"));

        // Checking if the list is empty
        System.out.println(myList.isEmpty());

        // Removing all elements from the list
        myList.clear();

        // Converting the list to an array
        String[] myArray = myList.toArray();

        System.out.println("____________________________________________");

        IntegerArrayList list = new IntegerArrayList(10);


        // Adding elements to the list
        list.add(5);
        list.add(10);
        list.add(15);

        // Printing the list
        System.out.println("List: " + list);

        // Removing an element from the list
        list.remove(1);

        // Printing the modified list
        System.out.println("Modified List: " + list);

        // Updating an element in the list
        list.set(1, 20);

        // Printing the modified list
        System.out.println("Modified List: " + list);

        // Checking if an element is in the list
        System.out.println("List contains 5: " + list.contains(5));
        System.out.println("List contains 25: " + list.contains(25));

        // Finding the index of an element in the list
        System.out.println("Index of 15: " + list.indexOf(15));
        System.out.println("Index of 25: " + list.indexOf(25));

        // Finding the last index of an element in the list
        list.add(15);
        System.out.println("Last index of 15: " + list.lastIndexOf(15));

        // Checking if the list is empty
        System.out.println("Is list empty: " + list.isEmpty());

        // Clearing the list
        list.clear();
        System.out.println("Is list empty after clear: " + list.isEmpty());
    }
}