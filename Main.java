package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {

        // Leer archivo de nombres comunes
        String strLine = "";
        ArrayList <String> listaNombresComunes = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("names.txt"));
            while(strLine != null) {
                strLine = reader.readLine();
                if(strLine == null) {
                    break;
                }
                Arrays.toString(listaNombresComunes.toArray());
                listaNombresComunes.add(strLine);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lógica programa:
        String name = "José María Martinez";
        int start = name.indexOf(' ');
        int end = name.lastIndexOf(' ');

        String firstName = "";
        String middleName = "";
        String lastName = "";

        if (start >= 0) {
            firstName = name.substring(0, start);
            if (end > start)
                middleName = name.substring(start + 1, end);
                lastName = name.substring(end + 1, name.length());

                for (String nombreComun: listaNombresComunes) {
                    if(Objects.equals(nombreComun, firstName + " " + middleName)){
                        firstName = firstName + " " + middleName;
                        middleName = lastName;
                        lastName = "";
                    }
                }
        }

        if(middleName.length() < 1) { middleName = "--No tiene--"; }
        if(lastName.length() < 1) { lastName = "--No tiene--"; }

        System.out.println("Nombre: " + firstName);
        System.out.println("Apellido1: " + middleName);
        System.out.println("Apellido2: " + lastName);

    }
}
