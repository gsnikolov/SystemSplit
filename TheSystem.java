package SystemSplit;


import SystemSplit.hardwareComponents.HardwareComponent;
import SystemSplit.hardwareComponents.HeavyHardwareComponent;
import SystemSplit.hardwareComponents.PowerHardwareComponent;
import SystemSplit.softwareComponents.ExpressSoftwareComponent;
import SystemSplit.softwareComponents.LightSoftwareComponent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TheSystem {

    private List<HardwareComponent> hardwareComponents;

    public TheSystem(){
        this.hardwareComponents = new ArrayList<>();
    }


    public void registerPowerHardware(String name, int capacity, int memory) {
        PowerHardwareComponent powerHardwareComponent =
                new PowerHardwareComponent(name, capacity,  memory);
        this.hardwareComponents.add(powerHardwareComponent);
    }

    public void registerHeavyHardware(String name, int capacity, int memory) {
        HeavyHardwareComponent heavyHardwareComponent =
                new HeavyHardwareComponent(name, capacity, memory);
        this.hardwareComponents.add(heavyHardwareComponent);
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        for (HardwareComponent hardwareComponent : this.hardwareComponents) {
            if (hardwareComponent.getName().equals(hardwareComponentName)){
                ExpressSoftwareComponent expressSoftwareComponent =
                        new ExpressSoftwareComponent(name, capacity, memory);
                hardwareComponent.registerSoftwareComponent(expressSoftwareComponent);
            }
        }
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        for (HardwareComponent hardwareComponent : this.hardwareComponents) {
            if (hardwareComponent.getName().equals(hardwareComponentName)){
                LightSoftwareComponent lightSoftwareComponent =
                        new LightSoftwareComponent(name, capacity, memory);
                hardwareComponent.registerSoftwareComponent(lightSoftwareComponent);
            }
        }
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        for (HardwareComponent hardwareComponent : this.hardwareComponents) {
            if (hardwareComponent.getName().equals(hardwareComponentName)){
                hardwareComponent.releaseSoftwareComponents(softwareComponentName);
            }
        }
    }

    public String analyze() {

        return String.format(
                "System Analysis\n" +
                        "Hardware Components: %d\n" +
                        "Software Components: %d\n" +
                        "Total Operational Memory: %d / %d\n" +
                        "Total Capacity Taken: %d / %d",
                this.hardwareComponents.size(),
                this.countSoftware(),
                this.getTotalOperationCurrentMemory(),
                this.getTotalOperationMaxMemory(),
                this.getTotalOperationCurrentCapacity(),
                this.getTotalOperationMaxCapacity()
        );
    }

    public String split() {
        String split = "";
        List<HardwareComponent> result = this.hardwareComponents
                .stream()
                .sorted((h1,h2) -> h2.getType().compareTo(h1.getType()))
                .collect(Collectors.toList());
        for (HardwareComponent hardwareComponent : result) {
            split += hardwareComponent.toString();
        }
        return split;
    }

    private int countSoftware(){
       return this.hardwareComponents.stream()
                .flatMap(h -> h.getSoftwareComponents().stream())
                .collect(Collectors.toList())
                .size();
    }

    private int getTotalOperationMaxMemory(){
        int maxMemory = 0;
        for (HardwareComponent hardwareComponent : hardwareComponents) {
            maxMemory += hardwareComponent.getMemory();
        }

        return maxMemory;
    }

    private int getTotalOperationCurrentMemory(){
        int currentMemory = 0;
        for (HardwareComponent hardwareComponent : hardwareComponents) {
            currentMemory += hardwareComponent.getCurrentMemory();
        }

        return currentMemory;
    }

    private int getTotalOperationMaxCapacity(){
        int maxCapacity = 0;
        for (HardwareComponent hardwareComponent : hardwareComponents) {
            maxCapacity += hardwareComponent.getCapacity();
        }

        return maxCapacity;
    }

    private int getTotalOperationCurrentCapacity(){
        int currentCapacity = 0;
        for (HardwareComponent hardwareComponent : hardwareComponents) {
            currentCapacity += hardwareComponent.getCurrentCapacity();
        }

        return currentCapacity;
    }


}
