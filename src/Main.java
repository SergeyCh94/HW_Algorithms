
public class Main{
    public static void main(String[] args) {
        StringList myList = new ArrayList(10);
        String item1 = myList.add("Sergey");
        String item2 = myList.add(1, "Ivan");
        String item3 = myList.add(2, "Sveta");
        myList.remove(2);

        System.out.println(myList.size());
    }
}