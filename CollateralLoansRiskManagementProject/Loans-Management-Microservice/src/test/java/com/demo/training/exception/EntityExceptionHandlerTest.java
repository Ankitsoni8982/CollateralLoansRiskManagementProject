package com.demo.training.exception;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.request.WebRequest;

import com.demo.training.exception.EntityExceptionHandler;
import com.demo.training.exception.LoanNotFoundException;


/**
 * @Test EntityExceptionHandler Class
 * @author POD-6
 */
@SpringBootTest
public class EntityExceptionHandlerTest {

    @Test
    public void testEntityException(){
      WebRequest web = null;
      LoanNotFoundException loan = new LoanNotFoundException("Loan Not Found");
      EntityExceptionHandler exp = new EntityExceptionHandler();
      assertEquals(500, exp.handleAnyException(loan, web).getStatusCodeValue());
    }

}
