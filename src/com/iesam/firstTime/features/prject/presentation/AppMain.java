package com.iesam.firstTime.features.prject.presentation;

import com.iesam.firstTime.features.prject.domain.AppState;
import com.iesam.firstTime.features.prject.domain.CheckFirstTimeUseCase;
import com.iesam.firstTime.features.prject.domain.DeleteFileUseCase;
import com.iesam.firstTime.features.prject.domain.MarkAsNotFirstTimeUseCase;
import com.iesam.firstTime.features.prject.data.AppStateDataRepository;
import java.util.Scanner;

public class AppMain {
    private static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        // Crear las instancias necesarias
        AppStateDataRepository appStateDataRepository = AppStateDataRepository.newInstance();
        CheckFirstTimeUseCase checkFirstTimeUseCase = new CheckFirstTimeUseCase(appStateDataRepository);
        MarkAsNotFirstTimeUseCase markAsNotFirstTimeUseCase = new MarkAsNotFirstTimeUseCase(appStateDataRepository);
        DeleteFileUseCase deleteFileUseCase= new DeleteFileUseCase(appStateDataRepository);

        // Verificar si es la primera vez
        if (checkFirstTimeUseCase.isFirstTime()) {
            System.out.println("Primera vez");
            // Marcar como no siendo la primera vez
            markAsNotFirstTimeUseCase.markAsNoFirstTime();
        } else {
            System.out.println("No es la primera vez");
        }
        // Incrementar el contador
        appStateDataRepository.incrementCounter();
        int counter = appStateDataRepository.getOpenCount();

        // Verificar si se debe mostrar el mensaje de votación
        if (counter > 0 && counter % 10 == 0) {
            System.out.println("¡Gracias por usar la aplicación! ¿Te gustaría votar por ella?");
        }
        //borrar fichero
        if(counter % 10 == 0){
            System.out.println("Desea borrar el archivo para reiniciar la app?");
            if(sc.next().toLowerCase().equals("si")){
                deleteFileUseCase.deleteFile();
            }
        }

    }
}
