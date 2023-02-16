import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList implements StringList{

    private String[] data;
    private int size;
    private int capacity;

    public ArrayList(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException("Размер не может быть отрицательным значением");
        }
        this.capacity = capacity;
        this.data = new String[capacity];
        this.size = 0;
    }

    //method of increasing the array
    private void increasingArray(int minCapacity) {
        int oldCapacity = data.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Нельзя добавить null");
        }
        data[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new IllegalArgumentException("Нельзя добавить null");
        }
        if (index < 0 || index > capacity) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }

        for (int i = index; i > size; i--) {
            data[i] = data[i-1];
        }
        data[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (item == null) {
            throw new IllegalArgumentException("Нельзя добавить null");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        String replaced = data[index];
        data[index] = item;
        return replaced;
    }


    @Override
    public String remove(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Нельзя удалить null");
        }
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return remove(i);
            }
        }
        throw new NoSuchElementException("Item не найден: " + item);
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        String removed = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;
        return removed;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            return -1;
        }
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            return -1;
        }
        for (int i = size-1; i >= 0; i--) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        return data[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NullPointerException("Не может быть null");
        }
        if (otherList.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!data[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        data = new String[capacity];
    }


    @Override
    public String[] toArray() {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = data[i];
        }
        return array;
    }
}
