package com.zrh.face.mapper.repository;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zrh.face.entity.Face;
import com.zrh.face.mapper.IFaceMapper;
import org.springframework.stereotype.Service;

@Service
public class FaceRepository extends ServiceImpl<IFaceMapper, Face> implements IService<Face> {
}
