import java.util.Scanner;

public class AquariumApp {

    public static void main(String[] args) {

        Reader reader = new Reader("SeaCreatures.txt");
        SeaCreature[] tank = reader.readIn("SeaCreatures.txt");

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
                    int turns = 0;
                    while (!(turns >= 1 && turns <= 100)) {
                        System.out.println("\nHow many turns do you want to advance? (1-100)");
                        String turnsInput = input.nextLine().trim();
                        try {
                            turns = Integer.parseInt(turnsInput);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.");
                            continue;
                        }
                        if (turns < 1 || turns > 100) {
                            System.out.println("Please enter a number between 1 and 100.");
                        }
                    }
                    for (int i = 0; i < turns; i++) {
                        aquarium.advanceTurn();
                        aquarium.display();
                        stop(1000);
                    }
                    break;
                
                case "5":
                    aquarium.listCreatureDetails();
                    break;

                case "6":
                    running = false;
                    System.out.println("Aquarium closed. Goodbye!");
                    break;

                default:
                    System.out.println("Please choose 1, 2, 3, 4, or 5.");
            }
        }

        input.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. View Aquarium");
        System.out.println("2. Advance One Turn");
        System.out.println("3. Advance 10 turns");
        System.out.println("4. Advance for x turns");
        System.out.println("5. View Creature Details");
        System.out.println("6. Quit");
    }

    public static void stop(int milliseconds) {
        try { Thread.sleep(milliseconds); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
