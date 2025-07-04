/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parcial_final_poo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author LENOVO
 */
public class Parcial_Final_POO {

    public static void main(String[] args) {
       try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Servidor esperando conexiones en puerto 5000...");

            while (true) {
                Socket socketCliente = serverSocket.accept();
                System.out.println("Cliente conectado desde: " + socketCliente.getInetAddress());
                new Thread(new ManejadorCliente(socketCliente)).start();
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e);
        }
    }
    }

