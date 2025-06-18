package com.youlai.boot.utils;

import cn.hutool.captcha.generator.CodeGenerator;
import cn.hutool.core.util.StrUtil;
import com.youlai.boot.common.constant.RedisConstants;
import com.youlai.boot.common.exception.UsdtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class CaptchaUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private CodeGenerator codeGenerator;
    /**
     * 验证码校验
     */
    public Boolean checkCaptcha(String captchaCode, String captchaKey) {
        String cacheVerifyCode = (String) redisTemplate.opsForValue().get(
                StrUtil.format(RedisConstants.Captcha.IMAGE_CODE, captchaKey)
        );

        if (cacheVerifyCode == null) {
            throw new UsdtException("验证码已过期");
        } else {
            // 验证码比对
            if (codeGenerator.verify(cacheVerifyCode, captchaCode)) {
                return true;
            } else {
                throw new UsdtException("验证码错误");
            }
        }
    }
}
