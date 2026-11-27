package ru.crismer.geometry;

class PackageVisibilityDemo {
    private final String value = "package-private";

    // Возвращает значение для демонстрации видимости внутри пакета.
    String getValue() {
        return value;
    }
}
