package main;



import controller.ManageEastAsiaCountries;
import java.util.ArrayList;
import model.EastAsiaCountries;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ManageEastAsiaCountries m = new ManageEastAsiaCountries();
        ArrayList<EastAsiaCountries> lc = new ArrayList<>();
        //loop until user want to exist
        while (true) {
            int choice = m.menu();;
            switch (choice) {
                case 1:
                    m.inputCountry(lc);
                    break;
                case 2:
                    m.printCountry(lc);
                    break;
                case 3:
                    m.searchByName(lc);
                    break;
                case 4:
                    m.printCountrySorted(lc);
                    break;
                case 5:
                    return;
            }
        }
    }
}