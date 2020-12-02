package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.itemType;
import it.unipd.tos.model.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IcecreamShopManagerTest {

    private IcecreamShopManager calculator = new IcecreamShopManager();
    private final User IO = new User("Scialpi", "Paolo", LocalDate.of(1998,12,01));
    
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
    assertEquals(13.00d, calculator.getOrderPrice(itemsOrdered, IO, LocalTime.of(10,0,0)), 0.00d);

    }
    
    @Test (expected = TakeAwayBillException.class)
    public void TakeAwayBillExceptionTest() throws TakeAwayBillException {
        itemsOrdered.addAll(Arrays.asList(Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino, Pinguino));
        calculator.getOrderPrice(itemsOrdered, IO, LocalTime.of(10,0,0));
    }
    
    @Test
        public void discount_more5icecreamTest() throws TakeAwayBillException{
        itemsOrdered.addAll(Arrays.asList(Pinguino, Cioccolata, Stracciatella, Pinguino, Stracciatella, Pinguino, Coppa_Nafta));
        assertEquals(30.00d, calculator.getOrderPrice(itemsOrdered, IO, LocalTime.of(10,0,0)), 0.00d);
     }
    
	@Test
	public void discount_more50eurosTest() throws TakeAwayBillException{
		itemsOrdered.addAll(Arrays.asList(Cola, Cola, Cola, Cola, Cola, Cola, Cola, Cola, Cola, Cola, Cola, Cola, Cola, Cola, Cola, Cola, Cola, Cola, Cola, Cola));
		assertEquals(54.00d, calculator.getOrderPrice(itemsOrdered, IO, LocalTime.of(10,0,0)), 0.00d);
	}
	
    @Test
    public void commissionTest() throws TakeAwayBillException {
        itemsOrdered.addAll(Arrays.asList(Cola, Cola, Cola));
        assertEquals(9.50d, calculator.getOrderPrice(itemsOrdered, IO, LocalTime.of(10,0,0)), 0.00d);
    }

    @Test
 public void regaloGelatiTest() throws TakeAwayBillException
    {
    	IcecreamShopManager manager = new IcecreamShopManager();
    	itemsOrdered.addAll(Arrays.asList(Pinguino));
        List<User> utenti = Arrays.asList(
                new User("Scialpi", "Giorgio", LocalDate.now().minusYears(16)),
                new User("Utente", "Maggiorenne", LocalDate.now().minusYears(20)),
                new User("Scialpi", "Giovanni", LocalDate.now().minusYears(15)),
                new User("Scialpi", "Romano", LocalDate.now().minusYears(20)),
                new User("Scialpi", "Chiara", LocalDate.now().minusYears(16)),
                new User("Scialpi", "Camilla", LocalDate.now().minusYears(16)),
                new User("Scialpi", "Prova", LocalDate.now().minusYears(16)),
                new User("Scialpi", "Milarop", LocalDate.now().minusYears(16)),
                new User("Prova", "ERiprova", LocalDate.now().minusYears(16)),
                new User("Romanato", "Andrea", LocalDate.now().minusYears(16)),
                new User("Scanferla", "Andreini", LocalDate.now().minusYears(16)),
                new User("Scanferla", "Andreone", LocalDate.now().minusYears(16)),
                new User("Scanferla", "Andr", LocalDate.now().minusYears(16)),
                new User("Scanferla", "Anoby", LocalDate.now().minusYears(16)),
                new User("Scanferla", "Roby", LocalDate.now().minusYears(16))
        		);

        int OrdiniRegalati = 0;
        for(User user : utenti) {
            double prezzo = manager.getOrderPrice(itemsOrdered, user, LocalTime.of(18,0,0));
            if(prezzo == 0)
            	OrdiniRegalati++;
            if(user.getName() == "Maggiorenne" && user.getSurname() == "Utente") {assertTrue (prezzo==5.0d);}
        }
        assertTrue(OrdiniRegalati <= 10 && OrdiniRegalati > 0);
}
}
