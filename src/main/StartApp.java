package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import vo.Platform;
import vo.Titles;

public class StartApp {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Platform> listPlatforms = new ArrayList<>();
    ArrayList<Titles> listTitles = new ArrayList<>();

    public void start(){
        int option;

        do{
            option = menu();

            switch(option){
                case(1): platformRegistration();break;
                case(2): titleRegistration();break;
                case(3): randomSearch();break;
                case(4): search();break;
            }

        }while(option!=9);
        System.out.println("Thanks for all! See you!!!");
    }

    public void platformRegistration(){
        System.out.println("\n=== Platform Registration ===\n");
        System.out.println("Enter the platform's name: ");
        String platformName = scanner.nextLine();
        System.out.println("Enter the platform's site: ");
        String platformSite = scanner.nextLine();

        Platform platform = new Platform(platformName, platformSite);

        listPlatforms.add(platform);
    }

    public void titleRegistration(){
        System.out.println("\n=== Titles Registration ===\n");
        System.out.println("Enter the title's type: ");
        String type = scanner.nextLine();
        System.out.println("Enter the title's name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the title's cast: ");
        String cast = scanner.nextLine();
        System.out.println("Enter the title's description: ");
        String description = scanner.nextLine();
        System.out.println("Enter the title's genre: ");
        String genre = scanner.nextLine();
        System.out.println("Enter the title's director: ");
        String director = scanner.nextLine();
        System.out.println("Enter the title's age rating: ");
        String ageRating = scanner.nextLine();

       Titles title = new Titles(type, name, cast, description, genre, director, ageRating, addPlatformOfTitle());
       listTitles.add(title);
    }

    public ArrayList<String> addPlatformOfTitle(){      //add platforms to the titles.
        ArrayList<String> addPlatformOfTitle = new ArrayList<>();
        int count = 0;
        while(count == 0) {
            System.out.println("Enter the platform's name: ");
            String add = scanner.nextLine();
            int check = checkPlatform(add);
            if(check > 0) {
                addPlatformOfTitle.add(add);
            }else {
                System.out.println("Sorry! This platform doesn't exist in our registry!\n ");
            }
            System.out.println("Do you wanna add more platforms to the title?\n");
            System.out.println("1. Yes\n2. No\n");
            int option = scanner.nextInt(); scanner.nextLine();
            if (option == 1) {
                count = 0;
            }else if(option == 2){
                System.out.println("Returning to main menu...\n");
                count++;
            }
        }
            return addPlatformOfTitle;
    }

   public int checkPlatform(String check){
       int count = 0;
       for(int i=0; i<listPlatforms.size(); i++) {
           if(check.equals(listPlatforms.get(i).getPlatformName())) {
                count++;
            }
        }
        return count;
    }


    public void randomSearch(){
        Random random = new Random();
        int size = listTitles.size();
        int randomTitle = random.nextInt(0,size);
        System.out.println("\nWe recommend this title for you!\n");
        System.out.println(listTitles.get(randomTitle).toString());
    }

    public void search(){                       //searches for type, title(name), genre and platforms.
        int count = 0;
        System.out.println("\nOK! Let's search some title to you\n");
        System.out.println("Enter the type, name, genre or platform's title:\n");
        String wordCheck = scanner.nextLine();

        for(int i=0; i< listTitles.size(); i++){
            if((wordCheck.equals(listTitles.get(i).getType()) ||
                    wordCheck.equals(listTitles.get(i).getTitle()) ||
                         wordCheck.equals(listTitles.get(i).getGenre()) ||
                              (listTitles.get(i).getPlatformOfTitle().contains(wordCheck)))){

                System.out.println(listTitles.get(i).toString());
                count++;
            }
        }
                System.out.println("\nNumber of media found: \n"+count);
                count=0;
    }

    public int menu(){
        System.out.println("\n=== MY STREAMING APP ===\n");
        System.out.println("Choose one option below: \n");
        System.out.println("1. Platform's Register\n2. Title's Register\n" +
                            "3. Recommended for you!\n4. Let's Search!\n9. Exit  ");
        int option = scanner.nextInt(); scanner.nextLine();
        return option;
    }
}
