package com.howtographql.hackernews;

public class Person {

    private final String id;
    private final String name;
    private final String occupation;


    public Person(String name, String occupation) {
        this(null, name, occupation);
    }

    public Person(String id, String name, String occupation) {
        this.id = id;
        this.name = name;
        this.occupation = occupation;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

}
