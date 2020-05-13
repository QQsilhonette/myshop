package com.rokey.myshop.controller;

import com.rokey.myshop.common.api.CommonResult;
import com.rokey.myshop.model.PmsBrand;
import com.rokey.myshop.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/5/12 2:37 下午
 * @description：会员登录注册管理controller
 */
@Slf4j
@Api(tags="UmsMemberController")
@Controller
@RequestMapping("/sso")
public class UmsMemberController {
    @Resource
    private UmsMemberService memberService;

    @ApiOperation(value = "获取验证码", notes="获取验证码")
    @RequestMapping(value="getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone) {
        String authCode = memberService.generateAuthCode(telephone);
        return CommonResult.success(authCode, "获取验证码成功");
    }

    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult verifyAuthCode(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone,authCode);
    }
}
