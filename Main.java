import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Model1", 8, 500, "Windows", "Black"));
        laptops.add(new Laptop("Model2", 16, 1000, "MacOS", "Silver"));
        laptops.add(new Laptop("Model3", 4, 256, "Linux", "Grey"));
        laptops.add(new Laptop("Model4", 16, 512, "Windows", "White"));
        laptops.add(new Laptop("Model5", 8, 1024, "MacOS", "Black"));
        laptops.add(new Laptop("Model6", 16, 512, "Linux", "Black"));
        laptops.add(new Laptop("Model7", 8, 1000, "Windows", "Grey"));
        laptops.add(new Laptop("Model8", 32, 512, "MacOS", "White"));
        laptops.add(new Laptop("Model9", 8, 500, "Linux", "Black"));
        laptops.add(new Laptop("Model10", 16, 1000, "Windows", "Silver"));

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> filters = new HashMap<>();

        while (true) {
            System.out.println("\n1 - ОЗУ");
            System.out.println("2 - Объем HDD");
            System.out.println("3 - Операционная система");
            System.out.println("4 - Цвет");
            System.out.println("0 - Выход");
            System.out.println("\nВведите необходимый критерий: ");

            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Введите минимальное значение ОЗУ:");
                    filters.put("ram", scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Введите минимальный объем HDD:");
                    filters.put("hdd", scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Введите операционную систему:");
                    filters.put("os", scanner.next().toLowerCase());
                    break;
                case 4:
                    System.out.println("Введите цвет:");
                    filters.put("color", scanner.next().toLowerCase());
                    break;
            }

            filterLaptops(laptops, filters);
            filters.clear();
        }
    }

    public static void filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
        Set<Laptop> filtered = laptops.stream()
                .filter(n -> filters.get("ram") == null || n.getRam() >= (int) filters.get("ram"))
                .filter(n -> filters.get("hdd") == null || n.getHdd() >= (int) filters.get("hdd"))
                .filter(n -> filters.get("os") == null || n.getOs().toLowerCase().equals(filters.get("os").toString().toLowerCase()))
                .filter(n -> filters.get("color") == null || n.getColor().toLowerCase().equals(filters.get("color").toString().toLowerCase()))
                .collect(Collectors.toSet());

        for (Laptop n : filtered) {
            n.printInfo();
        }
    }
}

class Laptop {
    private String model;
    private int ram;
    private int hdd;
    private String os;
    private String color;

    public Laptop(String model, int ram, int hdd, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public void printInfo() {
        System.out.println("Model: " + model + ", RAM: " + ram + ", HDD: " + hdd + ", OS: " + os + ", Color: " + color);
    }
}