package com.fengziboboy.demo.data;

import com.fengziboboy.demo.Ingredient;
import com.fengziboboy.demo.Taco;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@Repository
public class JdbcTacoReposittory implements TacoRepository {
    private JdbcTemplate jdbc;

    public JdbcTacoReposittory(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Taco save(Taco taco) {
        long tacoId = saveTacoInfo(taco);
        taco.setId(tacoId);
        for (Ingredient ingredient : taco.getIngredients()) {
            saveIngredientToTaco(ingredient, tacoId);
        }
        return taco;
    }

    @Override
    public <S extends Taco> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Taco> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Taco> findAll() {
        return null;
    }

    @Override
    public Iterable<Taco> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Taco taco) {

    }

    @Override
    public void deleteAll(Iterable<? extends Taco> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    private long saveTacoInfo(Taco taco) {
        taco.setCreateDate(new Date());
        PreparedStatementCreator psc = new PreparedStatementCreatorFactory(
                "insert into Taco (name, createDate) values (?, ?)",
                Types.VARCHAR, Types.TIMESTAMP
        ).newPreparedStatementCreator(
                Arrays.asList(
                        taco.getName(),
                        new Timestamp(taco.getCreateDate().getTime())));
        KeyHolder holder = new GeneratedKeyHolder();
        jdbc.update(psc, holder);
        return holder.getKey().longValue();
    }

    private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
        jdbc.update("insert into Taco_Ingredients (taco, ingredient) "
                        + "values (?, ?)",
                tacoId, ingredient.getId());
    }
}
