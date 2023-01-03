package com.pxp.SQLite.demo.repository;

import com.pxp.SQLite.demo.entity.Tarefa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

    @Query("select max(s.id) from Student s")
    public Integer findMaxId();
}
