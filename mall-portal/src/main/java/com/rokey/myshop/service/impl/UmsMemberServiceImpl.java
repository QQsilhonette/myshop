package com.rokey.myshop.service.impl;

import com.rokey.myshop.common.api.CommonResult;
import com.rokey.myshop.service.UmsMemberCacheService;
import com.rokey.myshop.service.UmsMemberService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/5/12 2:39 下午
 * @description：会员管理Service实现类
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Resource
    private UmsMemberCacheService memberCacheService;

    @Override
    public String generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<6;i++){
            sb.append(random.nextInt(10));
        }
        memberCacheService.setAuthCode(telephone,sb.toString());
        return sb.toString();
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        String realAuthCode = memberCacheService.getAuthCode(telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return CommonResult.success(null, "验证码校验成功");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }

}
