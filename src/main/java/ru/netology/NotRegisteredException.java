package ru.netology;

public class NotRegisteredException extends IllegalArgumentException{
        public NotRegisteredException(String s) {
            super(s);
        }
}
