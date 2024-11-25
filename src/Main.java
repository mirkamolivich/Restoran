import java.util.*;
public class Main {
    public static void main(String[] args) {
        Menu uzbekTaomlari = new Menu("O'zbek Taomlari");
        uzbekTaomlari.taomQoshish(new Taom("Palov", 30000));
        uzbekTaomlari.taomQoshish(new Taom("Manti", 25000));
        uzbekTaomlari.taomQoshish(new Taom("Lag'mon", 35000));
        uzbekTaomlari.taomQoshish(new Taom("Shashlik", 40000));

        Menu koreysTaomlari = new Menu("Koreys Taomlari");
        koreysTaomlari.taomQoshish(new Taom("Kimchi", 40000));
        koreysTaomlari.taomQoshish(new Taom("Bibimbap", 45000));
        koreysTaomlari.taomQoshish(new Taom("Tteokbokki", 50000));
        koreysTaomlari.taomQoshish(new Taom("Japchae", 48000));

        Menu yevropaTaomlari = new Menu("Yevropa Taomlari");
        yevropaTaomlari.taomQoshish(new Taom("Pizza", 60000));
        yevropaTaomlari.taomQoshish(new Taom("Pasta", 55000));
        yevropaTaomlari.taomQoshish(new Taom("Lasagna", 58000));
        yevropaTaomlari.taomQoshish(new Taom("Burger", 45000));

        ArrayList<Menu> menyu = new ArrayList<>();
        menyu.add(uzbekTaomlari);
        menyu.add(koreysTaomlari);
        menyu.add(yevropaTaomlari);

        ArrayList<Taom> buyurtmalar = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean ishlashda = true;

        while (ishlashda) {
            System.out.println("\n=== RESTORAN MENYUSI ===");
            for (int i = 0; i < menyu.size(); i++) {
                System.out.println((i + 1) + ". " + menyu.get(i).nomi);
            }
            System.out.println((menyu.size() + 1) + ". Buyurtmani ko'rish");
            System.out.println((menyu.size() + 2) + ". Chiqish");
            System.out.print("Tanlovingizni kiriting: ");
            int tanlov = scanner.nextInt();

            if (tanlov == menyu.size() + 2) {
                ishlashda = false;
                System.out.println("Rahmat! Yana kutamiz!");
            } else if (tanlov == menyu.size() + 1) {
                System.out.println("\n=== Buyurtmangiz ===");
                if (buyurtmalar.isEmpty()) {
                    System.out.println("Hozircha buyurtma yo'q.");
                } else {
                    double jamiNarx = 0;
                    for (Taom taom : buyurtmalar) {
                        System.out.println(taom.nomi + " - " + taom.narxi + " so'm");
                        jamiNarx += taom.narxi;
                    }
                    System.out.println("Jami narx: " + jamiNarx + " so'm");
                }
            } else if (tanlov >= 1 && tanlov <= menyu.size()) {
                boolean Menuda = true;
                while (Menuda) {
                    menyu.get(tanlov - 1).taomlarniCHiqarish();
                    System.out.print("Tanlovingizni kiriting: ");
                    int taomTanlov = scanner.nextInt();
                    if (taomTanlov == menyu.get(tanlov - 1).taomlar.size() + 1) {
                        Menuda = false;
                    } else if (taomTanlov >= 1 && taomTanlov <= menyu.get(tanlov - 1).taomlar.size()) {
                        Taom tanlanganTaom = menyu.get(tanlov - 1).taomlar.get(taomTanlov - 1);
                        buyurtmalar.add(tanlanganTaom);
                        System.out.println("Tanlangan taom: " + tanlanganTaom.nomi + " qo'shildi!");
                    } else {
                        System.out.println("Noto'g'ri tanlov!");
                    }
                }
            } else {
                System.out.println("Noto'g'ri tanlov!");
            }
        }
    }
}


