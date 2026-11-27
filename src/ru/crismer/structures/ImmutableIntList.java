package ru.crismer.structures;

import java.util.Arrays;

public final class ImmutableIntList {
    private final int[] data;

    // Создает неизменяемый список из массива или независимых чисел.
    public ImmutableIntList(int... values) {
        if (values == null) throw new IllegalArgumentException("Массив не может быть null");
        this.data = values.clone();
    }

    // Создает неизменяемый список как копию другого списка.
    public ImmutableIntList(ImmutableIntList other) {
        if (other == null) throw new IllegalArgumentException("Список не может быть null");
        this.data = other.data.clone();
    }

    // Возвращает значение по проверенному индексу.
    public int get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        }
        return data[index];
    }

    // Возвращает новый список с замененным значением по индексу.
    public ImmutableIntList set(int index, int value) {
        if (index < 0 || index >= data.length) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
        }
        int[] newData = data.clone();
        newData[index] = value;
        return new ImmutableIntList(newData);
    }

    // Проверяет, что список не содержит ни одного элемента.
    public boolean isEmpty() {
        return data.length == 0;
    }

    // Возвращает количество хранящихся значений.
    public int size() {
        return data.length;
    }

    // Возвращает копию массива всех значений.
    public int[] toArray() {
        return data.clone();
    }

    // Сравнивает списки по всем хранящимся значениям.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ImmutableIntList other = (ImmutableIntList) obj;
        return Arrays.equals(data, other.data);
    }

    // Вычисляет хеш-код списка.
    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }

    // Формирует строковое представление списка в квадратных скобках.
    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}