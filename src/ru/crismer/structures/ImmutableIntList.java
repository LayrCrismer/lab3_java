package src.ru.crismer.structures;

import java.util.Arrays;

public class ImmutableIntList {
    private final int[] data;

    public ImmutableIntList(int... values) {
        if (values == null) throw new IllegalArgumentException("Массив не может быть null");
        this.data = values.clone();
    }

    public ImmutableIntList(ImmutableIntList other) {
        if (other == null) throw new IllegalArgumentException("Список не может быть null");
        this.data = other.data.clone();
    }

    public int get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        }
        return data[index];
    }

    public ImmutableIntList set(int index, int value) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        }
        int[] newData = data.clone();
        newData[index] = value;
        return new ImmutableIntList(newData);
    }

    public boolean isEmpty() {
        return data.length == 0;
    }

    public int size() {
        return data.length;
    }

    public int[] toArray() {
        return data.clone();
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}