package controller;


import java.util.ArrayList;
import java.util.Collections;
import model.Country;
import model.EastAsiaCountries;
import validation.Validation;

public class ManageEastAsiaCountries {

     Validation validation = new Validation();

    public int menu(){
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = validation.checkInputIntLimit(1, 5);
        return choice;
    }

    public  void inputCountry(ArrayList<EastAsiaCountries> lc) {
        System.out.print("Enter code of country: ");
        String countryCode = validation.checkInputString();
        //check code contry exist or not
        if (!checkCountryExist(lc, countryCode)) {
            System.err.println("Country exist.");
            return;
        }
        System.out.print("Enter name of contry: ");
        String countryName = validation.checkInputString();
        System.out.print("Enter total area: ");
        double countryArea = validation.checkInputDouble();
        System.out.print("Enter terrain of contry: ");
        String countryTerrain = validation.checkInputString();
        lc.add(new EastAsiaCountries(countryCode, countryName, countryArea, countryTerrain));
    }

    public  void printCountry(ArrayList<EastAsiaCountries> lc) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
//        for (Country country : lc) {
//            country.display();
//        }
        if(lc.size() > 0){
            EastAsiaCountries lastC = lc.get(lc.size() - 1);
            lastC.display();
        }
    }

    public void printCountrySorted(ArrayList<EastAsiaCountries> lc) {
        Collections.sort(lc);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : lc) {
            country.display();
        }
    }

    //allow user search infomation contry by name
    public void searchByName(ArrayList<EastAsiaCountries> lc) {
        System.out.print("Enter the name you want to search for: ");
        String countryName = validation.checkInputString();
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : lc) {
            if (country.getCountryName().equalsIgnoreCase(countryName)) {
                country.display();
            }
        }
    }

    public  boolean checkCountryExist(ArrayList<EastAsiaCountries> lc, String countryCode) {
        for (EastAsiaCountries eastAsiaCountries : lc) {
          if (eastAsiaCountries.getCountryCode().equalsIgnoreCase(countryCode)) {
                return false;
            }
        }
        return true;
    }
}

