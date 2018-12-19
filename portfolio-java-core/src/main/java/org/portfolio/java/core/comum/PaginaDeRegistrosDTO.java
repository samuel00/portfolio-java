package org.portfolio.java.core.comum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaginaDeRegistrosDTO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<T> registros;

    /**
     * Configuracao utilizada para buscar essa pagina de registros.
     */
    private PaginacaoDTO configuracao;

    /**
     * Total de registros encontrados.
     */
    private Long total;

    public List<Integer> getIntervaloDePaginas() {

        int pagina = configuracao.getNumeroDaPagina();

        List<Integer> intervalo = new ArrayList<>();
        intervalo.add(pagina);

        int esquerda = pagina;
        int direita = pagina;
        int totalDePaginas = getTotalDePaginas();

        boolean alternador = true;
        boolean condicaoDeParada = false;

        for (int i = 0; i < 4; i++) {
            if (alternador) {
                if (esquerda > 1) {
                    intervalo.add(0, --esquerda);
                } else if (direita < totalDePaginas) {
                    intervalo.add(++direita);
                } else {
                    condicaoDeParada = true;
                }
            } else {
                if (direita < totalDePaginas) {
                    intervalo.add(++direita);
                } else if (esquerda > 1) {
                    intervalo.add(0, --esquerda);
                } else {
                    condicaoDeParada = true;
                }
            }
            if (condicaoDeParada)
                break;
            alternador = !alternador;
        }
        return intervalo;
    }

    public int getTotalDePaginas() {
        return (int) Math.ceil((double) total / (double) configuracao.getRegistrosPorPagina());
    }

    public List<T> getRegistros() {
        if (registros == null) {
            registros = new ArrayList<>();
        }
        return registros;
    }

    public void setRegistros(List<T> registros) {
        this.registros = new ArrayList<>(registros);
    }

    public PaginacaoDTO getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(PaginacaoDTO configuracao) {
        this.configuracao = configuracao;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
