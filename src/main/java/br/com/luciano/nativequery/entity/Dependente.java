package br.com.luciano.nativequery.entity;

import javax.persistence.*;
import lombok.*;

@NamedQuery(name = "usando_jpql", query="SELECT d FROM Dependente d JOIN FETCH d.socio s")
@NamedNativeQuery(name=Dependente.QUERY_NATIVA_DEPENDETE, query="SELECT d.id_dependente, d.no_dependente, d.nu_cpf, d.id_socio FROM tb_dependente d " +
		                                           " INNER JOIN tb_socio s ON d.id_socio = s.id_socio")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_DEPENDENTE")
public class Dependente {

	public static final String QUERY_NATIVA_DEPENDETE = "queryNativaDependente";
	
	@Id
	@Column(name = "id_dependente")
	private Integer id;
	
	@Column(name = "no_dependente")
	private String nome;
	
	@Column(name = "nu_cpf")
	private String cpf;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_socio")
	private Socio socio;


	@Override
	public String toString() {
		return "Dependente{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", cpf='" + cpf + '\'' +
				", idSocio=" + socio.getId() +
				'}';
	}


}
