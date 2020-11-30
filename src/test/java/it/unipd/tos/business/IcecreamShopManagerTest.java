package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.itemType;
import it.unipd.tos.model.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IcecreamShopManagerTest {

    private IcecreamShopManager calculator = new IcecreamShopManager();
    private final User IO = new User("Scialpi", "Paolo", Date.valueOf("1998-12-01"));
    
    private ArrayList<MenuItem> itemsOrdered = new ArrayList<MenuItem>();

    private MenuItem Pinguino = new MenuItem(itemType.Gelati, "Pinguino", 4.50d);
    private MenuItem Cioccolata = new MenuItem(itemType.Gelati, "Cioccolata", 4.00d);
    private MenuItem Stracciatella = new MenuItem(itemType.Gelati, "Stracciatella", 4.50d);
    private MenuItem Coppa_Nafta = new MenuItem(itemType.Budini, "Coppa Nafta", 5.50d);
    private MenuItem Cola = new MenuItem(itemType.Bevande, "Cola", 3.00d);

    @Before
    public void reset_itemsOrdered() {
        itemsOrdered = new ArrayList<MenuItem>();
    }

    @Test
    public void subtotalTest() throws TakeAwayBillException
    {
    itemsOrdered.addAll(Arrays.asList(Pinguino, Coppa_Nafta, Cola));
    assertEquals(13.00d, calculator.getOrderPrice(itemsOrdered, IO), 0.00d);

    }
    
    @Test (expected = TakeAwayBillException.class)
    public void TakeAwayBillExceptionTest() throws TakeAwayBillException {
        itemsOrdered.addAll(Arrays.asList(Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino));
        calculator.getOrderPrice(itemsOrdered, IO);
    }
    
    @Test
        public void discount_more5icecreamTest() throws TakeAwayBillException{
        itemsOrdered.addAll(Arrays.asList(Pinguino, Cioccolata, Stracciatella, Pinguino, Stracciatella, Pinguino, Coppa_Nafta));
        assertEquals(30.00d, calculator.getOrderPrice(itemsOrdered, IO), 0.00d);
     }
}