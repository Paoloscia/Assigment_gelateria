package it.unipd.tos.business.exception;

import org.junit.Test;

import static org.junit.Assert.*;

public class TakeAwayBillExceptionTest {

    @Test
    public void TakeAwayBillException_Test()
    {
        TakeAwayBillException expection = new TakeAwayBillException("Ordine superiore a 30 elementi");
        assertEquals("Ordine superiore a 30 elementi", expection.getError());
    }
}