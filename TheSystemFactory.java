package SystemSplit.factory;


import SystemSplit.TheSystem;

public class TheSystemFactory {

    public void create(String[] tokens, TheSystem system) {

        String hardName;
        String softName;
        int capacity;
        int memory;

        switch (tokens[0]){
            case "RegisterPowerHardware":
                hardName = tokens[1];
                capacity = Integer.parseInt(tokens[2]);
                memory = Integer.parseInt(tokens[3]);
                system.registerPowerHardware(hardName, capacity, memory);
                break;
            case "RegisterHeavyHardware":
                hardName = tokens[1];
                capacity = Integer.parseInt(tokens[2]);
                memory = Integer.parseInt(tokens[3]);
                system.registerHeavyHardware(hardName, capacity, memory);
                break;
            case "RegisterLightSoftware":

                hardName = tokens[1];
                softName = tokens[2];
                capacity = Integer.parseInt(tokens[3]);
                memory = Integer.parseInt(tokens[4]);
                system.registerLightSoftware(hardName,softName,capacity,memory);
                break;
            case "RegisterExpressSoftware":
                hardName = tokens[1];
                softName = tokens[2];
                capacity = Integer.parseInt(tokens[3]);
                memory = Integer.parseInt(tokens[4]);
                system.registerExpressSoftware(hardName,softName,capacity,memory);
                break;
            case "Analyze":
                System.out.println(system.analyze());
                break;
            case "ReleaseSoftwareComponent":
                system.releaseSoftwareComponent(tokens[1], tokens[2]);
                break;
        }


    }
}
