/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Eric Farias
 * @since 27/02/2016
 */
public class PilhaTest {
    
    @Test(expected = NegativeArraySizeException.class)
    public void testVetorDeTamanhoNegativo(){
        Pilha p = new Pilha(-3);
    }
    
    @Test
    public void testVatorComTamanhoValido(){
        Pilha p = new Pilha(3);
        Assert.assertEquals(3, p.getStackSize());
    }
    
    @Test(expected = StackOverflowError.class)
    public void testEstouroDePilha(){
        Pilha p = new Pilha(10);
        for(int i = 0; i < 11; i++){
            p.add(23);
        }
    }
    
    @Test
    public void testValorMaximo(){
        Pilha p = new Pilha(10);
        p.add(1);
        p.add(2);
        p.add(1000);
        p.add(30);
        p.add(500);
        
        Assert.assertEquals(1000,p.getMaxValue());
    }
    
    @Test
    public void testValorMinimo(){
        Pilha p = new Pilha(10);
        p.add(1);
        p.add(2);
        p.add(1000);
        p.add(30);
        p.add(500);
        
        Assert.assertEquals(1,p.getMinValue());
    }
    
    @Test
    public void testTrocaMaiorValor(){
        Pilha p = new Pilha(10);
        p.add(1);
        p.add(2);
        p.add(1000);
        p.add(30);
        p.add(5000);
        
        System.out.println("Listas.PilhaTest.testTrocaMaiorValor() --> Valor Removido = " + p.remove());
        
        Assert.assertEquals(1000,p.getMaxValue());
    }
    
    @Test
    public void testTrocaDoMenorValor(){
        Pilha p = new Pilha(10);
        p.add(7);
        p.add(2);
        p.add(1000);
        p.add(30);
        p.add(500);
        p.add(1);
        
        p.remove();
        
        Assert.assertEquals(2,p.getMinValue());
    }
}
