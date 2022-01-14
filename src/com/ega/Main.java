package com.ega;
import java.util.Scanner;
import java.util.regex.*;
import java.util.*;
public class Main {
    public static boolean isValid(String email)
    {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[\\a-zA-Z]{2,6}";
        Pattern pattern = Pattern.compile(regex);
        if (email == null)
            return false;
        return pattern.matcher(email).matches();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name,email, pas, exit,logname,logpas;

///REGISTR
        System.out.println("Reģistrācija");
        //1. USER
        System.out.println("Lietotāja vārds:");

        while (!sc.hasNext()) {
            System.out.print("Šis lauks nedrīkst būt tukšs:");
            name = sc.nextLine();
        }


        //2. E-PASTS


        System.out.println("E-pasts:");
        email = sc.nextLine();
        boolean result = isValid(email);
        while(result == false) {
            System.out.println("Ievadiet korektu e-pastu:");
            email = sc.nextLine();
            result = isValid(email);

                 }


            //3. PAROLE
            System.out.println("Parole (vismaz 8 rakstzīmes):");
            pas = sc.next();
            while (pas.length()<8) {
                System.out.print("Vismaz 8 simboli:");
                pas = sc.next();
            }

                System.out.println("Apsveicu, Jūs esat veiksmīgi reģistrējies!");
                System.out.println();
                System.out.println();
///LOGIN
            System.out.println("Pieteikties");

            System.out.println("Lietotāja vārds:");
            logname = sc.nextLine();
            System.out.println("Parole:");
            logpas = sc.nextLine();
///PROFILE
            System.out.println("Esiet sveicināts savā profilā :) ");
///LOGOUT
            System.out.println("Vēlaties atslēgties? y/n");
        }
    }

