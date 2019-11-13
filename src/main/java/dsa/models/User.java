package dsa.models;

import java.util.*;

public class User {
    public String name;
    public String id;
    List<Clase1> historical;

    //Empty constructor for json deserializer
    public User(){

    }

    public User(String name, String id) {
        this.name = name;
        this.historical = new LinkedList<>();
        this.id= id;
    }

    public void addHistorical(Clase1 order)
    {
        this.historical.add(order);
    }
    public String toString() {
        return this.name;
    }
}
