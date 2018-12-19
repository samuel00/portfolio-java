package org.portfolio.java.core.transfer.repository;

import java.util.List;

import org.portfolio.java.core.comum.BaseRepositorio;
import org.portfolio.java.core.transfer.model.Transferencia;
import org.springframework.stereotype.Repository;

@Repository
public class TransferenciaRepositorio extends BaseRepositorio<Object, Long>{

	@SuppressWarnings("unchecked")
	public List<Transferencia> getAgendamentos() {
		return getEntityManager().createQuery("SELECT T FROM Transferencia T").getResultList();		
	}

}
