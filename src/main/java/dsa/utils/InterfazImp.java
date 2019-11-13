package dsa.utils;

import dsa.models.Clase1;
import dsa.models.User;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class InterfazImp {
    /*Creamos la clase logger*/
    final static Logger log = Logger.getLogger(InterfazImp.class.getName());

    //SINGLETON
    private static Interfaz instance;
    /* Creamos atributos privados para implementar Singleton */
    //Todos los atributos que generen los metodos
    private HashMap<String, Clase1> users;

    private InterfazImp(){
        /*numstations = 0;
        arrayStations = new Station[S];
        bikesStation = new LinkedList<>();
        bikesUser = new LinkedList<>();
        users = new HashMap<>();*/
        
    }

    /*El método de getInstance debe ser public*/
    public static Interfaz getInstance(){
        if(instance==null){
            instance = (Interfaz) new InterfazImp();
        }
        return instance;
    }


    /*MÉTODOS*/

    class SortByPrice implements Comparator<Product> {
        public int compare(Product o, Product p) {
            return (int) (p.getPrice() - o.getPrice());
        }
    }

    class SortBySells implements Comparator<Product> {
        public int compare(Product o, Product p) {
            return (int) (p.getSales() - o.getSales());
        }
    }

    public List<Product> sortPriceProducts() {
        Collections.sort(this.store, new SortByPrice());
        log.info(this.store);
        return(this.store);
    }
}
