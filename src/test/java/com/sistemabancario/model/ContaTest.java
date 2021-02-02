package com.sistemabancario.model;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {

    //R01
    @Test
    void testSetNumeroValido() {
        final Conta instance = new Conta();
        final String esperado = "12345-6";
        instance.setNumero(esperado);
        final String obtido = instance.getNumero();
        assertEquals(esperado, obtido);
    }

    //R01
    @Test
    void testSetNumeroInvalidoNaoArmazena() {
        final Conta instance = new Conta();
        final String invalido = "123";
        assertThrows(IllegalArgumentException.class, () -> instance.setNumero(invalido));
        final String obtido = instance.getNumero();
        assertNotEquals(invalido,obtido);
    }
    
    //R02
    @Test
    void testInstanciaPadraoPoupanca() {
        final Conta instance = new Conta();
        assertFalse(instance.isPoupanca());
    }
    
    //R03
    @Test
    void testSetLimiteContaEspecial() {
        final Conta instance = new Conta();
        instance.setEspecial(true);
        final double esperado = 1000;
        instance.setLimite(esperado);
        final double obtido = instance.getLimite();
        assertEquals(esperado, obtido);
    }
    
    //R03
    @Test
    void testSetLimiteContaNaoEspecial() {
        final Conta instance = new Conta();
        final double limite = 1000;
        assertThrows(IllegalArgumentException.class, () -> instance.setLimite(limite));
    }
    
    //R04
    @Test
    void testHistoricoNotNull() {
        final Conta instance = new Conta();
        assertNotNull(instance.getMovimentacoes());
    }

    //R06
    @Test
    void testGetSaldoTotal() {
        final double limite = 500;
        final double esperado = limite;
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        final double obtido = instance.getLimite();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testDepositoDinheiro() {
        final double limite = 500.6, deposito = 500.8, esperado = 1001.4;
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        instance.depositoDinheiro(deposito);
        final double obtido = instance.getSaldoTotal();
        assertEquals(esperado, obtido, 0.001);
    }
    
    @Test
    void testDepositoDinheiroMenorQueZero() {
        final double limite = 500, deposito = -400;
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        assertThrows(IllegalArgumentException.class, () -> instance.depositoDinheiro(deposito));
    }
    
    @Test
    void testDepositoDinheiroTipoC() {
        final Conta instance = new Conta();
        instance.depositoDinheiro(550);
        final List <Movimentacao> movimentacoes = instance.getMovimentacoes();
        final Movimentacao movimentacao = movimentacoes.get(movimentacoes.size()-1);
        final char esperado = 'C';
        final char obtido = movimentacao.getTipo() ;
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testDepositoDinheiroConfirmado() {
        final Conta instance = new Conta();
        instance.depositoDinheiro(550);
        final List<Movimentacao> movimentacoes = instance.getMovimentacoes();
        final Movimentacao movimentacao = movimentacoes.get(movimentacoes.size()-1);
        final boolean esperado = true;
        final boolean obtido = movimentacao.isConfirmada();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testDepositoDinheiroValorAtribuido() {
        final Conta instance = new Conta();
        instance.depositoDinheiro(550);
        final List<Movimentacao> movimentacoes = instance.getMovimentacoes();
        final Movimentacao movimentacao = movimentacoes.get(movimentacoes.size()-1);
        final double esperado = 550;
        final double obtido = movimentacao.getValor();
        assertEquals(esperado, obtido);
    }

    /*@Test
    void testDepositoDinheiroAddListaMovimentacao() {
        final Conta instance = new Conta();
        assertThrows(IllegalStateException.class, () -> instance.depositoDinheiro(550));
    }*/
    
    @Test
    void testAddMovimentacao() {
        //TODO: Você precisa implementar este teste
    }
        
}
