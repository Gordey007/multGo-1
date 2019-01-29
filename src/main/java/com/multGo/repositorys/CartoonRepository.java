package com.multGo.repositorys;

import com.multGo.entity.Cartoon;
import org.springframework.data.repository.CrudRepository;

public interface CartoonRepository extends CrudRepository<Cartoon, Integer> {
}
