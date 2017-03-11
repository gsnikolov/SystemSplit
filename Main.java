package SystemSplit;


import SystemSplit.factory.TheSystemFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TheSystem system = new TheSystem();
        TheSystemFactory factory = new TheSystemFactory();
        String input;
        while (!"System Split".equals(input = reader.readLine())){
            String[] tokens = input.split("[(),\\s]+");
            factory.create(tokens, system);
        }
        System.out.println(system.split());


    }
}
