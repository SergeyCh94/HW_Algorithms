import java.util.Arrays;
import java.util.NoSuchElementException;

public class IntegerArrayList implements IntegerList{
    private Integer[] data;
    private int size;
    private int capacity;

    public IntegerArrayList(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException("Размер не может быть отрицательным значением");
        }
        this.capacity = capacity;
        this.data = new Integer[capacity];
        this.size = 0;
    }

    private void bubbleSort(Integer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private int binarySearch(int key, int fromIndex, int toIndex) {
        return Arrays.binarySearch(toArray(), fromIndex, toIndex, key);
    }

    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Нельзя добавить null");
        }
        data[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
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
    public Integer set(int index, Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Нельзя добавить null");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        Integer replaced = data[index];
        data[index] = item;
        return replaced;
    }


    @Override
    public Integer remove(Integer item) {
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
    public Integer remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        Integer removed = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;
        return removed;
    }

    @Override
    public boolean contains(Integer item) {
        return binarySearch(item, 0, size()) >= 0;
    }

    @Override
    public int indexOf(Integer item) {
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
    public int lastIndexOf(Integer item) {
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
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        return data[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
        data = new Integer[capacity];
    }


    @Override
    public Integer[] toArray() {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = data[i];
        }
        return array;
    }

    @Override
    public String toString() {
        return "IntegerArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
