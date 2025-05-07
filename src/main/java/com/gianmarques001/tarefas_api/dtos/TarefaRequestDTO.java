package com.gianmarques001.tarefas_api.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TarefaRequestDTO(@NotNull String titulo, List<SubTarefaRequestDTO> subTarefas) {
}
