package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Tarefa;
import com.pxp.SQLite.demo.service.TarefaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "A aplicação está online...";
    }

    @RequestMapping(value = "tarefa", method = RequestMethod.POST)
    public String createTarefa(@RequestBody Tarefa tarefa) {
        return tarefaService.createTarefa(tarefa);
    }

    @RequestMapping(value = "tarefa", method = RequestMethod.GET)
    public List<Tarefa> readTarefas() {
        return tarefaService.readTarefas();
    }

    @RequestMapping(value = "tarefa/{id}", method = RequestMethod.PATCH)
    public String updateTarefa(@PathVariable("id") int id, @RequestBody Boolean realizada) {
        return tarefaService.updateTarefaRealizada(id, realizada);
    }

    @RequestMapping(value = "tarefas", method = RequestMethod.DELETE)
    public String deleteTarefa(@RequestBody int id) {
        return tarefaService.deleteTarefa(id);
    }
}
