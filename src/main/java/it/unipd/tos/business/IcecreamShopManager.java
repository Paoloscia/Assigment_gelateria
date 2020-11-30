////////////////////////////////////////////////////////////////////
// PAOLO SCIALPI 1161625
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import java.util.List;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;


public class IcecreamShopManager implements TakeAwayBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException
    {
        if (itemsOrdered.size() > 30)
        {
            throw new TakeAwayBillException("Errore, ordine superiore a 30 elementi.");   
        }
        else
        {
            return itemsOrdered.stream().mapToDouble(x -> x.getPrice()).sum();   
        }
    }
}