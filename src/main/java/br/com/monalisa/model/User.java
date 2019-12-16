package br.com.monalisa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema = "public", name = "usuario")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_usuario", allocationSize = 1)
    @Column(name = "id_usuario")
    private Long idUser;

    @NotBlank
    @Column(name = "nome")
    private String name;

    @NotBlank
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "login")
    private String login;

    @NotBlank
    @Column(name = "senha")
    private String password;

    @Column(name = "ativo")
    private Boolean active = true;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }
    public void setAtivo(Boolean active) {
        this.active = active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
