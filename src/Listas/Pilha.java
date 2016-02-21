/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

/**
 *
 * @author Eric Farias
 */

public class Pilha {
    private int []array;
    private int index;
    
    public Pilha(){
        this.array = new int[16];
        this.index = 0;
    }
    
    public Pilha(int size){
        array = new int[size];
        this.index = 0;
    }
    
    public void add(int valor){
        if(this.index <= this.array.length - 1){
            this.array[this.index] = valor;
            this.index++;
        }else{
            // add método para almentar dinamicamente o array
            System.out.print("A operação não pode ser realizada pois a pilha encontra-se cheia!");
        }
    }
    
    public int pegar(){
        int valor = this.array[this.index];
        this.array[this.index] = 0;
        this.index--;
        return valor;
    }
    
    public int maxValue(){
        int max = Integer.MIN_VALUE;
        for(int value: this.array){
            if(value > max){
                max = value;
            }
        }        
        return max;
    }
    
    public int minValue(){
        int min = Integer.MAX_VALUE;
        for(int value: this.array){
            if(value < min){
                min = value;
            }
        }
        return min;
    }
    
    public int primeiroValor(){
        return this.array[0];
    }
}
