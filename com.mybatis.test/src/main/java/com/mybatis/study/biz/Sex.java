package com.mybatis.study.biz;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author quanying
 * @version Id: Sex, v 0.1 2020/10/10 下午5:52 Exp $
 * @description
 */
@Getter
@AllArgsConstructor
public enum Sex {
    NONE(0, "未知"), MAN(1, "未知"), FEMALE(2, "未知"),;

    private Integer code;
    private String desc;


    public static Sex getByCode(Integer code) {
        return Arrays.stream(Sex.values()).filter(sa -> sa.getCode().equals(code)).findFirst().orElse(NONE);
    }
}
