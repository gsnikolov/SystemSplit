package SystemSplit.softwareComponents;


public class LightSoftwareComponent extends SoftwareComponent {


    public LightSoftwareComponent(String name, int capacity, int memory){
        super(name,capacity, memory);
        this.increaseCapacity();
        this.decreasesMemory();
    }


    @Override
    public String getType() {
        return "Light";
    }

    private void increaseCapacity(){
        super.setCapacity((int)(super.getCapacity() + (super.getCapacity() * 0.5)));
    }

    private void decreasesMemory(){
        super.setMemory((int)(super.getMemory() - (super.getMemory() * 0.5)));
    }



}
