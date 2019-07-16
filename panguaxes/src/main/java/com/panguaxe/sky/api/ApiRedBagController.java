package com.panguaxe.sky.api;

import com.panguaxe.sky.annotation.Authorization;
import com.panguaxe.sky.annotation.CurrentUser;
import com.panguaxe.sky.common.APIResult;
import com.panguaxe.sky.enums.GlobalEnums;
import com.panguaxe.sky.land.model.Account;
import com.panguaxe.sky.land.model.RedBag;
import com.panguaxe.sky.land.service.IRedBagService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Title RedBagController
 * @Description // TODO             红包模块API
 * @Author 作者：Panguaxe
 * @Version: 1.0
 * @Date 2019/7/12 11:26
 **/
@RestController
@RequestMapping("/api/")
public class ApiRedBagController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiRedBagController.class);

    @Autowired
    private IRedBagService redBagService;

    /**
     * @MethodName:  dispenseRedBag
     * @Param:       [request, account, redBag, imgs, video, bindingResult]
     * @Return:      com.panguaxe.sky.common.APIResult
     * @Author:      Panguaxe
     * @Date:        2019/7/12 21:24
     * @Description: TODO               发红包
     */
    @Authorization
    @PostMapping("dispenseRedBag.axe")
    public APIResult dispenseRedBag(HttpServletRequest request, @CurrentUser Account account, @Validated RedBag redBag, String imgs, String video, BindingResult bindingResult){
        APIResult result = new APIResult();
        if (bindingResult.hasErrors()) {
            return result.setError(bindingResult.getFieldError().getDefaultMessage());
        }
        LOGGER.info("CurrentUser信息：{}", JSONObject.fromObject(account));
        try {
            result = redBagService.dispenseRedBag(request,account,redBag,imgs,video);
        }catch (Exception e){
            LOGGER.info("👻,请联系管理员[网络异常18300665808]!{}",e.getMessage());
            result.setError(GlobalEnums.API_NETWORK_ANOMALY.getMessage());
        }
        return result;
    }
}
