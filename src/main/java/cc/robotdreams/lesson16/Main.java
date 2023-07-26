package cc.robotdreams.lesson16;

import cc.robotdreams.lesson16.exceptions.WrongAccountException;
import cc.robotdreams.lesson16.exceptions.WrongCurrencyException;
import cc.robotdreams.lesson16.exceptions.WrongOperationException;

public class Main
{
    static BankApplication bankApplication = new BankApplication();
    static int counter = 1;

    static public void main(String[] args) {

        processWrapper ("accountId000", 50, "USD");     //wrong account
        processWrapper ("accountId003", 250, "HRV");    //boundary positive value + random exception
        processWrapper ("accountId001", 50, "EUR");     //wrong currency
        processWrapper ("accountId001", 50, "USD");     //positive value + random exception
        processWrapper ("accountId001", 2000, "USD");   //wrong amount
    }

    static public void processWrapper (String id, int amount, String currency) {
        System.out.printf("Case %s: %s-%s-%s\n", counter++, id, amount, currency);

        try {
            bankApplication.process(id, amount, currency);
        } catch (WrongAccountException e) {
            System.out.println("Такого акаунту не існує");
        } catch (WrongCurrencyException e) {
            System.out.println("Акаунт має рахунок в іншій валюті");
        } catch (WrongOperationException e) {
            System.out.println("Акаунт не має достатньо коштів");
        } catch (Exception e) {
            System.out.println("Cталася помилка при процесінгу, спробуйте ще раз");
        } finally {
            System.out.println("Дякуємо, що скористалися нашим сервісом");
            System.out.println("---------------------------------------");
        }
    }
}
