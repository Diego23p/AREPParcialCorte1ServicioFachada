/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

/**
 *
 * @author Diego23p
 */
public class Client {
    
    public static void main( String[] args ) throws IOException {
        BufferedReader in = null;
        
        URL herokuApp = new URL("https://still-hamlet-80792.herokuapp.com/results?numbers=tan-1");
        
        URLConnection con = herokuApp.openConnection();
        
        in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		
	System.err.println("Conectado");
	BufferedReader stdIn = new BufferedReader(
	new InputStreamReader(System.in));
	String line;
        
        JSONObject myObject = new JSONObject();
        
	while ((line = in.readLine()) != null) { 
            System.out.println(line);
            String aux = line.replace("{\"resultado\":","").replace("}","");
            myObject.put("Resultado", aux);
	}
	
	in.close();
	stdIn.close();
    }
    
}
