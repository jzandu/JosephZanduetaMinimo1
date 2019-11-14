import dsa.models.Item;
import dsa.models.User;
import dsa.utils.GameManagerImp;
import dsa.utils.GameManager;

import dsa.utils.UserNotFoundException;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.assertEquals;


public class TestImp {

    //private GameManager p1 --------- Es lo que daba error
    GameManager p1;

    @Before
    public void setUp() throws UserNotFoundException {

        p1 = GameManagerImp.getInstance();

        Item i1;

        p1.addUser("1234", "Pedro", "Zaranjuez");
        p1.addUser("1345","Juan", "Polonesa");
        p1.addUser("1125","Ana", "Aviles");


        i1 = new Item("Escudo", 2);
        p1.addItemToUser("1234",i1);
        i1 = new Item("Arma", 1);
        p1.addItemToUser("1345",i1);





    }
    @After
    public void tearDown(){
        p1.clear();
    }

    @Test
    public void sortByName() {
        List<User> list1 = new LinkedList<>();
        list1=this.p1.sortByName();
        assertEquals(list1.get(0).getSurname(), "Aviles", "Aviles");
        assertEquals(list1.get(1).getSurname(), "Polonesa", "Polonesa");
        assertEquals(list1.get(2).getSurname(), "Zaranjuez", "Zaranjuez");

    }


    @Test
    public void addUserTest() {
        p1.addUser("1111", "Ignacio", "Lopez");
        Assert.assertEquals(4, this.p1.sizeUsers());
    }


    @Test
    public void itemUserTest() throws UserNotFoundException {
        Item i1 = new Item("Moneda", 4);
        User uf = new User("1","Joseph","Zandueta");
        p1.sizeItemListUser(uf);


    }



}
