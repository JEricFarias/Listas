/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

import java.lang.reflect.Array;

/**
 * Inplementa uma pilha de tipo T(generico) com um tamanho fixo 16 ou tamnho n especificado pelo usuário.
 * @author Eric Farias
 * @since 27/02/2016
 * @param <T> é uma classe qualquer que implementa a interface Comaprable
 */
public class Pilha<T extends Comparable> {
    private T[] array;
    private int index;
    private int indexMaxValue;
    private int indexMinValue;
   
    
    public Pilha(){
        this.array = (T[]) new Object[16];
        this.index = -1;
        // quando o objeto é criado o maior valor esta no array indice 0(zero);
        this.indexMaxValue = 0;
        // quando o objeto é criado o menor valor esta no array indice 0(zero);
        this.indexMinValue = 0;
    }
    
    public Pilha(Class<T[]> type, int size){
        this.array = type.cast(Array.newInstance(type.getComponentType(), size));
    }
    public Pilha(int size){
        this(T[].class, size); // ageitar isso...
        if(size >= 0){
            
        }else{
            throw new NegativeArraySizeException("Tamnho de arrays tem que ser maior que zero");
        }
        this.index = -1;
        // quando o objeto é criado o maior valor esta no array indice 0(zero);
        this.indexMaxValue = 0;
        // quando o objeto é criado o menor valor esta no array indice 0(zero);
        this.indexMinValue = 0;
    }
    
    public void add(T valor){
        this.index++;
        if(this.index < this.array.length){
            // Se o valor for null lança um Exception
            if(valor == null)
               throw new NullPointerException();
            
            this.array[this.index] = valor;
            //Se valor for maior que o valor contido no vetor na posição maior
            if(valor.compareTo(this.array[this.indexMaxValue]) > 0){
                //troca o indice que represena o maior
                this.setIndexMaxValue(this.index);
            }
            // Se o valor for menor que o valor contido no vetor na posição menor
            if(valor.compareTo(this.array[this.indexMinValue]) < 0){
                //troca o indice que represena o menor
                this.setIndexMinValue(this.index);
            }
        }else{
            // add método para almentar dinamicamente o array
            throw new StackOverflowError("A operação não pode ser realizada pois a pilha encontra-se cheia!");
        }
    }
    
    public <T> Object remove(){
        Object valor = this.array[this.index];
        this.array[this.index] = null;
        if(this.index == this.indexMaxValue){
            updateIndex();
        } else if(this.index == this.indexMinValue){
            updateIndex();
        }
        if(this.index >= 0){
            this.index--;
        }else{
            System.out.println("ultimo valor retirado!");
        }
        return valor;
    }
    
    public T getFirstValue(){
        return this.array[0];
    }
    
    public T getMaxValue(){
        return this.array[this.indexMaxValue];
    }
    
    public T getMinValue(){
        return this.array[this.indexMinValue];
    }
    
    public void setIndexMaxValue(int v){
        this.indexMaxValue = v;
    }
    
    public void setIndexMinValue(int v){
        this.indexMinValue = v;
    }
    
    public int getStackSize(){
        return this.array.length;
    }
    
    /*
        Retirei os metodos max e min, mas agora se o valor max ou min forem retirados não tem com atualizar o novo valor.
        Então reiniciei os valores, criei um metodo update que busca na pilha so ate o indice e preenche os dois atributos.
     */
    private void updateIndex(){
        T max = this.array[0];
        T min = this.array[0];
        for(int i = 0; i < this.index; i++){
            // Update valor maximo
            if(max.compareTo(this.array[i]) > 0){
                max = this.array[i];
                this.setIndexMaxValue(i);
            }
            // Update valor minimo
            if(min.compareTo(this.array[i]) < 0){
                min = this.array[i];
                this.setIndexMinValue(i);
            }
        }
    }
}
