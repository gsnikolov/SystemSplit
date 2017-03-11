package SystemSplit.hardwareComponents;


public class PowerHardwareComponent extends HardwareComponent {


    public PowerHardwareComponent(String name, int capacity, int memory){
        super(name, capacity, memory);
        this.decreaseCapacity();
        this.increaseMemory();
    }

    @Override
    public String getType() {
        return "Power";
    }

    private void decreaseCapacity(){
        super.setCapacity((int)(super.getCapacity() - (super.getCapacity() * 0.75)));
    }

    private void increaseMemory(){
       super.setMemory((int)(super.getMemory() + (super.getMemory() * 0.75)));
    }
}
