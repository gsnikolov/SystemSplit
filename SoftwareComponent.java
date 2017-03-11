package SystemSplit.softwareComponents;


import SystemSplit.Component;

public abstract class SoftwareComponent extends Component {

    private String name;
    private int capacity;
    private int memory;

    public SoftwareComponent(String name, int capacity, int memory){
        this.name = name;
        this.capacity = capacity;
        this.memory = memory;
    }

    public String getType(){
        return "Software";
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    protected void setCapacity(int capacity){
        this.capacity = capacity;
    }

    @Override
    public int getMemory() {
        return this.memory;
    }

    protected void setMemory(int memory){
        this.memory = memory;
    }
}
