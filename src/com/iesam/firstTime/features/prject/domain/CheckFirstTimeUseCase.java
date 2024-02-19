package com.iesam.firstTime.features.prject.domain;

import com.iesam.firstTime.features.prject.data.AppStateDataRepository;

public class CheckFirstTimeUseCase {
private AppStateDataRepository appStateDataRepository;

    public CheckFirstTimeUseCase(AppStateDataRepository appStateDataRepository) {
        this.appStateDataRepository = appStateDataRepository;
    }
    public boolean isFirstTime(){

        return appStateDataRepository.isFirstTime();
    }

}
