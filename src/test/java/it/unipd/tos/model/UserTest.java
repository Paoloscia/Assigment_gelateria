package it.unipd.tos.model;

import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void User_Test()
    {
        User utente = new User("Prova", "Riprova", Date.valueOf("1998-12-01"));
        assertEquals("Prova", utente.getSurname());
        assertEquals("Riprova", utente.getName());
        assertEquals(Date.valueOf("1998-12-01"), utente.getDataDiNascita());
    }
}