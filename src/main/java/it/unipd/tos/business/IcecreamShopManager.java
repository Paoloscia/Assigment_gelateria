////////////////////////////////////////////////////////////////////
// PAOLO SCIALPI 1161625
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItem.itemType;
import it.unipd.tos.model.User;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class IcecreamShopManager implements TakeAwayBill {

    private List<User> users = new ArrayList<>();

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered, User user, LocalTime time) throws TakeAwayBillException
    {
        return (subtotal(itemsOrdered) - discount_more5icecream(itemsOrdered) - discount_more50euros(itemsOrdered) + commission(itemsOrdered)) *ordineRegalato(user,time);
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
    
    double discount_more50euros(List<MenuItem> itemsOrdered)
    {
        double partial = itemsOrdered.stream().mapToDouble(d -> d.getPrice()).sum();
        if(partial > 50.0)
        {
            return partial * 0.1;
        }
        return 0.0;
    }
    
    double commission(List<MenuItem> itemsOrdered)
    {
        return itemsOrdered.stream().mapToDouble(d -> d.getPrice()).sum() < 10.0 ? 0.5 : 0.0;
    }

    double ordineRegalato(User user, LocalTime time)
    {
        if(users.size() >= 10 || time.getHour() != 18) {
            return 1.0;
        }

        if((18 >= (ChronoUnit.YEARS.between(user.getDataDiNascita(), LocalDate.now()))) && Math.random() < 0.5D) {
            if(!users.contains(user)) {
                users.add(user);
                return 0.0;
            }
        }
        return 1.0;
    }
}