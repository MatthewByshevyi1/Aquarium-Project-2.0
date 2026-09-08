import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    private String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public SeaCreature[] readIn(String file) {
        SeaCreature[] retrn = new SeaCreature[8];
        
        int num = 0;
        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                try {
                    if (parts.length != 6) {
                        throw new InvalidCreatureException("Not enough information to create a SeaCreature.");
                    } else {
                        String type = parts[0].trim();
                        String name = parts[1].trim();
                        int position = Integer.parseInt(parts[2].trim());
                        int speed = Integer.parseInt(parts[3].trim());
                        int direction = Integer.parseInt(parts[4].trim());
                        String appearance = parts[5].trim();

                        SeaCreature creature = null;

                        switch (type) {
                            case "Fish":
                                creature = new Fish(name, position, speed, direction, appearance);
                                break;
                            case "Squid":
                                creature = new Squid(name, position, speed, direction, appearance);
                                break;
                            case "Crab":
                                creature = new Crab(name, position, speed, direction, appearance);
                                break;
                            default:
                                throw new InvalidCreatureException("Unknown SeaCreature type: " + type);
                        }

                        if (num < retrn.length) {
                            retrn[num] = creature;
                            num++;
                        } else {
                            System.out.println("Tank is full. Cannot add more creatures.");
                            break;
                        }
                    }
                } catch (InvalidCreatureException e) {
                    System.out.println(e.getMessage());
                }
                
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return retrn;
    }
}