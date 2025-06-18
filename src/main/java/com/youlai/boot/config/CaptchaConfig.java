package com.youlai.boot.config;

import cn.hutool.captcha.generator.CodeGenerator;
import cn.hutool.captcha.generator.MathGenerator;
import cn.hutool.captcha.generator.RandomGenerator;
import com.youlai.boot.common.constant.SysConfigConstant;
import com.youlai.boot.system.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;

/**
 * 验证码自动装配配置
 *
 * @author haoxr
 * @since 2023/11/24
 */
@Configuration
public class CaptchaConfig {

    @Autowired
    private ConfigService configService;

    /**
     * 验证码文字生成器
     *
     * @return CodeGenerator
     */
    @Bean
    public CodeGenerator codeGenerator() {
        String codeType = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_CAPTCHA_CODE_TYPE);
        int codeLength = Integer.parseInt(configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_CAPTCHA_CODE_LENGTH));
        if ("math".equalsIgnoreCase(codeType)) {
            return new MathGenerator(codeLength);
        } else if ("random".equalsIgnoreCase(codeType)) {
            return new RandomGenerator(codeLength);
        } else {
            throw new IllegalArgumentException("Invalid captcha codegen type: " + codeType);
        }
    }

    /**
     * 验证码字体
     */
    @Bean
    public Font captchaFont() {
        String fontName = configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_CAPTCHA_FONT_NAME);
        int fontSize = Integer.parseInt(configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_CAPTCHA_FONT_SIZE));
        int fontWight = Integer.parseInt(configService.getSystemConfig(SysConfigConstant.CONFIG_KEY_CAPTCHA_FONT_WEIGHT));
        return new Font(fontName, fontWight, fontSize);
    }


}
