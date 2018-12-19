package org.portfolio.java.core.comum;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Classe com comportamentos comuns para todos os repositorios.
 *
 * @param <T>
 * @param <ID>
 */
public class BaseRepositorio<T, ID> {

    @PersistenceContext(unitName = "transferencia-eletronica-PU")
    private EntityManager entityManager;

    protected void aplicarParametros(Query query, Map<String, Object> parametros) {
        for (Entry<String, Object> parametro : parametros.entrySet()) {
            query.setParameter(parametro.getKey(), parametro.getValue());
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected List<Integer> normalizarColecaoDeNumerosInteiros(List<? extends Number> numeros) {

        List<Integer> inteiros = new ArrayList<>();
        for (Number numero : numeros) {
            if (numero != null) {
                inteiros.add(numero.intValue());
            } else {
                inteiros.add(null);
            }
        }
        return inteiros;
    }

    public T salvar(T objeto) {
        this.entityManager.persist(objeto);
        return objeto;
    }

    public T atualizar(T objeto) {
        this.entityManager.merge(objeto);
        return objeto;
    }

    public void remover(T objeto) {
        this.entityManager.remove(objeto);
    }

    public void refresh(T objeto) {
        this.entityManager.refresh(objeto);
    }
	
	@SuppressWarnings("unchecked")
    public T buscarPorId(ID id) {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        Class<T> entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
        return this.entityManager.find(entityClass, id);
    }
	
	
	
}
