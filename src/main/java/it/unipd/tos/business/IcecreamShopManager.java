////////////////////////////////////////////////////////////////////
// PAOLO SCIALPI 1161625
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import java.util.List;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.itemType;
import it.unipd.tos.model.User;


public class IcecreamShopManager implements TakeAwayBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered, User user) throws TakeAwayBillException
    {
        return subtotal(itemsOrdered) - discount_more5icecream(itemsOrdered);
    }

    double subtotal(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        if (itemsOrdered.size() > 30)
        {
            throw new TakeAwayBillException("Ordine superiore a 30 elementi");   
        }
        else
        {
            return itemsOrdered.stream().mapToDouble(x -> x.getPrice()).sum();   
        }
    }

    double discount_more5icecream(List<MenuItem> itemsOrdered) {
        if (itemsOrdered.stream().filter(s -> s.getItemType() == itemType.Gelati).count() > 5) {
            return (itemsOrdered.stream().filter(s -> s.getItemType() == itemType.Gelati).mapToDouble(d -> d.getPrice())
                    .min().orElse(0.00)) / 2.0;
        }
        return 0.0;
    }
}