package com.iesam.firstTime.features.prject.domain;

import java.io.File;

public interface FileRepository {
    //check first tim, increment, delete file,
    boolean firstTime();
    void deleteFile(String name);
    void update(File file);
    void incrementCount();
    int getCount();
}
