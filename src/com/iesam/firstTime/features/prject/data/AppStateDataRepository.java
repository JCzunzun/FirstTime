package com.iesam.firstTime.features.prject.data;

import com.iesam.firstTime.features.prject.domain.FileRepository;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AppStateDataRepository implements FileRepository {
    private File file;
    private Scanner scanner= new Scanner(System.in);
    @Override
    public boolean firstTime() {
    System.out.println("Digite el nombre del archivo");
    file= new File(scanner.next());
        // Verificar si el archivo ya existe
        if (file.exists()) {
            return false;
        } else {
            try {
                // Crear el archivo
                if (file.createNewFile()) {
                    return true;
                } else {
                    return false;
                }
            } catch (IOException e) {
                return false;
            }
        }
    }

    @Override
    public void deleteFile(String name) {
        file=new File(name);
        // Verificar si el archivo existe antes de intentar eliminarlo
        if (file.exists()) {
            file.delete();

        } else {
            System.out.println("El archivo no existe.");
        }
    }
    @Override
    public void update(File file) {

    }

    @Override
    public void incrementCount() {

    }

    @Override
    public int getCount() {
        return 0;
    }
}
