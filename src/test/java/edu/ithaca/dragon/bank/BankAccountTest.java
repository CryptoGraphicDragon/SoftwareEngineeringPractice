package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid("a@b.com"));
        assertTrue(BankAccount.isEmailValid("a@b.edu"));
        assertTrue(BankAccount.isEmailValid("a.c@b.edu"));
        assertTrue(BankAccount.isEmailValid("a-c@b.edu"));
        assertTrue(BankAccount.isEmailValid("a_c@b.edu"));
        assertTrue(BankAccount.isEmailValid("a+c@b.edu"));
        assertTrue(BankAccount.isEmailValid("123@b.edu"));
        assertTrue(BankAccount.isEmailValid("a12c@b.edu"));

        assertFalse(BankAccount.isEmailValid(""));
        assertFalse(BankAccount.isEmailValid("apple.com"));
        assertFalse(BankAccount.isEmailValid("apple"));
        assertFalse(BankAccount.isEmailValid("a.b.com"));
        assertFalse(BankAccount.isEmailValid("a@b"));
        assertFalse(BankAccount.isEmailValid("a@b..com"));
        assertFalse(BankAccount.isEmailValid("a@b@com"));
        assertFalse(BankAccount.isEmailValid("a@b.web"));
        assertFalse(BankAccount.isEmailValid(".a@b.com"));
        assertFalse(BankAccount.isEmailValid("#@%$^&%@^*&.com"));
        assertFalse(BankAccount.isEmailValid("@b.com"));
        assertFalse(BankAccount.isEmailValid("a@@b.com"));
        assertFalse(BankAccount.isEmailValid("a.@b.com"));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}