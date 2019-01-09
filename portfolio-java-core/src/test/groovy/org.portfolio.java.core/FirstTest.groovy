package org.portfolio.java.core.configuracao

import org.portfolio.java.core.comum.PropriedadesCore
import spock.lang.Specification

class FirstTest extends Specification {

    PropriedadesCore propriedadesCoreMock

    def setup() {
        propriedadesCoreMock = Mock(PropriedadesCore)
    }

    def "deve retornar as propriedades do core"() {
        when:
        def resultVersao = propriedadesCoreMock.obterPropriedade(PropriedadesCore.VERSAO)
        def resultAmbiente = propriedadesCoreMock.obterPropriedade(PropriedadesCore.AMBIENTE)

        then:
        resultVersao == "0.0.1-SNAPSHOT"
        resultAmbiente == "desenvolvimento"
    }
}