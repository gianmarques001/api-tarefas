package com.gianmarques001.tarefas_api.dtos;

import jakarta.validation.constraints.NotBlank;

public record SubTarefaUpdateRequestDTO(@NotBlank String descricao, boolean concluido) {
}
