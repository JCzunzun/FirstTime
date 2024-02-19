package com.iesam.firstTime.features.prject.domain;

import com.iesam.firstTime.features.prject.data.AppStateDataRepository;

import java.io.File;

public class UpdatesFileUseCase {
    private AppStateDataRepository appStateDataRepository;

    public UpdatesFileUseCase(AppStateDataRepository appStateDataRepository) {
        this.appStateDataRepository = appStateDataRepository;
    }
    public void Delete(String name){
        appStateDataRepository.deleteFile(name);
    }
    public void saveFile(File name){
         appStateDataRepository.saveFile(name);
    }
    public void update(File file){
        appStateDataRepository.update(file);
    }
    public void incrementCount(){
        appStateDataRepository.incrementCount();
    }
    public int getCount(){
        return appStateDataRepository.getCount();
    }
}
