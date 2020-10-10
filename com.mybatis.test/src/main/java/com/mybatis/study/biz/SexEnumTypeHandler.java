package com.mybatis.study.biz;

import org.apache.ibatis.type.EnumTypeHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author quanying
 * @version Id: SexEnumTypeHandler, v 0.1 2020/10/10 下午6:06 Exp $
 * @description
 */
public class SexEnumTypeHandler extends EnumTypeHandler {

    public SexEnumTypeHandler(Class type) {
        super(type);
    }

    @Override
    public Enum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String sex = rs.getString(columnName);
        return Sex.getByCode(Integer.valueOf(sex));
    }
}
