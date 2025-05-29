package com.gianmarques001.tarefas_api.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Setter
@Getter
public class SubTarefa {

    @Id()
    private String id;

    private String descricao;

    private boolean concluido;

    public SubTarefa() {
    }

    public SubTarefa(String descricao) {
        this.id = UUID.randomUUID().toString();
        this.descricao = descricao;
        this.concluido = false;
    }

    public SubTarefa(String descricao, boolean concluido) {
        this.id = UUID.randomUUID().toString();
        this.descricao = descricao;
        this.concluido = concluido;
    }

    @Override
    public String toString() {
        return "SubTarefa" + "id='" + id + '\'' +
                ", descricao='" + descricao + '\'';
    }
}
