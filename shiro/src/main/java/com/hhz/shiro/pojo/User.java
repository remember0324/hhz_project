package com.hhz.shiro.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;


@Data
@TableName("tb_user")
public class User extends Model<User> {

    //设置按照数据库自增长
    @TableId(type = IdType.AUTO)
    private Long id;

    //下划线可自动转驼峰命名 这里可以不写
    @TableField(value = "user_name")
    private String userName;

    //查询时不返回该字段的值
    //fill =FieldFill.INSERT  对插入密码的时候可以进行填充
    @TableField(select = false, fill = FieldFill.INSERT)
    private String password;

    private String name;

    private Integer age;

    //字段名与数据库名不一致
    @TableField(value = "email")
    private String mail;

    //忽略在数据库的字段
    @TableField(exist = false)
    private String address;

    //添加版本信息__乐观锁
    @Version
    private Integer version;

    //逻辑删除
    @TableLogic
    private Integer deleted;

}