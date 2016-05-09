/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author mikosty
 */
public class InOut implements IO {

    Scanner lukija = new Scanner(System.in);

    @Override
    public String annaSyote() {
        return lukija.nextLine();
    }

    @Override
    public void print(String string) {
        System.out.println(string);
    }

}
