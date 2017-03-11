package SystemSplit.hardwareComponents;


public class HeavyHardwareComponent extends HardwareComponent {


    public HeavyHardwareComponent(String name, int capacity, int memory){
        super(name,capacity,memory);
        this.decreaseMemory();
        this.increaseCapacity();
    }


    @Override
    public String getType() {
        return "Heavy";
    }

    private void decreaseMemory(){
        super.setMemory((int)(super.getMemory() - (super.getMemory()*0.25) ));
    }

    private void increaseCapacity(){
        super.setCapacity(super.getCapacity() * 2);
    }

}
