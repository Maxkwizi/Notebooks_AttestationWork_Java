import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Dell", 4, 512, "Windows", "Black"));
        notebooks.add(new Notebook("Asus", 2, 256, "Linux", "White"));
        notebooks.add(new Notebook("HP", 16, 1024,  "Windows", "Silver"));
        notebooks.add(new Notebook("Lenovo", 8, 1024, "Windows", "Blue"));
        notebooks.add(new Notebook("Apple", 8, 512, "MacOS", "White"));
        notebooks.add(new Notebook("Acer", 4, 256, "Linux", "Black"));
        notebooks.add(new Notebook("Apple", 16, 512, "MacOS", "Silver"));
        notebooks.add(new Notebook("Acer", 8, 1024, "Windows", "Black"));
        notebooks.add(new Notebook("Acer", 2, 256, "Android", "Silver"));
        notebooks.add(new Notebook("HP", 16, 512, "Linux", "White"));
        notebooks.add(new Notebook("Apple", 16, 1024, "MacOS", "Silver"));
        notebooks.add(new Notebook("Acer", 8, 512, "Linux", "Blue"));
        notebooks.add(new Notebook("Xiaomi", 32, 1024, "Android", "Black"));

        System.out.println("********************");
        System.out.println("ПРИВЕТСТВУЕМ ВАС В МАГАЗИНЕ НОУТБУКОВ!");
        System.out.println("********************");
        System.out.println("Вы можете выбрать подходящий ноутбук исходя из следующих критериев: ");
        System.out.println("1 - ОЗУ (2, 4, 8, 16, 32 Гб)");
        System.out.println("2 - Объем ЖД (256, 512, 1024 Гб)");
        System.out.println("3 - Операционная система (Windows, Linux, MacOS, Android)");
        System.out.println("4 - Цвет (Black, White, Silver, Blue)");
        System.out.println(" ");

        Map<String, Object> filterCriteria = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - Объем ОЗУ");
        System.out.println("2 - Объём ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
      
        boolean check = true;
        int criterion = scanner.nextInt(); 
            switch (criterion) {
            case 1:
                System.out.println("Введите минимальный объем ОЗУ:");
                int ramMin = scanner.nextInt();
                if (ramMin <= 0 || ramMin > 32){
                    System.out.println("Ноутбуков с такой ОЗУ не найдено");
                    check = false;
                    break;
                }
                else {filterCriteria.put("ram", ramMin);
                }
                break;
            case 2:
                System.out.println("Введите минимальный объём ЖД:");
                int hddMin = scanner.nextInt();    
                if (hddMin <= 0 || hddMin > 1024) {
                    System.out.println("Ноутбуков с таким ЖД не найдено");
                    check = false;
                    break;
                }    
                else {
                    filterCriteria.put("hdd", hddMin);
                }
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                String os = scanner.next();
                filterCriteria.put("os", os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.next();
                filterCriteria.put("color", color);
                break;
            default: 
                System.out.println("Некорректный ввод");
                break;
            }

        for (Notebook notebook : notebooks)
            if (criterion > 0 && criterion < 5 && check){
                boolean passFilter = true;
             {
                for (Map.Entry<String, Object> entry : filterCriteria.entrySet()) {
                        switch (entry.getKey()) {       
                            case "ram":
                                if (notebook.getRam() < (int) entry.getValue()) {
                                    passFilter = false;
                                }
                                break;
                            case "hdd":
                                if (notebook.getHdd() < (int) entry.getValue()) {
                                    passFilter = false;
                                }
                                break;
                            case "os":
                                if (!notebook.getOs().equals(entry.getValue())) {
                                    passFilter = false;
                                }
                                break;
                            case "color":
                                if (!notebook.getColor().equals(entry.getValue())) {
                                    passFilter = false;
                                }
                                break;
                        }
                    }
            }
            
            if (passFilter) {
                System.out.println("*************"); 
                System.out.println("Ноутбук " + notebook.getBrand() + ": " + notebook.getRam() + " Гб ОЗУ " + notebook.getHdd() + " Гб Жёсткого диска, " + "ОС: " + notebook.getOs() + " Цвет: " + notebook.getColor());
                System.out.println(" "); 
            }
            scanner.close();
        }
    }
}


    

  

