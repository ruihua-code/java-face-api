package com.zrh.face;

import com.zrh.face.service.IFaceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaFeceApiApplicationTests {
    @Autowired
    private IFaceService iFaceService;

    @Test
    void contextLoads() {
        String filePath = "/Users/zhangruihua/downloads/ZRH00752.jpg";
        String searchFilePath = "/Users/zhangruihua/downloads/test.png";
        iFaceService.addFace("1", filePath);
        iFaceService.searchFace(searchFilePath);
    }

}
