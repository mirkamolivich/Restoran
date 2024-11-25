import java.util.*;
public class Menu {
    String nomi;
    ArrayList<Taom> taomlar = new ArrayList<>();
    public Menu(String nomi) {
        this.nomi = nomi;
    }
    public void taomQoshish(Taom taom) {
        taomlar.add(taom);
    }
    public void taomlarniCHiqarish() {
        System.out.println("=== " + nomi + " ===");
        for (int i = 0; i < taomlar.size(); i++) {
            System.out.println((i + 1) + ". " + taomlar.get(i).nomi + " - " + taomlar.get(i).narxi + " so'm");
        }
        System.out.println((taomlar.size() + 1) + ". Menyuga qaytish");
    }
}
