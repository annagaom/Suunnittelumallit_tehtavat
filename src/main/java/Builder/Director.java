package Builder;

public class Director {

        private ComputerBuilder builder;

        public Director(ComputerBuilder builder) {
            this.builder = builder;
        }

        public void constructComputer() {
            builder.buildProcessor();
            builder.buildRAMSize();
            builder.buildHardDrive();
            builder.buildGraphicsCard();
            builder.buildOperatingSystem();

        }
}
