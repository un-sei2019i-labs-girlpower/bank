package com.example.bank_app;

import com.example.bank_app.BusinessLogic.SendMoneyController;
import com.example.bank_app.Presentation.MainActivity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {

        assertTrue(SendMoneyController.verify_Amoun_p(100.,50));
    }

}