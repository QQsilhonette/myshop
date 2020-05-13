package com.rokey.myshop.service;

import com.rokey.myshop.common.api.CommonResult;

/**
 * 会员管理Service
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     */
    String generateAuthCode(String telephone);
    /**
     * 校验验证码
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
