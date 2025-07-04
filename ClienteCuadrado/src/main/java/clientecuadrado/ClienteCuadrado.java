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

             System.out.print("Ingresa tu nombre: ");
            String nombre = consola.readLine(); 
            writer.println(nombre); 
            String respuesta = reader.readLine(); 
            System.out.println("Respuesta del servidor: " + respuesta);
            
            System.out.print("Ingrese su numero: ");
            String numero = consola.readLine();
            writer.println(numero); 
            String respuestaNum = reader.readLine(); 
             System.out.println("Respuesta del servidor: " + respuestaNum);
            
            String fechaHora = reader.readLine();
            System.out.println("Respuesta del servidor: " + fechaHora);

            socket.close();
        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e);
        }
    }
           
            
        }
    

