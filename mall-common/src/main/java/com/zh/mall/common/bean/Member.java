package com.zh.mall.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 会员用户对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private Integer id;
    private String loginacct;
    private String memberpswd;
    private String nickname;
    private String avatar;
    private String loginstatus;
    private String authstatus;
    private String sellerstatus;
    private String lockstatus;
    private String regtime;
    private String lastvisittime;

}
