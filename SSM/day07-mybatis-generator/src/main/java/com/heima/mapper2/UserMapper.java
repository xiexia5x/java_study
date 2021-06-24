package com.heima.mapper2;

import com.heima.pojo2.User;
import java.util.Date;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({
        "delete from tb_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into tb_user (id, user_name, ",
        "sex, birthday, ",
        "created, modified)",
        "values (#{id,jdbcType=BIGINT}, #{userName,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=TINYINT}, #{birthday,jdbcType=TIMESTAMP}, ",
        "#{created,jdbcType=TIMESTAMP}, #{modified,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @Select({
        "select",
        "id, user_name, sex, birthday, created, modified",
        "from tb_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="user_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="sex", javaType=Byte.class, jdbcType=JdbcType.TINYINT),
        @Arg(column="birthday", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="created", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="modified", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(Long id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update tb_user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=TINYINT},",
          "birthday = #{birthday,jdbcType=TIMESTAMP},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "modified = #{modified,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}