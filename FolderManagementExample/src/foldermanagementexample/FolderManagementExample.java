/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package foldermanagementexample;

import java.util.ArrayList;
import java.util.List;

// Interface untuk senjata yang dapat dibagikan
interface Shareable {
    void share();
}

// Abstract class untuk item dalam folder
abstract class Item implements Shareable {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Kelas Inner untuk senjata
class Weapon extends Item {
    private String type;

    public Weapon(String name, String type) {
        super(name);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public void share() {
        System.out.println("Senjata: " + getName() + " (Tipe: " + getType() + ") dibagikan");
    }
}

// Kelas Inner untuk folder
class Folder {
    private String name;
    private List<Item> items;

    public Folder(String name) {
        this.name = name;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void shareItems() {
        System.out.println("Berbagi semua item dalam folder " + name);
        for (Item item : items) {
            if (item instanceof Shareable) {
                Shareable shareableItem = (Shareable) item;
                shareableItem.share();
            }
        }
    }
}

public class FolderManagementExample {
    public static void main(String[] args) {
        // Membuat folder
        Folder folder = new Folder("Folder Senjata");

        // Membuat senjata
        Weapon weapon1 = new Weapon("Pistol", "Sidearm");
        Weapon weapon2 = new Weapon("Shotgun", "Shotgun");
        Weapon weapon3 = new Weapon("Rifle", "Assault Rifle");

        // Menambahkan senjata ke dalam folder
        folder.addItem(weapon1);
        folder.addItem(weapon2);
        folder.addItem(weapon3);

        // Membagikan semua item dalam folder
        folder.shareItems();
    }
}

