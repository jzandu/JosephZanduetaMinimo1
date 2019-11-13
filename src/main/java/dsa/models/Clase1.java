package dsa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import sun.awt.image.ImageWatched;

public class Clase1 {
        //Attributes
        String idUser;
        String name;
        String surname;

        @JsonIgnore
        @ApiModelProperty(hidden = true)
        LinkedList<Clase2> bikesused;

        //Empty constructor for json deserializer
        public Clase1(){

        }

        //Constructor
        public Clase1(String idUser, String name, String surname) {
            this.idUser = idUser;
            this.name = name;
            this.surname = surname;
            this.bikesused = new LinkedList();
        }

        //Getters and setters


        //añadir User, añadir...
        @Override
        public int compareTo(Product e2) {
            return this.name.compareTo(e2.name);
        }
        public String toString() {
        return this.name;
    }
}
