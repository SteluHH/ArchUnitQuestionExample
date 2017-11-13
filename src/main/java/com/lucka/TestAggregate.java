package com.lucka;

public class TestAggregate extends Entity {

    public void call() {
        throw new ForbiddenException();
    }
}
