package cn.luozc.modules.system.model;

import java.util.List;

public class User {
    private String uid;

    private String username;

    private String password;

    private String nickName;

    private String avatar;

    private String sex;

    private String phone;

    private String email;

    private Boolean emailverified;

    private Boolean state;

    private String opuser;

    private Long createTime;

    private Long updateTime;

    private List<Role> roles;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Boolean getEmailverified() {
        return emailverified;
    }

    public void setEmailverified(Boolean emailverified) {
        this.emailverified = emailverified;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getOpuser() {
        return opuser;
    }

    public void setOpuser(String opuser) {
        this.opuser = opuser == null ? null : opuser.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}