package com.multGo.repositorys;

import com.multGo.entity.Cartoon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface CartoonRepository extends CrudRepository<Cartoon, Integer> {

    Collection<Cartoon> getCartoonBySeason(Integer season);

    @Query(value = "select max(season) from cartoons where name_cartoon = :name", nativeQuery = true)
    int getSeasons(@Param("name") String name);
}
