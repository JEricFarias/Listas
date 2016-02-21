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
        //1 ponto: o código fica mais elegante assim: this.index < this.array.length stackoverflow
        //2 ponto: falta validar: valor < 0 || valor > array.length (AIOBEx)
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
    
    //no lugar de criar métodos de max e min, pois cada um deles é O(n)
    //melhor seria controlar o max e min no momento da inserção, o que tornaria
    //os métodos de max e min O(1)
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
