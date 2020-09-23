package entities;

public class Funcionario {
	//Atributos
	private Integer id;
	private String nome;
	private Double salario;
	
	//Construtor
	public Funcionario(Integer id, String nome, Double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	//Getter e Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}
	
	public double setSalario() {
		return salario;
	}

		
	//Metodos
	public void aumento(double percentual) {  //percentual é um argumento
			salario += salario*percentual/100.0;
		}
	
	//String toString 
	@Override //Ajuda a verifcar se há inconsistência no código, mas não é obrigatório
	public String toString() {
	return id +  ", "
		+ nome + ", " 
		+ String.format("%.2f", salario); //Para formatar valor com duas casas decimais
	}

	

	
}
