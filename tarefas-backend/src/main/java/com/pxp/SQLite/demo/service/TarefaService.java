package com.pxp.SQLite.demo.service;

import com.pxp.SQLite.demo.entity.Tarefa;
import com.pxp.SQLite.demo.repository.TarefaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    @Transactional
    public String createTarefa(Tarefa tarefa) {
        try {
            tarefa.setId(null == tarefaRepository.findMaxId() ? 0 : tarefaRepository.findMaxId() + 1);
            tarefaRepository.save(tarefa);
            return "Tarefa criada com sucesso!";

        } catch (Exception e) {
            throw e;
        }
    }

    public List<Tarefa> readTarefas() {
        return tarefaRepository.findAll();
    }

    @Transactional
    public String updateTarefaRealizada(int id, Boolean realizada) {
        try {
            Tarefa tarefa = tarefaRepository.getOne(id);
            tarefa.setRealizada(realizada);
            tarefaRepository.save(tarefa);
            return "Tarefa atualizada com sucesso!";
        } catch (Exception e) {
            throw e;
        }

    }

    @Transactional
    public String deleteTarefa(int id) {
        try {
            Tarefa tarefa = tarefaRepository.getOne(id);
            tarefaRepository.delete(tarefa);
            return "Tarefa removida com sucesso!";
        } catch (Exception e) {
            throw e;
        }

    }

}
