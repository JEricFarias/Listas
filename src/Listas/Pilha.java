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
    private int maxValue;
    private int minValue;
    
    public Pilha(){
        this.array = new int[16];
        this.index = 0;
        this.maxValue = Integer.MIN_VALUE;
        this.minValue = Integer.MAX_VALUE;
    }
    
    public Pilha(int size){
        this.array = new int[size];
        this.index = 0;
        this.maxValue = Integer.MIN_VALUE;
        this.minValue = Integer.MAX_VALUE;
    }
    
    public void add(int valor){
        //OK 1 ponto: o código fica mais elegante assim: this.index < this.array.length stackoverflow
        //o valor pode assumir valores negativos, não? 2 ponto: falta validar: valor < 0 || valor > array.length (AIOBEx)
        if(this.index < this.array.length){
            this.array[this.index] = valor;
            if(valor > this.maxValue){
                this.setMaxValue(valor);
            }
            if(valor < minValue){
                this.setMinValue(valor);
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
        this.update();
        return valor;
    }
    
    public int primeiroValor(){
        return this.array[0];
    }
    
    public void setMaxValue(int v){
        this.maxValue = v;
    }
    
    public void setMinValue(int v){
        this.minValue = v;
    }
    
    /*
        Retirei os metodos max e min, mas agora se o valor max ou min forem retirados não tem com atualizar o novo valor.
        Então reiniciei os valores, criei um metodo update que busca na pilha so ate o indice e preenche os dois atributos.
     */
    private void update(){
        this.setMaxValue(Integer.MIN_VALUE);
        this.setMinValue(Integer.MAX_VALUE);
        for(int i = 0; i < this.index; i++){
            if(this.array[i] > this.maxValue){
                this.setMaxValue(this.array[i]);
            }
            if(this.array[i] < this.minValue){
                this.setMinValue(this.array[i]);
            }
        }
    }
}
