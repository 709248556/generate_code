package com.example.generate_code;

import com.autumn.domain.entities.AbstractDefaultEntity;
import com.autumn.domain.entities.auditing.SoftDelete;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description:用户表
 * @author: yanlianglong
 * @create: 2020-06-03 14:24
 **/
@ToString(callSuper = true)
@Getter
@Setter
@Table(name = "sp_user")
public class User extends AbstractDefaultEntity implements SoftDelete {

    private static final long serialVersionUID = -792535174367812840L;

    @GeneratedValue(strategy = GenerationType.TABLE)
    @Override
    public Long getId() {
        return super.getId();
    }
    /**
     * id
     */
    private Long id;

    /**
     * mobile
     */
    private String mobile;

    /**
     * user_name
     */
    private String userName;

    /**
     * password
     */
    private String password;

    /**
     * area
     */
    private String area;

    /**
     * 状态，0：初始化，1：正常，2：禁用
     */
    private Integer userStatus;

    /**
     * 微信昵称
     */
    private String nickname;

    /**
     * openid
     */
    private String openid;

    /**
     * unionid
     */
    private String unionid;

    /**
     * province
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 国家
     */
    private String country;

    /**
     * 微信头像
     */
    private String headimgurl;

    /**
     * 值为1时是男性，值为2时是女性，值为0时是未知
     */
    private Integer sex;

    /**
     * ungrant：未授权，granted：已授权
     */
    private String wxStatus;

    /**
     * 积分数量
     */
    private Integer integralNum;

    /**
     * 注册渠道，1：网站，2：微信
     */
    private Integer type;

    /**
     * 是否删除
     */
    private boolean delete;

    /**
     * created_at
     */
    private Date createdAt;

    /**
     * updated_at
     */
    private Date updatedAt;

    /**
     * 身份，member：会员，志愿者：volunteer，科技工作者：worker
     */
    private String identity;

}
