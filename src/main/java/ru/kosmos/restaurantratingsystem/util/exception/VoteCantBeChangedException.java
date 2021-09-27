package ru.kosmos.restaurantratingsystem.util.exception;

public class VoteCantBeChangedException extends RuntimeException {
    public VoteCantBeChangedException(String message) {
        super(message);
    }
}
