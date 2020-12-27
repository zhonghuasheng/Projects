package com.zhonghuasheng.ms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_")
public class User {

    private Long id;
    private String name;
    private Integer age;
}
