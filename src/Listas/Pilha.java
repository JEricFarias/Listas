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
    private int max;
    private int min;
    
    public Pilha(){
        this.array = new int[16];
        this.index = 0;
        this.max = Integer.MIN_VALUE;
        this.min = Integer.MAX_VALUE;
    }
    
    public Pilha(int size){
        this.array = new int[size];
        this.index = 0;
        this.max = Integer.MIN_VALUE;
        this.min = Integer.MAX_VALUE;
    }
    
    public void add(int valor){
        //OK 1 ponto: o código fica mais elegante assim: this.index < this.array.length stackoverflow
        //o valor pode assumir valores negativos, não? 2 ponto: falta validar: valor < 0 || valor > array.length (AIOBEx)
        if(this.index < this.array.length){
            this.array[this.index] = valor;
            if(valor > this.max){
                this.setMax(valor);
            }
            if(valor < this.min){
                this.setMin(valor);
            }
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
    /*
        Retirei os metodos max e min, mas agora se o valor max ou min forem retirados não tem com atualizar o novo valor.
        So se eu deixar os metodos max e min private e usar sempre ocorrer um remove.
     */
    public int primeiroValor(){
        return this.array[0];
    }
    
    public void setMax(int v){
        this.max = v;
    }
    
    public void setMin(int v){
        this.min = v;
    }
}
