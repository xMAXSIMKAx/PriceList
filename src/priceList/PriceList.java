package priceList;

import java.util.Scanner;

public class PriceList {
    private String[] items;
    private int itemCount;
    public PriceList(){
        items = new String[100];
        itemCount = 0;
    }

    public void addItems(String itemName){
        if (itemCount < items.length) {
            items[itemCount] = itemName;
            itemCount++;
        }else {
            System.out.println("Перевищено обмеження кількості товарів");
        }

    }
    public void  listItems(){
        for (int i = 0; i < itemCount; i++){
            System.out.println((i+1)+". " + items[i]);
        }
    }

    public void searchItem(String query) {
        boolean found = false;
        for ( int i = 0; i < itemCount; i++){
            if (items[i].contains(query)){
                found = true;
                System.out.println((i+1)+". "+items[i]);
            }
        }
        if (!found){
            System.out.println("Товари, що містять '" + query + "', не знайдено.");
        }
    }

    public static void main(String[] args) {
        PriceList priceList = new PriceList();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Меню:");
            System.out.println("1. Додати товар");
            System.out.println("2. Вивести перелік товарів");
            System.out.println("3. Пошук товару");
            System.out.println("4. Вийти");

            System.out.println("Оберіть опцію: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Введіть найменування товару: ");
                    String item = scanner.nextLine();
                    priceList.addItems(item);
                    break;
                case "2":
                    System.out.println("Перелік товарів:");
                    priceList.listItems();
                    break;
                case "3":
                    System.out.print("Введіть запит для пошуку товару: ");
                    String query = scanner.nextLine();
                    priceList.searchItem(query);
                    break;
                case "4":
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
}


