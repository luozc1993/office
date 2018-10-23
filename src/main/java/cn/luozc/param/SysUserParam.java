package cn.luozc.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@ToString
public class SysUserParam {


    private Integer id;

    @NotBlank(message = "用户名不能为空")
    @Length(max = 20, min = 3, message = "账号长度需要在3-20个字之间")
    private String userName;


    @NotBlank(message = "手机号不能为空")
    private String telPhone;

    private  String userSex;//性别

    private int userStatus;//用户状态

    private String userDesc;//用户简介

}
