package org.portfolio.java.core.transfer.service;

import org.portfolio.java.core.comum.*;
import org.portfolio.java.core.transfer.model.Transferencia;
import org.portfolio.java.core.transfer.model.TransferenciaDTO;
import org.portfolio.java.core.transfer.repository.TransferenciaRepositorio;
import org.portfolio.java.core.transfer.util.TransferenciaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class TransferenciaServico {

	@Autowired
	private TransferenciaRepositorio transferenciaRepositorio;

	@Transactional
	public HTTPResponse criarTransferencia(TransferenciaDTO transferenciaDTO) {
		Double valorTaxa = TransferenciaUtil.calcularTaxa(transferenciaDTO);
		if (Objects.nonNull(valorTaxa)) {
			Transferencia transferencia = new Transferencia(transferenciaDTO, valorTaxa);
			transferenciaRepositorio.salvar(transferencia);
			return new HTTPResponse(HttpStatus.CREATED);
		}
		return new HTTPResponse(PropriedadesValidacao.getMensagen(PropriedadesValidacao.SEM_TAXA), HttpStatus.BAD_REQUEST,
		                        HttpStatus.BAD_REQUEST.value());

	}

	public List<Transferencia> getAgendamentos() throws ExcecaoGenerica {
		try {
			List<Transferencia> transferencias = transferenciaRepositorio.getAgendamentos();
			if (transferencias == null) {
				throw new ExcecaoGenerica(HttpStatus.NOT_FOUND, PropriedadesValidacao.getMensagen(PropriedadesValidacao.SEM_AGENDAMENTO));
			}
			return transferencias;
		} catch (ExcecaoGenerica e) {
			throw e;
		}

	}

}
