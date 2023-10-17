package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            Socket socket = new Socket("localhost", 3000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connessione effettuata.");
            Scanner input = new Scanner(System.in);
            int num;
            int var;
            do{
                System.out.println("Inserisci numero: ");
                num = input.nextInt();
                input.nextLine();
                out.writeBytes(num+"\n");
                var = Integer.parseInt(in.readLine());
                if(var == 1){
                    System.out.println("Il numero e' troppo piccolo, riprova\n");
                }
                if(var == 2){
                    System.out.println("Il numero e' troppo grande, riprova\n");
                }
            }while(var != 3);

            if(var == 3){
                System.out.println("Hai indovinato il numero");
                num = Integer.parseInt(in.readLine());
                System.out.println(" con un numero di " + num + " tentativi");
            }

            socket.close();

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
