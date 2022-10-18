/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Milan
 */
public class InsuranceDatabase {
    
    private final Scanner scanner;
    private final List<PojisteneOsoby> insertedUsers;
    
    public InsuranceDatabase() {
       this.scanner = new Scanner(System.in);
       this.insertedUsers = new ArrayList<>();
    }

    public void start() {
        this.printHeaderText();
        String userInput = this.getUserInput();
        this.performAction(userInput);
    }
    
    private void printHeaderText() {
       System.out.println("-----------------------------");
       System.out.println("Evidence pojistenych");
       System.out.println("-----------------------------");
       
       System.out.println("Vyberte si akci: ");
       System.out.println("1- Pridat noveho pojisteneho");
       System.out.println("2- Vypsat vsechny pojistene");
       System.out.println("3- Vyhledat pojisteneho");
       System.out.println("4- Konec");
    }
    
    private String getUserInput() {
        return this.scanner.next();
    }    
    
    private void performAction(String userInput){
        switch (userInput){
            case "1" -> {
                this.addUser();
                this.saved();
                this.start();
            }
            
            case "2" -> {
                this.printListings();
                this.start();
            }
            
            case "3" -> {
                this.searchListing();
                this.start();
            }
            
            case "4" -> this.terminate();
            
            default -> this.restart();
        }
    }
    
    private void addUser(){
        System.out.println("Zadejte jmeno positneho");
        String jmeno = this.scanner.next();
        System.out.println("Zadejte prijmeni");
        String prijmeni = this.scanner.next();
        System.out.println("Zadejte telefoni cislo");
        String telCislo = this.scanner.next();
        System.out.println("Zadejte vek");
        int vek  = this.scanner.nextInt();
        
        PojisteneOsoby pojisteneOsoby = new PojisteneOsoby(
                jmeno,
                prijmeni,
                vek,
                telCislo
        );
        
        this.insertedUsers.add(pojisteneOsoby);
    }
    
    private void printListings() {
        this.insertedUsers.forEach(osoba -> {
                System.out.println(osoba);
            }
        );
    }
    
    private void searchListing(){
        System.out.println("Zadejte jmeno pojisteneho");
        String jmeno = this.scanner.next();
        System.out.println("Zadejte prijmeni");
        String prijmeni = this.scanner.next();
        List<PojisteneOsoby> nalez = this.insertedUsers
                .stream()
                .filter(predicate -> predicate.getJmeno().equals(jmeno))
                .filter(predicate -> predicate.getPrijmeni().equals(prijmeni))
                .collect(Collectors.toList())
        ;
        
        if(nalez.isEmpty()){
            System.out.println("Zaznam nenalezen");
            return;
        }
        
        System.out.println(nalez.get(0));
    }
    
    private void terminate(){
        System.out.println("PROGRAM UKONCEN");
        System.exit(0);
        
    }
    
    private void restart(){
        System.out.println("Neplatny prikaz, zkuste to znovu!");
        this.start();
    }
    
    private void saved(){
        System.out.println("Data byla ulozena.");
    }
}
