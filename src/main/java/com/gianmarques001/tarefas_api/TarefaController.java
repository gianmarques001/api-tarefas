package com.gianmarques001.tarefas_api;


import com.gianmarques001.tarefas_api.comando.*;
import com.gianmarques001.tarefas_api.dtos.SubTarefaUpdateRequestDTO;
import com.gianmarques001.tarefas_api.dtos.TarefaRequestDTO;
import com.gianmarques001.tarefas_api.dtos.TarefaResponseDTO;
import com.gianmarques001.tarefas_api.mapper.TarefaMapper;
import com.gianmarques001.tarefas_api.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;


    // Listar todas as tarefas
    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas() {
        ListarCommand listarCommand = new ListarCommand(tarefaService);
        List<Tarefa> tarefas = listarCommand.executar();
        return ResponseEntity.ok().body(tarefas);
    }

    // Listar uma tarefa pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable String id) {
        BuscarCommand buscarCommand = new BuscarCommand(id, tarefaService);
        Tarefa tarefa = buscarCommand.executar();
        return ResponseEntity.ok().body(tarefa);
    }

    // Criar uma tarefa
    @PostMapping
    public ResponseEntity<TarefaResponseDTO> salvar(@Valid @RequestBody TarefaRequestDTO tarefaRequestDTO) {
        Tarefa tarefa = TarefaMapper.toEntity(tarefaRequestDTO);
        SalvarCommand salvar = new SalvarCommand(tarefa, tarefaService);
        salvar.executar();
        return ResponseEntity.status(201).body(new TarefaResponseDTO("Tarefa criada com sucesso"));
    }

    // Deletar uma tarefa pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        DeletarCommand deletarCommand = new DeletarCommand(id, tarefaService);
        deletarCommand.executar();
        return ResponseEntity.status(204).build();
    }

    // Deletar uma subtarefa pelo ID
    @DeleteMapping("/{idTarefa}/{idSubTarefa}")
    public ResponseEntity<Void> deletar(@PathVariable String idTarefa, @PathVariable String idSubTarefa) {
        DeletarCommand deletarCommand = new DeletarCommand(idTarefa, idSubTarefa, tarefaService);
        deletarCommand.executar();
        return ResponseEntity.status(204).build();
    }

    
    // Editar uma tarefa pelo ID

    @PatchMapping("/{idTarefa}")
    public ResponseEntity<Void> editar(@PathVariable String idTarefa, @RequestBody SubTarefaUpdateRequestDTO subTarefaUpdateDTO) {
        SubTarefa subTarefa = TarefaMapper.toEntitySubTarefa(subTarefaUpdateDTO);
        EditarCommand editarCommand = new EditarCommand(idTarefa, subTarefa, tarefaService);
        editarCommand.executar();
        return ResponseEntity.status(204).build();
    }

    // Editar uma subtarefa pelo ID
    @PatchMapping("/{idTarefa}/{idSubTarefa}")
    public ResponseEntity<Void> editar(@PathVariable String idTarefa, @PathVariable String idSubTarefa, @RequestBody SubTarefaUpdateRequestDTO subTarefaUpdateDTO) {
        SubTarefa subTarefa = TarefaMapper.toEntitySubTarefa(subTarefaUpdateDTO);
        EditarCommand editarCommand = new EditarCommand(idTarefa, idSubTarefa, subTarefa, tarefaService);
        editarCommand.executar();
        return ResponseEntity.status(204).build();
    }
}
