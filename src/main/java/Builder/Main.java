package Builder;


public class Main {
    public static void main(String[] args) {
        ComputerBuilder builder1 = new GameComputer();
        Director director1= new Director(builder1);
        director1.constructComputer();
        Computer gameComputer = builder1.getComputer();
        System.out.println("Game computer:");
        System.out.println(gameComputer);
        System.out.println("----------------------------");

        ComputerBuilder builder2 = new OfficeComputer();
        Director director2  = new Director(builder2);
        director2.constructComputer();
        Computer officeComputer = builder2.getComputer();
        System.out.println("Office computer:");
        System.out.println(officeComputer);
    }
}
