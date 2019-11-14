package dsa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

public class Item implements Comparable<Item>{
        //Attributes
        String name;
        int cantidad;

        /*@JsonIgnore
        @ApiModelProperty(hidden = true)
        LinkedList<Clase2> bikesused;*/

        //Empty constructor for json deserializer
        public Item(){

        }

        //Constructor
        public Item(String name, int cantidad) {
           // this.idUser = idUser;
            this.name = name;
            this.cantidad = cantidad;

        }
    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void addItem(String name, int cantidad){
            Item i2 = new Item( name,cantidad);
    }

        //añadir User, añadir...
        @Override
        public int compareTo(Item e2) {
            return this.name.compareTo(e2.name);
        }
    @Override
    public String toString() {
        return "Objeto [Name = " + name + ", cantidad = " + cantidad + "]";
    }
}
