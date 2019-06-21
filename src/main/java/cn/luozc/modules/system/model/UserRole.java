package cn.luozc.modules.system.model;

import cn.luozc.common.utils.MD5Util;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.UUID;

@TableName("sys_user_role")
public class UserRole {
    private String id;

    private String uid;

    private String rid;

    @TableField("opUser")
    private String opuser;

    @TableField("create_time")
    private Long createTime;

    private Long updateTime;

    public UserRole(){}

    public UserRole(String uid,String rid,String opuser){
        this.uid = uid;
        this.rid = rid;
        this.id = MD5Util.getMD5Str(UUID.randomUUID().toString());
        this.opuser = opuser;
        this.createTime = System.currentTimeMillis()/1000;
        this.updateTime = System.currentTimeMillis()/1000;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid == null ? null : rid.trim();
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