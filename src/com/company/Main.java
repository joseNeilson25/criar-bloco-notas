package com.company;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
    List<blocos> blocos = new ArrayList();

    public static void main(String[]args){
        Main main = new Main();
        main.exibirMenu();
    }

    public void exibirMenu() {
        boolean var1 = false;

        int escolhaMenu;
        do {
            String textoMenu = "Escolha uma opção \n\n 1-Criar bloco \n 2-Procurar bloco";
            String escolhaInformada = JOptionPane.showInputDialog(textoMenu);
            escolhaMenu = Integer.parseInt(escolhaInformada);
            this.processarEscolha(escolhaMenu);
        } while (escolhaMenu != 0);
    }

    public void processarEscolha(int escolha) {
        switch(escolha) {
            case 0:
                JOptionPane.showMessageDialog((Component)null, "Até a próxima:)");
                break;
            case 1:
                this.cadastrarBloco();
                break;
            case 2:
                this.imprimirblocos();
                break;

            default:
                JOptionPane.showMessageDialog((Component)null, "opção invalida:)");
        }
    }

    public void cadastrarBloco(){

        blocos blocos = new blocos();
        String nome = JOptionPane.showInputDialog("Informe o nome do bloco");
        String codigo = JOptionPane.showInputDialog("Informe o codigo do bloco");
        String texto = JOptionPane.showInputDialog("Informe a descrição do bloco");
        blocos.nome = nome;
        blocos.codigo = codigo;
        blocos.texto = texto;

        this.blocos.add(blocos);
    }

    public blocos buscarblocos(String codigo){
        Iterator var2 = this.blocos.iterator();

        blocos blocos;
        do{
            if(!var2.hasNext()){
                return null;
            }
            blocos = (blocos)var2.next();
        } while(!blocos.codigo.equals(codigo));
        return blocos;
    }

    public void imprimirblocos(){
        String codigo = JOptionPane.showInputDialog("Informe o codigo do bloco");
        blocos blocos = this.buscarblocos(codigo);
        if (blocos == null) {
            JOptionPane.showMessageDialog((Component)null, "Bloco não encontrado");
        } else {
            JOptionPane.showMessageDialog((Component)null, blocos.toString());
        }
    }
}