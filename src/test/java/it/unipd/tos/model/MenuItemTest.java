package it.unipd.tos.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuItemTest {

    @Test
    public void MenuItem_Test()
    {
        MenuItem item = new MenuItem(MenuItem.itemType.Gelati, "Pistacchio", 3.0D);
        assertEquals(MenuItem.itemType.Gelati, item.getItemType());
        assertEquals("Pistacchio", item.getName());
        assertEquals(3.0D, item.getPrice(), 0);
    }
}