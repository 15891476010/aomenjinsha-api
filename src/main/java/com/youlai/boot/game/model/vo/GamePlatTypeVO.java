package com.youlai.boot.game.model.vo;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 游戏平台列表视图对象
 *
 * @author MrZhang
 * @since 2025-06-15 18:49
 */
@Getter
@Setter
@Schema( description = "游戏平台列表视图对象")
public class GamePlatTypeVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Integer id;
    @Schema(description = "平台名称")
    private String platTypeName;
    @Schema(description = "平台参数")
    private String platType;
    @Schema(description = "支持的币种")
    private List<String> currencys;
    @Schema(description = "支持的游戏类型")
    private List<Integer> gameType;
    @Schema(description = "游戏代码")
    private String gameCode;
    @Schema(description = "游戏素材")
    private String gameMaterial;
    @Schema(description = "游戏素材账号")
    private String materialAccount;
    @Schema(description = "游戏素材密码")
    private String materialPwd;
    @Schema(description = "平台图标")
    private String icon;
    @Schema(description = "状态(是否维修)")
    private Boolean status;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "创建时间")
    private LocalDateTime createTime;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
}
