package com.travelservice;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TravelMain {
    private static List<User> users = new ArrayList<>();

    public static void main(String... args) {
        if (welcomeMessage()) {
            showMenuOptions();
        } else {
        }
    }

    private static boolean welcomeMessage() {
        try (FileReader fl = new FileReader("company_logo.txt");//here we are writing in braces it will close the stream after execution otherwise we need to close the stream manually by (reader.close())
             BufferedReader reader = new BufferedReader(fl);) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.err.println(line);
            }
            return true;
        } catch (IOException e) {
            System.out.println(" error reading welcome message  " + e.getMessage());
            return false;
        }

    }

    private static void showMenuOptions() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n Options Menu");
            System.out.println(" 1 . New Registration");
            System.out.println(" 2 . Exit ");
            System.out.println(" 3 . login ");

            System.out.println(" Choose your options ");
            int Choice = scanner.nextInt();


            switch (Choice) {
                case 1:
                    registerNewAdmin();
                    break;
                case 2:
                    System.out.println("exiting....");

                    System.exit(0);
                    break;
                case 3:

                    login();
                    break;
                default:
                    System.out.println("choose  correct options  (1,2,3c)");

            }
        }

    }

    private static void registerNewAdmin() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter your details");
        System.out.print("firstName : ");
        String firstName = sc.nextLine();
        System.out.print("lastName : ");
        String lastName = sc.nextLine();
        System.out.print("gender : ");
        char gender = sc.nextLine().charAt(0);
        System.out.print("email : ");
        String email = sc.nextLine();
        System.out.print("password : ");
        String password = sc.nextLine();

        users.add(new User(firstName, lastName, gender, email, password));
        for (Object x : users) {
            System.out.println(x.toString());
        }

    }

    private static void login() {
        int logincount = 1;
        User user = new User();
        while (logincount <= 5) {
            Scanner sc = new Scanner(System.in);
        System.out.println("Enter your login details ");
        System.out.println("Enter your email");
        String loginEmail = sc.nextLine();
        System.out.println("Enter your Password");
        String loginPassword = sc.nextLine();
            if ((loginEmail.equals(user.getEmail())) && loginPassword.equals(user.getPassword())) {
                System.out.println("login successful");
            } else {
                            logincount++;
                            System.out.println("invalid login credentials");
                        }
            }
        }

    private  static class User {

        private String firstName;
        private String lastName;
        private char gender;
        private String email;
        private String password;

        public User() {

        }


        public User(String firstName, String lastName, char gender, String email, String password) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
            this.email = email;
            this.password = password;
        }


        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setGender(char gender) {
            this.gender = gender;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public char getGender() {
            return this.gender;
        }

        public String getEmail() {
            return this.email;
        }

        public String getPassword() {
            return this.password;
        }

        @Override
        public String toString() {
            return " User{firstName : " + firstName + " " + "lastName :" + lastName + " " + "gender : " + gender + " " + "email : " + email + " " + "password : " + password + "}";
        }


    }
}
