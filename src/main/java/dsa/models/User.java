package dsa.models;

import java.util.*;

public class User {
    private String id;
    private String name;
    private String surname;
    private LinkedList<Item> itemList;


    public User(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.itemList = new LinkedList();
        this.surname= surname;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LinkedList<Item> getItemList() {
        return itemList;
    }

    public String getListObjects(){
        return this.itemList.toString();
    }

    public void setItemList(LinkedList<Item> itemList) {
        this.itemList = itemList;
    }

    public void addItem(Item object1)
    {
        this.itemList.add(object1);
    }

    public String toString() {
        return this.name;
    }

    public String getId() {
        return id;
    }

    public void setId(String i){
        this.id=i;
    }
    public String verInfo(){
        return ("["+this.id+", "+this.name+", "+this.surname+"]");

    }
}
