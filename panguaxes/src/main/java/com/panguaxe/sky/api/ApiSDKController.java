package com.panguaxe.sky.api;

import com.panguaxe.sky.SDK.faceocr.utils.FaceOCRUtil;
import com.panguaxe.sky.common.APIResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;

/**
 * @Title AppSDKController
 * @Description // TODO
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/5 14:34
 **/
@RestController
@RequestMapping("/api/")
public class ApiSDKController {

    @PostMapping("faceOCR.axe")
    public APIResult faceOCR(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file, String type){
        APIResult resultAPI = new APIResult();
        try {
            boolean flag = FaceOCRUtil.dataCheck(file, type);
            if (!flag) return resultAPI.setError("请上传识别的证件或卡片");
            resultAPI = FaceOCRUtil.handleResult(type,FaceOCRUtil.post(type, file));
        } catch (Exception e) {
            resultAPI.setData(e.getMessage());
            resultAPI.setError("😱 👻,请联系管理员!");
        }
        return resultAPI;
    }
}
