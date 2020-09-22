package com.unicorn.unicornmultitest.cache;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: Liu Zhendong
 * @Description
 * @createTime 2020年06月01日 13:35:00
 */
@Data
@TableName("boy")
public class Boy {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private LocalDateTime birthday;
    private Integer age;

    @TableId(value = "name", type = IdType.INPUT)
    private String name;

    private boolean isAdult;
}
