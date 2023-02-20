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

    private void sortInsertion() {
        for (int i = 1; i < data.length; i++) {
            int j = i - 1;
            int temp = data[i];
            while (j >= 0 && data[j] > temp) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = temp;
        }
    }

    private int binarySearch(Integer[] arr, int left, int right, int target) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] > target) {
                return binarySearch(arr, left, mid - 1, target);
            }

            return binarySearch(arr, mid + 1, right, target);
        }

        return -1;
    }

    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Нельзя добавить null");
        }
        if (size == data.length) {
            increasingArray(size + 1);
        }
        data[size++] = item;
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

        for (int i = size; i > index; i--) {
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
        if (size == 0) {
            return false;
        }

        sortInsertion();

        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (item.compareTo(data[mid]) == 0) {
                return true;
            } else if (item.compareTo(data[mid]) < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
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
