package com.iesam.firstTime.features.prject.domain;

import com.iesam.firstTime.features.prject.data.AppStateDataRepository;

public class MarkAsNotFirstTimeUseCase {
    private AppStateDataRepository appStateDataRepository;

    public MarkAsNotFirstTimeUseCase(AppStateDataRepository appStateDataRepository) {
        this.appStateDataRepository = appStateDataRepository;
    }

    public void markAsNoFirstTime() {
        appStateDataRepository.markAsNotFirstTime();
        appStateDataRepository.incrementOpenCount();
    }
}
