package org.portfolio.java.core.status.service;

import org.portfolio.java.core.status.model.StatusDTO;
import org.portfolio.java.core.status.repository.StatusRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servico para informar o status do sistema utilizando a busca pela data atual
 * do banco de dados
 *
 */
@Service
public class StatusServico {

    @Autowired
    private StatusRepositorio statusRepositorio;

    @Transactional
    public StatusDTO obterStatus() {
        return this.statusRepositorio.buscarStatus();
    }
}
