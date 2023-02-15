public class ListItem implements StringList{
    private String[] item;
    private int index;
    private int capacity = 10;

    public ListItem() {
        this.item = new String[capacity];
        this.index = 0;
    }

    public String[] getItem() {
        return item;
    }

    public void setItem(String[] item) {
        this.item = item;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
