/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

/**
 *
 * @author eide
 */
public class Aluno implements Comparable{
    private int matricula;
    private String nome;
    private String curso;
    
    public Aluno(int matricula, String nome, String curso){
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    @Override
    public int compareTo(Object o){
        Aluno aux = (Aluno) o;
        if(this.getMatricula() > aux.getMatricula()){
            return 1;
        }else if(this.getMatricula() < aux.getMatricula()){
            return -1;
        }
        return 0;
    }
    
    @Override
    public String toString(){
        return String.format("Max... Matricula: %d Nome: %s\n", getMatricula(), getNome());
    }
    
    public static void main(String[] args) {
        Pilha<Aluno> alunos = new Pilha<>(20);
        alunos.add(new Aluno(151014901,"Eric Farias","ADS"));
        alunos.add(new Aluno(161014901,"Evilania Farias","ADS"));
        
        System.out.printf("Max... Matricula: %d Nome: %s\n", alunos.getMaxValue().getMatricula(), alunos.getMaxValue().getNome());
        System.out.printf("Min... Matricula: %d Nome: %s\n", alunos.getMinValue().getMatricula(), alunos.getMinValue().getNome());
        System.out.println(alunos.getMaxValue());
    }
}
