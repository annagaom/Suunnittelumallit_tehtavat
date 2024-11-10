package builder;

public class GameComputer implements ComputerBuilder {
    private Computer computer;

    public GameComputer() {
        this.computer = new Computer();
    }

    public void buildProcessor() {
        computer.addConfiguration(new Configuration("Intel Core i9-9900K"));
    }

    public void buildRAMSize() {
        computer.addConfiguration(new Configuration("32GB"));
    }

    @Override
    public void buildHardDrive() {
        computer.addConfiguration(new Configuration("1TB SSD"));
    }

    public void buildGraphicsCard() {
        computer.addConfiguration(new Configuration("NVIDIA GeForce RTX 2080 Ti"));
    }

    public void buildOperatingSystem() {
        computer.addConfiguration(new Configuration("Windows 11"));

    }

    public Computer getComputer() {
        return computer;
    }

}
