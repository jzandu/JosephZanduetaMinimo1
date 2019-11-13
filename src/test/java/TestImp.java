import dsa.utils.InterfazImp;
import dsa.utils.Interfaz;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class TestImp {
    static Interfaz p1;

    @Before
    public void setUp() {

        Interfaz p1 = InterfazImp.getInstance();
    }

    @Test
    public static void tearDown(){
        p1 = null;
    }

    @Test(expected = StationFullException.class)
    public void testPrecio() throws Exception{
        List<Product> lsit1 = this.p1.sortPriceProducts();
        assertEquals(lsit1.get(0).getName(), "Botas de agua", "Botas de Agua");
        assertEquals(lsit1.get(1).getName(), "Caña de pescar", "Caña de pescar");
        assertEquals(lsit1.get(2).getName(), "Mapa", "Mapa");

    }

    @Test
    public void testBikesByStation() throws Exception {


    }catch() log.error()
}
