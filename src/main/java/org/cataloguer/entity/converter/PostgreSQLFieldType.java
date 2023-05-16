package org.cataloguer.entity.converter;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


public class PostgreSQLFieldType implements UserType<FieldType> {

    @Override
    public int getSqlType() {
        return Types.VARCHAR;
    }

    @Override
    public Class<FieldType> returnedClass() {
        return FieldType.class;
    }

    @Override
    public boolean equals(FieldType x, FieldType y) {
        return x == y;
    }

    @Override
    public int hashCode(FieldType x) {
        return x.hashCode();
    }

    @Override
    public FieldType nullSafeGet(ResultSet rs, int position,
                                 SharedSessionContractImplementor session,
                                 Object owner) throws SQLException {
        String code = rs.getString(position);
        return (!rs.wasNull()) ? FieldType.fromCode(code) : null;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, FieldType value, int index,
                            SharedSessionContractImplementor session) throws SQLException {
        if (value != null) {
            st.setObject(index, value.getCode(), Types.OTHER);
        } else {
            st.setNull(index, Types.OTHER);
        }
    }

    @Override
    public FieldType deepCopy(FieldType value) {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(FieldType value) {
        return null;
    }

    @Override
    public FieldType assemble(Serializable cached, Object owner) {
        return null;
    }

    @Override
    public FieldType replace(FieldType detached, FieldType managed, Object owner) {
        return detached;
    }
}
