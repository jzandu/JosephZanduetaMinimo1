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
    //private List<User> listaU;
    private List<Item> listItem;

    private GameManagerImp(){
        u1 = new User();
        listItem = new LinkedList<Item>();
        users = new HashMap<String, User>();
        listItem = new LinkedList<Item>();
        //listaU = new ArrayList<User>(users.values());
    }

    /*El método de getInstance debe ser public*/
    public static GameManager getInstance(){
        if(instance==null){
            instance = (GameManager) new GameManagerImp();
        }
        return instance;
    }

    public void clear(){
        this.instance = null;
    }


    /*MÉTODOS*/
    public void addItem(Item i2){
        this.listItem.add(i2);
    }

    public List<User> sortByName() {
        List<User>listaU = new ArrayList<User>(users.values());
        Collections.sort(listaU, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return user.getName().compareTo(t1.getName());
            }
        });
        log.info(listaU);
        return(listaU);

    }
    @Override
    public int sizeUsers(){
        log.info("Tamaño: " + this.users.size());
        return this.users.size();
    }

    @Override
    public List<User> seeUser(User aux2) {
        //Introducimos la clave y nos da la info
        User theUser = this.users.get(aux2);
        ArrayList res = new ArrayList(Collections.singleton(theUser.getName() + theUser.getSurname()));
        log.info(res);
        return res;
    }

    @Override
    public void addUser(User u2) {
        User result = users.get(u2);
        log.info(result);
        if (result == null) {
            users.put(u2.getId(), u2);
            log.info("Añadido nuevo usuario "+users);
        } else {
            log.warn("The user " + u2.getName() + " existe");

        }
    }
    @Override
    public void updateUser(User u) throws UserNotFoundException {
        User theUser = this.users.get(u);
        if(theUser!=null){
            log.info("Actualizado: " + theUser);
            addUser(u);
        }
        else {
            log.warn("El usuario no existe");
            throw new UserNotFoundException();

    }

    }



}
