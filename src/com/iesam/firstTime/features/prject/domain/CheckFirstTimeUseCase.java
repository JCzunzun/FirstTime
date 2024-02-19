package com.iesam.firstTime.features.prject.domain;

import com.iesam.firstTime.features.prject.data.AppStateDataRepository;

import java.io.File;

public class CheckFirstTimeUseCase {
private AppStateDataRepository appStateDataRepository;

    public CheckFirstTimeUseCase(AppStateDataRepository appStateDataRepository) {
        this.appStateDataRepository = appStateDataRepository;
    }
    public boolean isFirstTime(File file){
        appStateDataRepository.incrementCount();
        return appStateDataRepository.firstTime();
    }

}
