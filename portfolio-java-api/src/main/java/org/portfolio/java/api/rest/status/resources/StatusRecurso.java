package org.portfolio.java.api.rest.status.resources;

import org.portfolio.java.core.comum.PropriedadesCore;
import org.portfolio.java.core.status.model.StatusDTO;
import org.portfolio.java.core.status.service.StatusServico;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * Recurso para informar versao corrente da aplicacao (nao da API) e o status do servico.
 *
 */
@RestController
@RequestMapping("/public")
public class StatusRecurso {

    final Logger logger = LoggerFactory.getLogger(StatusRecurso.class);

    @Autowired
    private StatusServico statusServico;

    @RequestMapping(value = "/versao", method = RequestMethod.GET, produces = { "application/text" })
    public ResponseEntity<String> versaoDoProjeto(HttpServletRequest request){
        return new ResponseEntity<>(PropriedadesCore.getVersao(), HttpStatus.OK);
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity<StatusDTO> buscarStatus(){
            StatusDTO statusDTO = statusServico.obterStatus();
            return new ResponseEntity<StatusDTO>(statusDTO, HttpStatus.OK);
    }
}
