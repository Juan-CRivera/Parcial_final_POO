/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package clientecuadrado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author David Ventura
 */

public class ClienteCuadrado {

    public static void main(String[] args) {
       try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Conectado al servidor en el puerto 5000.");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(outputStream, true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            
            
            
            
            

            
        } catch (IOException e) {
            
        }
    }
}
