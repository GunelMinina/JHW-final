import java.util.*;

/*
Подумать над структурой класса Ноутбук для магазина техники -
выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.

Написать метод, который будет запрашивать у пользователя критерий (или критерии)
фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.

Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
 */
public class Main {

    public static Set<Notebook> noteBooks = new HashSet<>();
    public static Map<String, String> filter = new HashMap<>();
    public static void main(String[] args) {
        init_db();
        action();
    }

    public static int show_menu() {
        System.out.println("Выберите действие:");
        System.out.println("1 - Установить фильтр по бренду");
        System.out.println("2 - Установить фильтр по оперативной памяти");
        System.out.println("3 - Установить фильтр по жесткому диску");
        System.out.println("4 - Сбросить фильтр");
        System.out.println("5 - Показать результат");
        Scanner scanner = new Scanner(System.in);

         return scanner.nextInt();
    }

     public static void action() {
        int act = show_menu();

        switch (act) {
            case 1:
                set_brand();
                break;
            case 2:
                set_ram();
                break;
            case 3:
                set_hd();
                break;
            case 4:
                clear_filter();
                break;
            case 5:
                show_result();
                break;
            default:
                break;
        }

         action();
     }

     public static void set_ram() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите минимальный объем оперативки");
        String ram = scanner.nextLine();
        if (filter.containsKey("ram")) {
            filter.replace("ram", ram);
        } else {
            filter.put("ram", ram);
        }
     }

    public static void set_hd() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите минимальный объем ЖД");
        String hd = scanner.nextLine();
        if (filter.containsKey("hd")) {
            filter.replace("hd", hd);
        } else {
            filter.put("hd", hd);
        }
    }

    public static void clear_filter() {
        filter = new HashMap<>();
    }

    public static void show_result() {
        Set<Notebook> results = new HashSet<>();

        for(Notebook notebook : noteBooks) {
            if (filter.containsKey("brand") && !notebook.brand.contains(filter.get("brand"))) {
               continue;
            }

            if (filter.containsKey("ram") && notebook.ram < Integer.parseInt(filter.get("ram"))) {
                continue;
            }

            if (filter.containsKey("hd") && notebook.hd < Integer.parseInt(filter.get("hd"))) {
                continue;
            }

            results.add(notebook);
        }

        if (results.size() == 0) {
            System.out.println("Ничего не найдено");
        } else {
            for(Notebook notebook : results) {
                System.out.println(notebook);
            }
        }
    }

    public static void set_brand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите бренд");
        String brand = scanner.nextLine();
        if (filter.containsKey("brand")) {
            filter.replace("brand", brand);
        } else {
            filter.put("brand", brand);
        }
    }

    public static void init_db() {
        noteBooks.add(new Notebook("Apple", "MacBook Air", 8, 256, "MacOS"));
        noteBooks.add(new Notebook("Apple", "MacBook Air", 8, 512, "MacOS"));
        noteBooks.add(new Notebook("Apple", "MacBook Air", 16, 256, "MacOS"));
        noteBooks.add(new Notebook("Apple", "MacBook Pro M1", 32, 256, "MacOS"));
        noteBooks.add(new Notebook("Apple", "MacBook Pro M1", 32, 512, "MacOS"));
        noteBooks.add(new Notebook("Apple", "MacBook Pro M1", 32, 1024, "MacOS"));
        noteBooks.add(new Notebook("Apple", "MacBook Pro M1", 64, 512, "MacOS"));
        noteBooks.add(new Notebook("Apple", "MacBook Pro M1", 64, 1024, "MacOS"));
        noteBooks.add(new Notebook("DELL", "Vostro 3515", 4, 128, "Free DOS"));
        noteBooks.add(new Notebook("DELL", "Vostro 3400", 8, 1000, "Linux"));
        noteBooks.add(new Notebook("DELL", "Vostro 3510", 8, 256, "Linux"));
    }
}