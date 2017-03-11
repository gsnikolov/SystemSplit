package SystemSplit.softwareComponents;


public class ExpressSoftwareComponent extends SoftwareComponent {


    public ExpressSoftwareComponent(String name, int capacity, int memory){
        super(name,capacity,memory);
        this.increaseMemory();
    }


    @Override
    public String getType() {
        return "Express";
    }

    private void increaseMemory(){
        super.setMemory(super.getMemory()*2);
    }

}
