package com.test.quarkus.dao;

import com.test.quarkus.entity.Fruit;
import com.test.quarkus.entity.mapping.FruitMapper;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@RegisterRowMapper(FruitMapper.class)
public interface FruitDao {

    @SqlUpdate("INSERT into FRUIT ( uuid, name, description ) " +
            "VALUES ( :uuid, :name, :description)")
    int add(@Bind("uuid") String uuid, @Bind("name") String name, @Bind("description") String description);

    @SqlUpdate("UPDATE FRUIT SET name = :name, description = :description " +
            "WHERE uuid = :uuid")
    int update(@Bind("uuid") String uuid, @Bind("name") String name, @Bind("description") String description);

    @SqlQuery("SELECT * FROM FRUIT WHERE uuid = :uuid")
    Fruit findById(@Bind("uuid") String uuid);

    @SqlQuery("SELECT * FROM FRUIT")
    @RegisterBeanMapper(Fruit.class)
    List<Fruit> findAll();

    @SqlUpdate("DELETE FROM FRUIT WHERE uuid = :uuid")
    int deleteById(@Bind("uuid") String uuid);
}
