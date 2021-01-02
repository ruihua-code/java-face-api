package com.zrh.face.service.impl;


import com.baidu.aip.face.AipFace;
import com.zrh.face.entity.Face;
import com.zrh.face.mapper.repository.FaceRepository;
import com.zrh.face.service.IFaceService;
import com.zrh.face.util.Base64Util;
import com.zrh.face.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@RequiredArgsConstructor
@Log4j2
@Service
public class FaceServiceImpl implements IFaceService {

    String appId = "23398828";
    String appKey = "jh9LUcPBtCQmBAvIQBZk9TO5";
    String secret = "ICqsCmRu50U9TdtNVnxXS7tz61bo0MvP";


    private final FaceRepository faceRepository;
    private AipFace aipFace = new AipFace(appId, appKey, secret);

    /**
     * 添新面试信息
     *
     * @param userId
     * @param filePath 图片路径
     */
    @Override
    public void addFace(String userId, String filePath) {

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<>();
        options.put("user_info", "user's info");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "NONE");
        options.put("action_type", "REPLACE");

        try {
            String image = Base64Util.encode(FileUtil.readFileByBytes(filePath));
            String imageType = "BASE64";
            String groupId = "1";
            JSONObject jsonObject = aipFace.addUser(image, imageType, groupId, userId, options);

            JSONObject result = jsonObject.getJSONObject("result");
            if (jsonObject.get("error_msg").equals("SUCCESS")) {
                log.info("成功");
                Face face = new Face();
                face.setUserId(Long.parseLong(userId));
                face.setFaceToken(result.get("face_token").toString());
                face.setGroupId(1L);
                faceRepository.save(face);
            }
        } catch (IOException e) {
            log.info(e.getMessage());
        }

    }

    /**
     * 搜索面试信息
     *
     * @param filePath 图片路径
     */
    @Override
    public void searchFace(String filePath) {
        HashMap<String, String> options = new HashMap<>();
        options.put("max_face_num", "3");
        options.put("match_threshold", "70");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "NONE");

        try {
            String image = Base64Util.encode(FileUtil.readFileByBytes(filePath));
            String imageType = "BASE64";
            String groupIdList = "1,2";

            // 人脸搜索
            JSONObject res = aipFace.search(image, imageType, groupIdList, options);
            System.out.println(res.toString(2));
        } catch (IOException e) {
            log.error(e.getMessage());
        }

    }
}
