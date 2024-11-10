package builder;

public interface ComputerBuilder {
    void buildProcessor();
    void buildRAMSize();
    void buildHardDrive();
    void buildGraphicsCard();
    void buildOperatingSystem();
    Computer getComputer();

}

