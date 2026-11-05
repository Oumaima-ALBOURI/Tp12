package com.example.filemanagement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    // Méthode pour récupérer les métadonnées d'un fichier
    public static void getFileMetadata(String filePath) {

        try {
            Path path = Paths.get(filePath);

            BasicFileAttributes attrs =
                    Files.readAttributes(path, BasicFileAttributes.class);

            System.out.println("=== Métadonnées du fichier : " + filePath + " ===");

            System.out.println("Taille : " + attrs.size() + " octets");

            System.out.println("Dernière modification : "
                    + attrs.lastModifiedTime().toInstant());

            System.out.println("Est un répertoire : " + attrs.isDirectory());

            System.out.println("Est un fichier : " + attrs.isRegularFile());

        } catch (IOException e) {
            System.err.println(
                    "Erreur lors de la récupération des métadonnées : "
                    + e.getMessage());
        }
    }

    public static void main(String[] args) {

        String fichier =
                "C:\\Users\\PC\\eclipse-workspace\\Tp12\\data\\employes.txt";

        getFileMetadata(fichier);
    }
}
