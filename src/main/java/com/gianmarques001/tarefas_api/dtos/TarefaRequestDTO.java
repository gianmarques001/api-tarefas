package com.gianmarques001.tarefas_api.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record TarefaRequestDTO(@NotBlank String titulo, List<SubTarefaRequestDTO> subTarefas) {
}
