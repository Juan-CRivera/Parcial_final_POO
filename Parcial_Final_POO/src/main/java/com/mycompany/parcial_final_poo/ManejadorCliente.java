/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcial_final_poo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author juank
 */
public class ManejadorCliente implements Runnable {
    private Socket socketCliente;

    public ManejadorCliente(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }
    @Override
    public void run() {
        try {
            InputStream inputStream = socketCliente.getInputStream();
            OutputStream outputStream = socketCliente.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);

            String nombre = reader.readLine();
            String numero = reader.readLine();
            
             System.out.println("Cliente " + nombre + " conectado.");
            
            System.out.println("Nombre recibido: " + nombre);
            System.out.println("Numero recibido:" + numero);
            
            writer.println("Bienvenido, " + nombre + "!");
            
           try {
                int numeroStr = Integer.parseInt(numero);
                int cuadrado = numeroStr * numeroStr;
                writer.println("El cuadrado de " + numero + " es: " + cuadrado);
            } catch (NumberFormatException e) {
                writer.println("Error: el número ingresado no es válido.");
            }

            
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            writer.println("Fecha y hora del servidor: " + ahora.format(formato)); 
            
            socketCliente.close();
        } catch (IOException e) {
            System.out.println("Error con cliente: " + e);
        }
    }
}
