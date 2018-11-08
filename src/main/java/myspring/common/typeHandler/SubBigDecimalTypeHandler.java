package myspring.common.typeHandler;

import org.apache.ibatis.type.BigDecimalTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zhujiameng
 * @create 2018-11-07 19:59
 **/
@MappedJdbcTypes(JdbcType.NUMERIC)//
public class SubBigDecimalTypeHandler extends BigDecimalTypeHandler {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BigDecimal parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setBigDecimal(i, parameter);
    }

    @Override
    public BigDecimal getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        return super.getNullableResult(rs,columnName).setScale(2,BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public BigDecimal getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        return super.getNullableResult(rs,columnIndex).setScale(2,BigDecimal.ROUND_HALF_UP);
        //return rs.getBigDecimal(columnIndex);
    }

    @Override
    public BigDecimal getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        return super.getNullableResult(cs,columnIndex).setScale(2,BigDecimal.ROUND_HALF_UP);
       // return cs.getBigDecimal(columnIndex);
    }
}
