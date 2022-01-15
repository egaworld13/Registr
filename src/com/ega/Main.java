package com.ega;
import java.util.Objects;// automātiski pie datu salīdzinājuma 62. rind piedāvāja obj, "!=" vietā.
import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;
public class Main {
    public static boolean isValid(String email)
    {//Regulārā izteiksme "regex" tiek kompilēta šablonā,ar kura salīdzina lietotāja ievadīto e-pastu
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[\\a-zA-Z]{2,6}";
        Pattern pattern = Pattern.compile(regex); //izveido šablonu
        if (email == null)//Tiek salīdzināta ievadītais epasts ar šablonu.
            return false;// nesakrīt,atgriež false
        return pattern.matcher(email).matches();//Sakrīt, atgriež true,jeb ievadi?
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> dati = new ArrayList<>();// izveidots array list, kur glabāsies ievadītie lietotāja dati

        do{                                     //veido ciklu, kur lietotājam ir iespēja veidot jaunu profilu.
                   dati.clear();                       //izdzēš datus no array. Lai,kad tiks veidots jauns profils, iepriekšējie ieraksti netraucētu.
///REGISTR
        System.out.println("Reģistrācija");
        //1. USER
            System.out.println("Lietotāja vārds:");
                String name =sc.nextLine();
            while(name.length()<3){             // Minumums 3 simboli, kamēr tas nebūs, cikls turpināsies.
                System.out.println("Vismaz 3 rakstzīmes:");
                name = sc.nextLine();}

                   dati.add(name);              //ierakstam array listē kā pirmo(0)

            //2. E-PASTS
            System.out.println("E-pasts:");
                String email = sc.nextLine();
            boolean result = isValid(email);      //salīdzina result ar šablonu un sniedz atpakaļ atbildi: true, ja ievade atbilst šablonam.
            while(!result) {                      // Kamēr rezultāts not true (viens no pieraksta veidiem "!" cikls turpinās
            System.out.println("E-pasts:");
                email = sc.nextLine();              // atkārtota ievade
                result = isValid(email); }          //salīdzina iekš cikla.

                    dati.add(email);                            //ierakstam array listē kā otro(1)

            //3. PAROLE
            System.out.println("Parole (vismaz 8 rakstzīmes):");
                String pas = sc.next();
            while (pas.length()<8){
                System.out.print("Vismaz 8 simboli:");
                    pas = sc.next();}

                    dati.add(pas);                       //ierakstam array listē kā trešo(2)

                System.out.println("Apsveicu, Jūs esat veiksmīgi reģistrējies!");
                System.out.println();
                System.out.println();
/////LOGIN
            System.out.println("Pieteikties");
                System.out.println("Lietotāja vārds:");
                    String logname = sc.nextLine();
                    sc.nextLine();
                 System.out.println("Parole:");
                     String logpas = sc.nextLine();
            while(!Objects.equals(logname, dati.get(0)) && !Objects.equals(logpas, dati.get(2))){ //pārbauda vai ievadītais lietotāja v. un parole sakrīt ar Reģistrācijā norādītiem.
                System.out.println("Ievadītie dati nekorekti, mēģini vēlreiz:");    //while cikls turpinās kamēr dati nesakrīt!
                System.out.println("Lietotāja vārds:");
                     logname = sc.nextLine();
                System.out.println("Parole:");
                     logpas = sc.nextLine();
            }
/////PROFILE
                 System.out.println("Esiet sveicināts savā profilā :) ");
                 System.out.println("Jūsu dati: ");
                 System.out.println("Lietotājvārds: "+dati.get(0) );  // izvada datus no array
                 System.out.println("Epasts: "+dati.get(1) );
                 System.out.println("Parole: "+dati.get(2) );
/////LOGOUT
                System.out.println();
                System.out.println("Vēlaties iziet no sistēmas? y/n");
                String exit = sc.nextLine();
                switch (exit) {
                    case "y":   // cikls noslēgsies
                        return;
                    case "n":   //Piedāvās izveidot jaunu lietotāju
                        System.out.println("Vēlaties iziet un izveidot jaunu profilu? y/n");
                        String opt = sc.nextLine();
                       dati.add(opt);   //ieraksta y/n izvēli array, lai zemāk norādītā "while" būtu ar ko salīdzināt.
                             }
                }
        while (dati.get(3).equals("y"));    // kopā ar "do" veido ciklu, kur lietotājam ir iespēja veidot jaunu profilu.
    }
}


