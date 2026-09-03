import java.util.Scanner;

public class AquariumApp {

    public static void main(String[] args) {

        SeaCreature[] tank = new SeaCreature[8];

        /* Two starter creatures.
        try {
            tank[0] = new Fish("Nemo", 4, 3, 1, "><>");
        } catch (InvalidCreatureException e) {
            System.out.println(e.getMessage());
        }
        try {
            tank[1] = new Fish("Dory", 30, 2, -1, "><((('>");
        } catch (InvalidCreatureException e) {
            System.out.println(e.getMessage());
        }
        try {
            tank[2] = new Squid("Albert",15,10,1,"<☲>≼≼≼≼");
        } catch (InvalidCreatureException e) {
            System.out.println(e.getMessage());
        }
        try {
            tank[3] = new Crab("Eduardio",10,4,-1,"ʚ„[•ᴗ•]„ɞ");
        } catch (InvalidCreatureException e) {
            System.out.println(e.getMessage());
        }
        try {
            tank[4] = new Fish("Gregory", 20, 2, -1, "><>");
        } catch (InvalidCreatureException e) {
            System.out.println(e.getMessage());
        }
        */
        // =====================================================
        // STUDENT TODO
        // =====================================================
        // 1. Create at least TWO additional SeaCreature subclasses.
        // 2. Add objects from those subclasses to this array.
        // 3. Make their movement behavior meaningfully different.
        //
        // Example once you create the class:
        // tank[2] = new Shark(...);
        // tank[3] = new Turtle(...);

        Aquarium aquarium = new Aquarium(tank);
        Scanner input = new Scanner(System.in);

        boolean running = true;

        System.out.println("====================================");
        System.out.println("        JAVA TERMINAL AQUARIUM");
        System.out.println("====================================");

        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    aquarium.display();
                    break;

                case "2":
                    aquarium.advanceTurn();
                    aquarium.display();
                    break;

                case "3":
                    for (int i = 0; i < 10; i++) {
                        aquarium.advanceTurn();
                        aquarium.display();
                        stop(1000);
                    }
                    break;

                case "4":
                    aquarium.listCreatureDetails();
                    break;

                case "5":
                    running = false;
                    System.out.println("Aquarium closed. Goodbye!");
                    break;

                default:
                    System.out.println("Please choose 1, 2, 3, or 4.");
            }
        }

        input.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. View Aquarium");
        System.out.println("2. Advance One Turn");
        System.out.println("3. Advance 10 turns");
        System.out.println("4. View Creature Details");
        System.out.println("5. Quit");
    }

    public static void stop(int milliseconds) {
        try { Thread.sleep(milliseconds); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
