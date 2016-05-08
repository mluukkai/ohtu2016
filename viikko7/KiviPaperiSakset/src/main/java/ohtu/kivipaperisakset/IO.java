/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

public interface IO {

    /**
     * Reads a line of text from the user.
     * 
     * @return Input text from the user as a String
     */
    String readLine();

    /**
     * Prints a message to the output
     * 
     * @param msg A String message to be printed
     */
    void print(String msg);
}
