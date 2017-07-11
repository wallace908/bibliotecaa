/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GustavoSantos
 */
@Entity
@Table(name = "LIVRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l")
    , @NamedQuery(name = "Livro.findById", query = "SELECT l FROM Livro l WHERE l.id = :id")
    , @NamedQuery(name = "Livro.findByNome", query = "SELECT l FROM Livro l WHERE l.nome = :nome")
    , @NamedQuery(name = "Livro.findByNumPaginas", query = "SELECT l FROM Livro l WHERE l.numPaginas = :numPaginas")
    , @NamedQuery(name = "Livro.findByEdicao", query = "SELECT l FROM Livro l WHERE l.edicao = :edicao")
    , @NamedQuery(name = "Livro.findByIsbn", query = "SELECT l FROM Livro l WHERE l.isbn = :isbn")
    , @NamedQuery(name = "Livro.findByImagem", query = "SELECT l FROM Livro l WHERE l.imagem = :imagem")})
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "NOME", nullable = false, length = 300)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_PAGINAS", nullable = false)
    private int numPaginas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "EDICAO", nullable = false, length = 3)
    private String edicao;
    @Size(max = 50)
    @Column(name = "ISBN", length = 50)
    private String isbn;
    @Size(max = 100)
    @Column(name = "IMAGEM", length = 100)
    private String imagem;
    @JoinColumn(name = "ID_AUTOR", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Autor idAutor;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "ID_EDITORA", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Editora idEditora;

    public Livro() {
    }

    public Livro(Integer id) {
        this.id = id;
    }

    public Livro(Integer id, String nome, int numPaginas, String edicao) {
        this.id = id;
        this.nome = nome;
        this.numPaginas = numPaginas;
        this.edicao = edicao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Autor getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Autor idAutor) {
        this.idAutor = idAutor;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Editora getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Editora idEditora) {
        this.idEditora = idEditora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Livro[ id=" + id + " ]";
    }
    
}
