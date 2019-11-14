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
    private User u1;
    private Item i1;
    private HashMap<String, User> users;
    private List<Item> listItem;

    private GameManagerImp(){
        u1 = new User();
        users = new HashMap<>();
        listItem = new LinkedList<Item>();
    }

    /*El método de getInstance debe ser public*/
    public static GameManager getInstance(){
        if(instance==null){
            instance = new GameManagerImp();
        }
        return instance;
    }

    public void clear(){
        this.instance = null;
        this.users.clear();
        this.listItem.clear();
    }

    @Override
    public int sizeItemListUser() {
        int aux= 0;
        for (int i=0; i<this.listItem.size(); i++) {
            aux += this.listItem.get(i).getCantidad();
        } return aux;
    }


    /*MÉTODOS*/
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

    @Override
    public String getObjectsUser(User u) throws UserNotFoundException{
        User aux = this.users.get(u.getId());
        if (aux != null){
            aux.getListObjects();
        }


        return null;
    }

    public List<User> sortByName() {
        List<User>listaU = new LinkedList<>(this.users.values());
        log.info("Valor en lista"+listaU);
        Collections.sort(listaU, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return user.getName().compareTo(t1.getName());
            }
        });
        log.info("Lista ordenada "+listaU);
        return(listaU);

    }
    @Override
    public int sizeUsers(){
        log.info("Tamaño: " + this.users.size());
        return this.users.size();
    }

    @Override
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
    public void addUser1(User u1){
        this.users.put(u1.getId(), u1);
        log.info("Añadido nuevo usuario "+users);
    }
    @Override
    public void addUser(String id, String nombre, String apellido) {
        User u2 = new User(id, nombre, apellido);
        this.users.put(u2.getId(),u2);
        /*User result = users.get(u2);
        if (result == null) {
            users.put(u2.getId(), u2);
            log.info("Añadido nuevo usuario "+users);
        } else {
            log.warn("The user " + u2.getName() + " existe");

        }*/
    }
    @Override
    public void updateUser(User u) throws UserNotFoundException {
        User theUser = this.users.get(u);
        if(theUser!=null){
            this.users.remove(u.getId());
            log.info("Actualizado: " + theUser);
            this.users.put(u.getId(), u);
        }
        else {
            log.warn("El usuario no existe");
            throw new UserNotFoundException();

    }

    }



}
