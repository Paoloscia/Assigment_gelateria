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
    private MenuItem Coppa_Nafta = new MenuItem(itemType.Budini, "Coppa Nafta", 5.50d);
    private MenuItem Cola = new MenuItem(itemType.Bevande, "Cola", 3.00d);


    @Test
    public void getOrderPriceTest() throws TakeAwayBillException
    {
	itemsOrdered.addAll(Arrays.asList(Pinguino, Coppa_Nafta, Cola));
	assertEquals(13.00d, calculator.getOrderPrice(itemsOrdered, IO), 0.00d);

    }
}