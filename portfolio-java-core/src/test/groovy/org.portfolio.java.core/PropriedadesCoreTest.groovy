package org.portfolio.java.core

import org.portfolio.java.core.comum.PropriedadesCore
import org.portfolio.java.core.comum.Resource
import spock.lang.Specification

class PropriedadesCoreTest extends Specification {

    PropriedadesCore propriedadesCoreMock

    def setup() {
        propriedadesCoreMock = Mock(PropriedadesCore)
    }

    def "deve retornar as propriedades do core"() {
        when:
        def resultVersao = propriedadesCoreMock.getVersao()
        def resultAmbiente = propriedadesCoreMock.obterPropriedade(PropriedadesCore.AMBIENTE)

        then:
        resultVersao
        resultAmbiente
    }
}