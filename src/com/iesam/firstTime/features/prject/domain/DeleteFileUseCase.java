package com.iesam.firstTime.features.prject.domain;

import com.iesam.firstTime.features.prject.data.AppStateDataRepository;

public class DeleteFileUseCase {
    private AppStateDataRepository appStateDataRepository;

    public DeleteFileUseCase(AppStateDataRepository appStateDataRepository) {
        this.appStateDataRepository = appStateDataRepository;
    }
    public void deleteFile(){
        appStateDataRepository.deleteConfigFile();
    }
}
