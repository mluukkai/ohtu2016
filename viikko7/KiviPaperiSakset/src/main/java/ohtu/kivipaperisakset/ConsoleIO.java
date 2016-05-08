/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;


public class ConsoleIO implements IO{
    private final Scanner scanner;

   
    public ConsoleIO() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public void print(String msg) {
        System.out.print(msg);
    } 
}
