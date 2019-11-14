package dsa.utils;

import dsa.models.Item;
import dsa.models.User;
import org.apache.log4j.Logger;

import java.util.*;

public class GameManagerImp implements GameManager{
    /*Creamos la clase logger*/
    final static Logger log = Logger.getLogger(GameManagerImp.class.getName());

    //SINGLETON
    private static GameManager instance;
    /* Creamos atributos privados para implementar Singleton */
    //Todos los atributos que generen los metodos
    private HashMap<String, User> users;
    private List<Item> listItem;

    private GameManagerImp(){
        users = new HashMap<>();
    }

    /*El método de getInstance debe ser public*/
    public static GameManager getInstance(){
        if(instance==null){
            instance = new GameManagerImp();
        }
        return instance;
    }


    /*MÉTODOS*/
    public List<User> sortByName() {
        List<User>listaU = new LinkedList<>(this.users.values());
        log.info("Valor en lista"+listaU);
        Collections.sort(listaU, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return user.getSurname().compareTo(t1.getSurname());
            }
        });
        log.info("Lista ordenada "+listaU);
        return(listaU);

    }

    public void addUser(String id, String nombre, String apellido) {
        User u2 = new User(id, nombre, apellido);
        /*User result = users.get(u2);
        if (result == null) {
            */users.put(u2.getId(), u2);
            log.info("Añadido nuevo usuario "+users);
        /*} else {
            log.warn("The user " + u2.getName() + " existe");

        }*/
    }



    public void updateUser(User u) throws UserNotFoundException {
        User theUser = this.users.get(u);
        if (theUser != null) {
            this.users.remove(u.getId());
            log.info("Actualizado: " + theUser);
            this.users.put(u.getId(), u);
        } else {
            log.warn("El usuario no existe");
            throw new UserNotFoundException();

        }

    }

    public int sizeUsers(){
        log.info("Tamaño: " + this.users.size());
        return this.users.size();
    }


    public String seeUser(String aux2) {
        //Introducimos la clave y nos da la info
        User theUser = this.users.get(aux2);
        if (theUser != null) {
            String res = theUser.verInfo();
            log.info(res);
            return res;
        }else log.warn("Usuario no encontrado");
        return null;
    }



    public void addItemToUser(String id, Item i2) throws UserNotFoundException{
        User u1 =users.get(id);
            if (u1 != null) {
                u1.addItem(i2);
                log.info("Añadido "+i2+" a "+u1);
            }
            else{
                log.error("Usuario no existe");
                throw new UserNotFoundException();
            }

    }

    public String getObjectsUser(User u) throws UserNotFoundException{
        User aux = this.users.get(u.getId());
        if (aux != null){
            aux.getListObjects();
        }
        return null;
    }

    public int sizeItemListUser(User u) {
        int aux= 0;
        List<Item> listItem = u.getItemList();
        for (int i=0; i<listItem.size(); i++) {
            aux += listItem.get(i).getCantidad();
            log.info("Cantidad de objetos"+ aux);
        } return aux;
    }


    public void clear(){
        instance = null;
        this.users =null;
        this.listItem = null;
    }

    public HashMap<String, User> allUsers(){
        HashMap<String, User> ret = new HashMap<>();
        ret.putAll(this.users);

        return ret;
    }



}
