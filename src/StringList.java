import java.util.NoSuchElementException;

public interface StringList {

    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    static String add(String item){
        add(item);
        return item;
    }

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    static String add(int index, String item) throws IndexOutOfBoundsException{
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException("Индекс больше диапазона");
        } else {
            add(index, item);
            return item;
        }
    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    static String set(int index, String item) throws IndexOutOfBoundsException{
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException("Индекс больше диапазона");
        } else {
            return set(index, item);
        }
    }

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    static String remove(String item) throws NoSuchElementException{
        if(!contains(item)){
            throw new NoSuchElementException("Элемент не найден");
        } else {
            remove(item);
            return item;
        }
    }

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    static String remove(int index, String item) throws NoSuchElementException{
        if(!contains(item)){
            throw new NoSuchElementException("Элемент не найден");
        } else {
            remove(String.valueOf(index));
            return item;
        }
    }

    // Проверка на существование элемента.
    // Вернуть true/false;
    static boolean contains(String item){
        return contains(item);
    }

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    static int indexOf(String item){
        return indexOf(item);
    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    static int lastIndexOf(String item){
        return lastIndexOf(item);
    }

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    static String get(int index) throws IndexOutOfBoundsException{
        if(index > size()){
            throw new IndexOutOfBoundsException("Индекс больше диапазона");
        } else {
            return get(index);
        }
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    static boolean equals(StringList otherList) throws NullPointerException{
        if(otherList == null){
            throw new NullPointerException("Null не может быть передан");
        } else {
            return equals(otherList);
        }
    }

    // Вернуть фактическое количество элементов.
    static int size(){
        return size();
    }

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    static boolean isEmpty(){
        return isEmpty();
    }

    // Удалить все элементы из списка.
    static void clear(){
        clear();
    }

    static String[] toArray(String[] strings){
        return toArray(new String[0]);
    }
}
