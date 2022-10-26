package com.ikasgela;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int entrada;

        do {

            System.out.print("Ingrese la longitud que desea de la sucesión: ");
            entrada = Integer.parseInt(br.readLine());
            if (entrada != 0) {
                System.out.print("Recursivo (R) o Iterativo(I): ");
                String metodo = br.readLine().toLowerCase();

                if (metodo.equals("r")) {

                    for (int i = 0; i < entrada; i++) {
                        System.out.println("fib(" + i + "): " + fibonacciBigR(BigInteger.valueOf(i)));
                    }
                    System.out.println();

                } else if (metodo.equals("i")) {
                    for (int i = 0; i < entrada; i++) {
                        System.out.println("fib(" + i + "): " + fibonacciBigI(i));
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Programa Terminado");
            }


        } while (entrada != 0);
    }


    public static BigInteger fibonacciBigR(BigInteger longitud) {

        BigInteger retorno;
        if (longitud.compareTo(BigInteger.valueOf(2)) < 0) {
            retorno = longitud;
        } else {
            retorno = fibonacciBigR(longitud.subtract(BigInteger.ONE)).add(fibonacciBigR(longitud.subtract(BigInteger.valueOf(2))));
        }

        return retorno;
    }

    public static BigInteger fibonacciBigI(int longitud) {

        BigInteger num_a = BigInteger.ZERO;
        BigInteger num_b = BigInteger.ONE;
        BigInteger num_c;

        for (int i = 0; i < longitud; i++) {
            num_c = num_b.add(num_a);
            num_a = num_b;
            num_b = num_c;
        }

        return num_a;


    }
}
