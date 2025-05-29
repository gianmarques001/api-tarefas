package com.gianmarques001.tarefas_api;

import com.gianmarques001.tarefas_api.entity.SubTarefa;
import com.gianmarques001.tarefas_api.entity.Tarefa;
import com.gianmarques001.tarefas_api.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TarefasApiApplication implements CommandLineRunner {

    @Autowired
    TarefaRepository tarefaRepository;

    public static void main(String[] args) {
        SpringApplication.run(TarefasApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        tarefaRepository.deleteAll();

        List<SubTarefa> subTarefa1 = new ArrayList<>();
        subTarefa1.add(new SubTarefa("Descrição Tarefa 1.1"));
        subTarefa1.add(new SubTarefa("Descrição Tarefa 1.2"));

        List<SubTarefa> subTarefa2 = new ArrayList<>();
        subTarefa2.add(new SubTarefa("Descrição Tarefa 2.0"));
        subTarefa2.add(new SubTarefa("Descrição Tarefa 2.1"));

        List<SubTarefa> subTarefa3 = new ArrayList<>();
        subTarefa3.add(new SubTarefa("Descrição Tarefa 3.0"));
        subTarefa3.add(new SubTarefa("Descrição Tarefa 3.1"));

        tarefaRepository.save(new Tarefa("Tarefa 1", subTarefa1));
        tarefaRepository.save(new Tarefa("Tarefa 2", subTarefa2));
        tarefaRepository.save(new Tarefa("Tarefa 3", subTarefa3));


        System.out.println("Listando todas as tarefas");
        for (Tarefa tarefa : tarefaRepository.findAll()) {
            System.out.println(tarefa);
        }
        System.out.println();
        // Buscando uma Tarefa
        Tarefa tarefa = tarefaRepository.findByTitulo("Tarefa 1");


        tarefa.getSubTarefas().forEach(System.out::println);
        SubTarefa subTarefaDaTarefa1 = tarefa.getSubTarefas().get(0);

        subTarefaDaTarefa1.setDescricao("Nova Descrição");

        tarefaRepository.save(tarefa);
    }
}
