package project01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
    ArrayList<Product> Burgers = new ArrayList<>();
    ArrayList<Product> FrozenCustards = new ArrayList<>();
    ArrayList<Product> Drinks = new ArrayList<>();
    ArrayList<Product> Beers = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    Order order = new Order();

    public Menu() {
        Burgers.add(new Product("ShackBurger", 6.9, "�丶��, �����, ���ҽ��� ���ε� ġ�����"));
        Burgers.add(new Product("SmokeShack", 8.9, "������, ü�� ���ۿ� ���ҽ��� ���ε� ġ�����"));
        Burgers.add(new Product("CheeseBurger", 6.9, "�������� ���� ������Ƽ, ġ� ���ε� ġ�����"));

        FrozenCustards.add(new Product("Shakes", 5.9, "�ٴҶ�, ���ݷ�, ��Ƽ��, ī���, " +
                "��&ȭ��Ʈ, ��Ʈ�κ���, �ǳӹ���, Ŀ��"));
        FrozenCustards.add(new Product("Shake of Week", 6.5, "Ư���� Ŀ���͵� �÷��̹�"));
        FrozenCustards.add(new Product("Red Bean Shake", 6.5, "Ŀ���͵�, ����, ������� ���� �� ����� ����ũ"));

        Drinks.add(new Product("Shake-made Lemonade", 3.9, "��ŭ�� �����̵�"));
        Drinks.add(new Product("Fresh Brewed Iced Tea", 3.4, "����� ȫ���� ����� ���̽�Ƽ"));
        Drinks.add(new Product("Fifty/Fifty", 3.5, "�����̵�� ���̽�Ƽ�� ����"));

        Beers.add(new Product("ShakeMeister Ale", 9.8, "����ũ�� ���Ÿ� ���� ���� ���Ŭ�� ������� Ư���� ������ ���� ����"));
    }



    // �޴��� �����ֱ�
    public void showMenu() {
        System.out.println("\"SHAKESHAKE BURGER �� ���Ű� ȯ���մϴ�.\"");
        System.out.println("�Ʒ� �޴����� ���ð� �޴��� ��� �Է����ּ���.");
        System.out.println();

        System.out.println("[ SHAKESHAKE MENU ]");
        System.out.println("1. Burgers         | �ްŽ� ���� ����� ���� ���� ����");
        System.out.println("2. Frozen Custard  | ���忡�� �ż��ϰ� ����� ���̽�ũ��");
        System.out.println("3. Drinks          | ���忡�� ���� ����� ����");
        System.out.println("4. Beer            | ���� ���Ŭ�� ������� ������ ����");
        System.out.println();

        System.out.println("[ ORDER MENU ]");
        System.out.println("5. Order      | ��ٱ��ϸ� Ȯ�� �� �ֹ��մϴ�.");
        System.out.println("6. Cancel     | �������� �ֹ��� ����մϴ�.");
        System.out.println();

        System.out.println("�޴��� ������ �ּ���");

        int n = sc.nextInt();
        switch(n) {
            case 1:
                showBurgers();
                break;
            case 2:
                showFrozenCustard();
                break;
            case 3:
                showDrinks();
                break;
            case 4:
                showBeer();
                break;
            case 5:
                showOrder();
                break;
            case 6:
                orderCancel();
                break;
            default:
                System.out.println("�߸��� �������Դϴ�.");
                break;

        }
    }
    public void showBurgers() {
        System.out.println();

        System.out.println("[ Burgers MENU ]");
        for (int i = 0; i < Burgers.size(); i++) {
            Product menu = Burgers.get(i);
            System.out.println((i+1) + ". " + menu.getName() + "    | W " + menu.getPrice() + " | " + menu.getDescription());
        }

        System.out.println("��ǰ�� ������ �ּ���");
        int n = sc.nextInt();
        System.out.println();

        Product choice = Burgers.get(n-1);
        System.out.println("\"" + choice.getName() + "      | W " + choice.getPrice() + " | " + choice.getDescription() + "\"");
        System.out.println("�� �޴��� ��ٱ��Ͽ� �߰��Ͻðڽ��ϱ�?");

        System.out.println("1. Ȯ��       2. ���");
        int m = sc.nextInt();

        switch(m) {
            case 1:
                order.addOrder(choice);
                System.out.println(choice.getName() + " �� ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
                System.out.println();
                break;
            case 2:
                System.out.println("��ٱ��� �߰��� ����մϴ�.");
                break;
            default:
                System.out.println("�߸��� �������Դϴ�.");
        }

        showMenu();
    }

    public void showFrozenCustard() {

    }

    public void showDrinks() {

    }

    public void showBeer() {


    }

    public void showOrder() {
        System.out.println("�Ʒ��� ���� �ֹ� �Ͻðڽ��ϱ�?");
        System.out.println();
        System.out.println("[ Orders ]");

        ArrayList<Product> orders = order.getOrders();

        for (int i = 0; i < orders.size(); i++) {
            Product menu = orders.get(i);
            System.out.println(menu.getName() + "       | W " + menu.getPrice() + " | " + menu.getDescription());
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println("W " + order.total());

        System.out.println();
        System.out.println("1. �ֹ�       2. �޴���");
        int choice = sc.nextInt();

        if (choice == 1) {
            int orderNumber = order.getOrderNumber();
            System.out.println("�ֹ��� �Ϸ�Ǿ����ϴ�!");
            System.out.println();
            System.out.println("����ȣ�� [ " + orderNumber + " ] �� �Դϴ�.");
            System.out.println("(3�� �� �޴������� ���ư��ϴ�.)");
            System.out.println();

            try { // 3�� ���
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            order.clearOrder();
            order.setOrderNumber(orderNumber+1); // ����ȣ 1���� ��Ű��

            showMenu();
        } else if (choice == 2) {
            showMenu();
        }

    }
    
    public void orderCancel() {
        System.out.println();
        System.out.println("�����ϴ� �ֹ��� ����Ͻðڽ��ϱ�?");
        System.out.println("1. Ȯ��       2. ���");

        int cancel = sc.nextInt();

        if(cancel == 1) {
            order.clearOrder(); // ��ٱ��� �ʱ�ȭ
            System.out.println("�����ϴ� �ֹ��� ��ҵǾ����ϴ�.");
            System.out.println();
        } else if (cancel == 2) {
            System.out.println("�޴������� ���ư��ϴ�.");
        }
        showMenu();
    }
}
