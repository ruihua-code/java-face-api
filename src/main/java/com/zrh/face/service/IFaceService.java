package com.zrh.face.service;

public interface IFaceService {
    void addFace(String userId, String filePath);

    void searchFace(String filePath);
}
