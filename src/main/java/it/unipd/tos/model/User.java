////////////////////////////////////////////////////////////////////
// PAOLO SCIALPI 1161625
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import java.time.LocalDate;
import java.util.Objects;

public class User {

    private final String surname, name;
    private final LocalDate Nascita;

    public User(String surname, String name, LocalDate Nascita) {
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

    public LocalDate getDataDiNascita() {
        return Nascita;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return surname.equals(user.surname) && name.equals(user.name) && Nascita.equals(user.Nascita);
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(surname, name, Nascita);
    }
}

