import dsa.models.Item;
import dsa.models.User;
import dsa.utils.GameManagerImp;
import dsa.utils.GameManager;

import dsa.utils.UserNotFoundException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class TestImp {
    static GameManager p1;

    @Before
    public void setUp() throws UserNotFoundException {
        GameManager p1 = GameManagerImp.getInstance();

        Item i1;

        p1.addUser("1234", "Pedro", "Lopez");
        p1.addUser("1345","Juan", "Lopez");
        p1.addUser("1125","Ana", "Lopez");


        i1 = new Item("Escudo", 2);
        p1.addItemToUser("1234",i1);
        i1 = new Item("Arma", 1);
        p1.addItemToUser("1345",i1);
        i1 = new Item("Moneda", 4);
        p1.addItemToUser("1125",i1);




    }
    @After
    public void tearDown(){
        this.p1.clear();
    }
    @Test
    public void addUser1test(){
        User user1 = new User("1234", "Pedro", "Lopez");
        this.p1.addUser1(this.user1);

    }
    @Test
    public void addUserTest() {
        this.p1.addUser("1111", "Ignacio", "Lopez");
        Assert.assertEquals(4, this.p1.sizeUsers());
    }


    @Test
    public void seeUser() {
    }

    @Test
    public void addUser() {
    }

    @Test
    public void updateUser() {
    }


}
