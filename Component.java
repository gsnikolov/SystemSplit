package SystemSplit;


public abstract class Component {

    private String name;
    private String type;


    protected Component() {

    }

    protected Component(String name, String type) {
        this.name = name;
        this.type = type;

    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public abstract int getCapacity();

    public abstract int getMemory();


}
