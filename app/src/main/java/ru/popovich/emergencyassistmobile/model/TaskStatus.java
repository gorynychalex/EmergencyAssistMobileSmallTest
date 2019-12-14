package ru.popovich.emergencyassistmobile.model;

public enum TaskStatus {

    NEW("Новый"),

    PROCESSING("Выполняется"),

    PENDING("В ожидании"),

    SOLVED("Решено"),

    CLOSED("Закрыто");

    private String s;

    TaskStatus(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }
}
