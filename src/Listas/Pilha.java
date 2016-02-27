/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

/**
 * Inplementa uma pilha de tamanho fixo 16 ou tamnho n especificado pelo usuário.
 * @author Eric Farias
 * @since 27/02/2016
 */

public class Pilha {
    private int []array;
    private int index;
    private int indexMaxValue;
    private int indexMinValue;
    
    public Pilha(){
        this.array = new int[16];
        this.index = 0;
        // quando o objeto é criado o maior valor esta no array indice 0(zero);
        this.indexMaxValue = 0;
        // quando o objeto é criado o maior valor esta no array indice 0(zero);
        this.indexMinValue = 0;
    }
    
    public Pilha(int size){
        if(size > 0){
            this.array = new int[size];
        }else{
            throw new NegativeArraySizeException("Tamnho de arrays tem que ser maior que zero");
        }
        this.index = 0;
        // quando o objeto é criado o maior valor esta no array indice 0(zero);
        this.indexMaxValue = 0;
        // quando o objeto é criado o maior valor esta no array indice 0(zero);
        this.indexMinValue = 0;
    }
    
    public void add(int valor){
        if(this.index < this.array.length){
            this.array[this.index] = valor;
            if(valor > this.indexMaxValue){
                this.setIndexMaxValue(this.index);
            }
            if(valor < indexMinValue){
                this.setIndexMinValue(this.index);
            }
            this.index++;
        }else{
            // add método para almentar dinamicamente o array
            throw new StackOverflowError("A operação não pode ser realizada pois a pilha encontra-se cheia!");
        }
    }
    
    public int remove(){
        int valor = this.array[this.index];
        this.array[this.index] = 0;
        if(this.index == this.indexMaxValue){
            updateIndexMaxValue();
        }
        if(this.index == this.indexMinValue){
            updateIndexMinValue();
        }
        if(this.index > 0){
            this.index--;
        }else{
            System.out.println("ultimo valor retirado!");
        }
        return valor;
    }
    
    public int getFirstValue(){
        return this.array[0];
    }
    
    public int getMaxValue(){
        return this.array[this.indexMaxValue];
    }
    
    public int getMinValue(){
        return this.array[this.indexMinValue];
    }
    
    public void setIndexMaxValue(int v){
        this.indexMaxValue = v;
    }
    
    public void setIndexMinValue(int v){
        this.indexMinValue = v;
    }
    
    /*
        Retirei os metodos max e min, mas agora se o valor max ou min forem retirados não tem com atualizar o novo valor.
        Então reiniciei os valores, criei um metodo update que busca na pilha so ate o indice e preenche os dois atributos.
     */
    private void updateIndexMaxValue(){
        for(int i = 0; i < --this.index; i++){
            if(this.array[i] > this.array[this.indexMaxValue]){
                this.setIndexMaxValue(i);
            }
        }
    }
    
    private void updateIndexMinValue(){
        for(int i = 0; i < --this.index; i++){
            if(this.array[i] < this.array[this.indexMinValue]){
                this.setIndexMinValue(i);
            }
        }
    }
}
