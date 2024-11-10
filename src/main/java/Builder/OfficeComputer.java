package Builder;

public class OfficeComputer implements ComputerBuilder {

    private Computer computer;

    public OfficeComputer() {
        computer = new Computer();
    }

    public void buildProcessor() {
        computer.addConfiguration(new Configuration("Intel Core i5-9400"));
    }

    public void buildRAMSize() {
        computer.addConfiguration(new Configuration("16GB"));
    }

    public void buildHardDrive() {
        computer.addConfiguration(new Configuration("500GB SSD"));
    }

    public void buildGraphicsCard() {
        computer.addConfiguration(new Configuration("Integrated Intel UHD Graphics 630"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addConfiguration(new Configuration("Windows 10"));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }

}
