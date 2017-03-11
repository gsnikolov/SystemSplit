package SystemSplit.hardwareComponents;


import SystemSplit.Component;
import SystemSplit.softwareComponents.SoftwareComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class HardwareComponent  extends Component{

    private String name;
    private int capacity;
    private int currentCapacity;
    private int memory;
    private int currentMemory;
    private List<SoftwareComponent> softwareComponents;

    protected HardwareComponent(String name, int capacity, int memory){
        this.name = name;
        this.capacity = capacity;
        this.memory = memory;

        this.currentCapacity = 0;
        this.currentMemory = 0;

        this.softwareComponents = new ArrayList<>();

    }

    public List<SoftwareComponent> getSoftwareComponents() {
        return Collections.unmodifiableList(this.softwareComponents);
    }

    public String getType(){
        return "Hardware";
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int getMemory() {
        return this.memory;
    }

    protected void setMemory(int memory) {
        this.memory = memory;
    }

    public int getCurrentCapacity() {
        return this.currentCapacity;
    }

    public int getCurrentMemory() {
        return this.currentMemory;
    }


    private void addSoftwareComponents(SoftwareComponent softwareComponent){
        this.softwareComponents.add(softwareComponent);
    }

    public void registerSoftwareComponent(SoftwareComponent softwareComponent){
        int freeMemory = this.getMemory() - this.getCurrentMemory();
        int freeCapacity = this.getCapacity() - this.getCurrentCapacity();

        if (freeMemory >= softwareComponent.getMemory() &&
                freeCapacity >= softwareComponent.getCapacity()){

            this.currentMemory += softwareComponent.getMemory();
            this.currentCapacity += softwareComponent.getCapacity();
            this.addSoftwareComponents(softwareComponent);

        }
    }

    public void releaseSoftwareComponents(String name){
        for (SoftwareComponent softwareComponent : this.getSoftwareComponents()) {

            if (softwareComponent.getName().equals(name)){
                this.currentCapacity = this.getCurrentCapacity() - softwareComponent.getCapacity();
                this.currentMemory = this.getCurrentMemory() - softwareComponent.getMemory();
            }

        }
        this.softwareComponents.removeIf(s -> s.getName().equals(name));
    }

    @Override
    public String toString() {
        return String.format(
                "Hardware Component - %s\n" +
                        "Express Software Components - %d\n" +
                        "Light Software Components - %d\n" +
                        "Memory Usage: %d / %d\n" +
                        "Capacity Usage: %d / %d\n" +
                        "Type: %s\n" +
                        "Software Components: %s\n",
                this.getName(),
                this.countExpressSoftware(),
                this.countLightSoftware(),
                this.getCurrentMemory(),
                this.getMemory(),
                this.getCurrentCapacity(),
                this.getCapacity(),
                this.getType(),
                this.softuerComponentsName()
        );
    }

    private int countExpressSoftware(){
        return this.softwareComponents.stream()
                .filter(s -> s.getType().equals("Express"))
                .collect(Collectors.toList())
                .size();
    }

    private int countLightSoftware(){
        return this.softwareComponents.stream()
                .filter(s -> s.getType().equals("Light"))
                .collect(Collectors.toList())
                .size();
    }

    private String softuerComponentsName(){
        if (this.softwareComponents.isEmpty()){
            return "None";
        }
        List<String> names = this.softwareComponents
                .stream()
                .map(SoftwareComponent::getName)
                .collect(Collectors.toList());
        return String.join(", ", names);
    }
}
