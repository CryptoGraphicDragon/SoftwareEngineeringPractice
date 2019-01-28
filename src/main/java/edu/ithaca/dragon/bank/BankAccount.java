package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public static boolean isAmountValid(double amount){
        if(amount<0){
            return false;
        } else if ((amount*100)%1!=0){
            return false;
        } else {
            return true;
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount)  {
        if(balance>=amount && amount>=0) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Amount to withdraw is invalid");
        }
    }


    public static boolean isEmailValid(String email){
        int count =0;
        int count2=0;
        char check= '@';
        char check2= '.';
        for(int i=0; i<email.length(); i++){
            if(email.charAt(i) == check){
                count++;
            }
            if(email.charAt(i) == check2 && email.charAt(i+1)== check){
                count2++;
            }
        }
        if(count>1 || count2>0){
            return false;
        }

        if (email.indexOf('@') == -1 || email.indexOf('@') == 0){
            return false;
        } else if (email.length()<=4) {
            return false;
        } else if(email.indexOf('!') != -1 || email.indexOf('#') != -1 || email.indexOf('$') != -1 || email.indexOf('%') != -1 || email.indexOf('^') != -1 || email.indexOf('*') != -1 || email.indexOf('&') != -1){
            return false;
        }else if (email.indexOf('.')==0) {
            return false;
        } else if (!(email.substring(email.length()-4).equals(".com")) && !(email.substring(email.length()-4).equals(".edu"))){
            return false;
        } else if((email.substring(email.length()-5).equals("..com")) || (email.substring(email.length()-5).equals("..edu"))){
            return false;
        } else {
            return true;
        }
    }
}
