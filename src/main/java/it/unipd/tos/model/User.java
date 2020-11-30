////////////////////////////////////////////////////////////////////
// PAOLO SCIALPI 1161625
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import java.util.Date;

public class User {

    private final String surname, name;
    private final Date Nascita;

    public User(String surname, String name, Date Nascita) {
        this.surname = surname;
        this.name = name;
    this.Nascita = Nascita;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDataDiNascita() {
        return Nascita;
    }
}

