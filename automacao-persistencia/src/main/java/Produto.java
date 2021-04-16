import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {
	@Id @GeneratedValue
	private Integer id;
	private String descricao;
	private String codigobarra;
	private Double valor;
	
	
	public Produto() {
		super();
	}
	public Produto(Integer id, String descricao, String codigobarra, Double valor) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigobarra = codigobarra;
		this.valor = valor;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodigobarra() {
		return codigobarra;
	}
	public void setCodigobarra(String codigobarra) {
		this.codigobarra = codigobarra;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
