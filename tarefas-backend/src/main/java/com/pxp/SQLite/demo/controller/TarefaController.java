package com.pxp.SQLite.demo.controller;

import com.pxp.SQLite.demo.entity.Tarefa;
import com.pxp.SQLite.demo.service.TarefaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin()
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

    @RequestMapping(value = "tarefa/{id}/realizar", method = RequestMethod.PATCH)
    public String realizarTarefa(@PathVariable("id") int id) {
        return tarefaService.updateTarefaRealizada(id, true);
    }

    @RequestMapping(value = "tarefa/{id}/undoRealizar", method = RequestMethod.PATCH)
    public String undoRealizarTarefa(@PathVariable("id") int id) {
        return tarefaService.updateTarefaRealizada(id, false);
    }

    @RequestMapping(value = "tarefa/{id}", method = RequestMethod.DELETE)
    public String deleteTarefa(@PathVariable("id") int id) {
        return tarefaService.deleteTarefa(id);
    }
}
