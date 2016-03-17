/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

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
    public static final byte MAIOR_QUE = 1;
    public static final byte IGUAL_A = 0;
    public static final byte MENOR_QUE = -1;
    
    public Pilha(){
        this.array = (T[]) new Object[16];
        this.index = -1;
        // quando o objeto é criado o maior valor esta no array indice 0(zero);
        this.indexMaxValue = 0;
        // quando o objeto é criado o menor valor esta no array indice 0(zero);
        this.indexMinValue = 0;
    }
    
    public Pilha(int size){
        if(size >= 0){
            this.array = (T[]) new Object[size];
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
            if(valor.compareTo(this.array[this.indexMaxValue]) == MAIOR_QUE){
                //troca o indice que represena o maior
                this.setIndexMaxValue(this.index);
            }
            // Se o valor for menor que o valor contido no vetor na posição menor
            if(valor.compareTo(this.array[this.indexMinValue]) == MENOR_QUE){
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
            updateIndexMaxValue();
        }
        if(this.index == this.indexMinValue){
            updateIndexMinValue();
        }
        if(this.index >= 0){
            this.index--;
        }else{
            System.out.println("ultimo valor retirado!");
        }
        return valor;
    }
    
    public Object getFirstValue(){
        return this.array[0];
    }
    
    public Object getMaxValue(){
        return this.array[this.indexMaxValue];
    }
    
    public Object getMinValue(){
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
    private void updateIndexMaxValue(){
        T max = this.array[0];
        for(int i = 0; i < this.index; i++){
            if(max.compareTo(this.array[i]) > 0){
                max = this.array[i];
                this.setIndexMaxValue(i);
            }
        }
    }
    
    private void updateIndexMinValue(){
        T min = this.array[0];
        for(int i = 0; i < this.index; i++){
            if(min.compareTo(this.array[i]) < 0){
                min = this.array[i];
                this.setIndexMinValue(i);
            }
        }
    }
}
