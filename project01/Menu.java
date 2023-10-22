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
        Burgers.add(new Product("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        Burgers.add(new Product("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        Burgers.add(new Product("CheeseBurger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));

        FrozenCustards.add(new Product("Shakes", 5.9, "바닐라, 초콜렛, 솔티드, 카라멜, " +
                "블랙&화이트, 스트로베리, 피넛버터, 커피"));
        FrozenCustards.add(new Product("Shake of Week", 6.5, "특별한 커스터드 플레이버"));
        FrozenCustards.add(new Product("Red Bean Shake", 6.5, "커스터드, 우유, 레드빈이 블렌딩 된 시즈널 쉐이크"));

        Drinks.add(new Product("Shake-made Lemonade", 3.9, "상큼한 레몬에이드"));
        Drinks.add(new Product("Fresh Brewed Iced Tea", 3.4, "유기농 홍차를 우려낸 아이스티"));
        Drinks.add(new Product("Fifty/Fifty", 3.5, "레몬에이드와 아이스티의 만남"));

        Beers.add(new Product("ShakeMeister Ale", 9.8, "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주"));
    }



    // 메뉴판 보여주기
    public void showMenu() {
        System.out.println("\"SHAKESHAKE BURGER 에 오신걸 환영합니다.\"");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();

        System.out.println("[ SHAKESHAKE MENU ]");
        System.out.println("1. Burgers         | 앵거스 비프 통살을 다져 만든 버거");
        System.out.println("2. Frozen Custard  | 매장에서 신선하게 만드는 아이스크림");
        System.out.println("3. Drinks          | 매장에서 직접 만드는 음료");
        System.out.println("4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주");
        System.out.println();

        System.out.println("[ ORDER MENU ]");
        System.out.println("5. Order      | 장바구니를 확인 후 주문합니다.");
        System.out.println("6. Cancel     | 진행중인 주문을 취소합니다.");
        System.out.println();

        System.out.println("메뉴를 선택해 주세요");

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
                System.out.println("잘못된 선택지입니다.");
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

        System.out.println("상품을 선택해 주세요");
        int n = sc.nextInt();
        System.out.println();

        Product choice = Burgers.get(n-1);
        System.out.println("\"" + choice.getName() + "      | W " + choice.getPrice() + " | " + choice.getDescription() + "\"");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");

        System.out.println("1. 확인       2. 취소");
        int m = sc.nextInt();

        switch(m) {
            case 1:
                order.addOrder(choice);
                System.out.println(choice.getName() + " 가 장바구니에 추가되었습니다.");
                System.out.println();
                break;
            case 2:
                System.out.println("장바구니 추가를 취소합니다.");
                break;
            default:
                System.out.println("잘못된 선택지입니다.");
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
        System.out.println("아래와 같이 주문 하시겠습니까?");
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
        System.out.println("1. 주문       2. 메뉴판");
        int choice = sc.nextInt();

        if (choice == 1) {
            int orderNumber = order.getOrderNumber();
            System.out.println("주문이 완료되었습니다!");
            System.out.println();
            System.out.println("대기번호는 [ " + orderNumber + " ] 번 입니다.");
            System.out.println("(3초 후 메뉴판으로 돌아갑니다.)");
            System.out.println();

            try { // 3초 대기
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            order.clearOrder();
            order.setOrderNumber(orderNumber+1); // 대기번호 1증가 시키기

            showMenu();
        } else if (choice == 2) {
            showMenu();
        }

    }
    
    public void orderCancel() {
        System.out.println();
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인       2. 취소");

        int cancel = sc.nextInt();

        if(cancel == 1) {
            order.clearOrder(); // 장바구니 초기화
            System.out.println("진행하던 주문이 취소되었습니다.");
            System.out.println();
        } else if (cancel == 2) {
            System.out.println("메뉴판으로 돌아갑니다.");
        }
        showMenu();
    }
}
