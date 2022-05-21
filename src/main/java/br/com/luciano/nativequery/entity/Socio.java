package br.com.luciano.nativequery.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@NamedNativeQuery(name = "socio_todos", query = "SELECT DISTINCT s.id_socio, s.no_socio, s.nu_cpf FROM tb_dependente d " +
		                                       " INNER JOIN tb_socio s ON s.id_socio = d.id_socio", resultClass = Socio.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_SOCIO")
public class Socio {
	
	@Id
	@Column(name = "id_socio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "no_socio")
	private String nome;
	
	@Column(name = "nu_cpf")
	private String cpf;
	
	@OneToMany(mappedBy = "socio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Dependente> dependentes = new ArrayList<>();

	@Override
	public String toString() {
		return "Socio{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", cpf='" + cpf + '\'' +
				'}';
	}
}
