package it.unipd.tos.model;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void User_Test()
    {
        LocalDate Nascita = LocalDate.of(1998,12,01);
        User utente = new User("Prova", "Riprova", Nascita);
        assertEquals("Prova", utente.getSurname());
        assertEquals("Riprova", utente.getName());
        assertEquals(Nascita, utente.getDataDiNascita());
    }
    
    @Test
    public void User_Equal_Hash_Test()
    {
        LocalDate Nascita = LocalDate.of(1998,12,01);
        User utente = new User("Prova", "Riprova", Nascita);
        assertEquals(255150423, utente.hashCode());
        assertTrue(utente.equals(utente));
        assertFalse(utente.equals(null));
    }
}