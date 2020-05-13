package com.rokey.myshop.service.impl;

import com.rokey.myshop.mapper.UmsMemberMapper;
import com.rokey.myshop.redis.RedisService;
import com.rokey.myshop.service.UmsMemberCacheService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/5/12 5:54 下午
 * @description：UmsMemberCacheService实现类
 */
@Service
public class UmsMemberCacheServiceImpl implements UmsMemberCacheService {
    @Resource
    private RedisService redisService;
    @Resource
    private UmsMemberMapper memberMapper;
    @Value("${redis.database}")
    private String REDIS_DATABASE;
    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;
    @Value("${redis.expire.authCode}")
    private Long REDIS_EXPIRE_AUTH_CODE;
    @Value("${redis.key.member}")
    private String REDIS_KEY_MEMBER;
    @Value("${redis.key.authCode}")
    private String REDIS_KEY_AUTH_CODE;

    @Override
    public void setAuthCode(String telephone, String authCode) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_AUTH_CODE + ":" +telephone;
        redisService.set(key, authCode, REDIS_EXPIRE_AUTH_CODE);
    }

    @Override
    public String getAuthCode(String telephone) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_AUTH_CODE + ":" + telephone;
        return (String) redisService.get(key);
    }
}
