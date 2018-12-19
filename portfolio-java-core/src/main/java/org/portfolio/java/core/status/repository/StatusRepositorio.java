package org.portfolio.java.core.status.repository;

import java.util.Date;

import org.portfolio.java.core.comum.BaseRepositorio;
import org.portfolio.java.core.status.model.StatusDTO;
import org.springframework.stereotype.Repository;

/**
 * Classe para retornar a data/hora do banco de dados, com o objetivo de servir
 * como status de conexao/funcionado do banco de dados.
 *
 */
@Repository
public class StatusRepositorio extends BaseRepositorio<StatusDTO, Long> {
    public StatusDTO buscarStatus() {
        
        StatusDTO statusDTO = new StatusDTO("OK", new Date());
        return statusDTO;
    }
}
