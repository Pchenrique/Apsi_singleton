package br.com.map;

import br.com.map.facade.IOrdemDeServico;
import br.com.map.facade.IUsuario;

import java.util.ArrayList;
import java.util.List;

public class Usuario implements IUsuario {

  private String nome;
  private String cpf;
  private List<IOrdemDeServico> ordens;

  /**
   * Construtor padrão.
   * 
   * @param nome do Usuario
   * @param cpf  do Usuario
   */
  public Usuario(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
    this.ordens = new ArrayList<IOrdemDeServico>();
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * MÃ©todo que retorna a prÃ³xima OrdemDeServico do Usuario.
   * 
   * @return objeto do tipo OrdemDeServico
   */
  public IOrdemDeServico getOss() {
    if (!this.ordens.isEmpty()) {
      return this.ordens.get(0);
    }
    return null;
  }

  /**
   * MÃ©todo que adiciona OS ao Usuario.
   * 
   * @param os objeto do tipo OrdemDeServico
   */
  public boolean addOs(IOrdemDeServico os) {
    if (this.ordens.add(os)) {
      return true;
    }
    return false;
  }

  /**
   * Metodo Responsavel por remover ordem de serviço.
   */
  public boolean removerOs(String titulo) {
    for (int i = 0; i < ordens.size(); i++) {
      IOrdemDeServico os = ordens.get(i);

      if (os.getTitulo().equals(titulo)) {
        ordens.remove(os);
        return true;
      }
    }
    return false;
  }

  /**
   * metodo para resolver ordem de serviço.
   */
  public boolean resolverOs(String titulo) {
    for (int i = 0; i < ordens.size(); i++) {
      IOrdemDeServico os = ordens.get(i);

      if (os.getTitulo().equals(titulo) && os.getAberta() == true) {
        ordens.get(i).setAberta(false);
        return true;
      } else {
        return false;
      }
    }
    return false;
  }

}
