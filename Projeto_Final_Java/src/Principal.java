import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		Servico manicure = new Manicure("Venha fazer Mão e Pé + spa dos pés no Werner", 60f, "2019001");
		Servico cabeleleiro = new Cabeleleiro("Mechas + Reconstrução + Escova no Maison Gi", 150f, "2019002");
		Servico estetica = new Estetica("Peeling de Cristal no Centro de Estética", 300f, "2019003");
		Servico massagem = new Massagem("Duas horas de Shiatsu no Studio Postural", 100f, "2019004");
	
		
		List<Servico>listaServico = new ArrayList<Servico>();
		listaServico.add(manicure);
		listaServico.add(cabeleleiro);
		listaServico.add(estetica);
		listaServico.add(massagem);
		new exibicao().exibirLista(listaServico);
		
		
		Cliente cliente1 = new Cliente("Ana Fernandes", "111.111.111-11");
		cliente1.comprar(listaServico, manicure);
		cliente1.exibirCompras();
		
		new exibicao().exibirLista(listaServico);
		
		
	}

}

class exibicao{
	void exibirLista(List<Servico> lista) {
		System.out.println("Serviços Disponíveis:");
		for(Servico s : lista) {
			System.out.println(s.getDescricao() + "(" + s.getCodigo() + ")");
			System.out.printf("Preço: %.2f%n", s.getPreco());
			System.out.println();
		}
		System.out.println();
	}
}

abstract class Servico {
	private String descricao;
	private float preco;
	private String codigo;

	protected void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	protected void setPreco(float preco) {
		this.preco = preco;
	}
	
	protected void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	String getDescricao() {
		return descricao;
	}

	float getPreco() {
		return preco;
	}
	
	String getCodigo() {
		return codigo;
	}
}

class Manicure extends Servico {
	Manicure(String descricao, float preco, String cod) {
		setDescricao(descricao);
		setPreco(preco);
		setCodigo(cod);
	}
}

class Cabeleleiro extends Servico {
	Cabeleleiro(String descricao, float preco, String cod) {
		setDescricao(descricao);
		setPreco(preco);
		setCodigo(cod);
	}
}

class Estetica extends Servico {
	Estetica(String descricao, float preco, String cod) {
		setDescricao(descricao);
		setPreco(preco);
		setCodigo(cod);
	}
}

class Massagem extends Servico {
	Massagem(String descricao, float preco, String cod) {
		setDescricao(descricao);
		setPreco(preco);
		setCodigo(cod);
	}
}


class Cliente {
	private String nomeCompleto;
	private String cpf;
	private List<Servico> listaDeCompras = new LinkedList<Servico>();
	
	Cliente(String nome, String cpf){
		setNome(nome);
		setCpf(cpf);
	}
	
	private void setNome(String nome) {
		nomeCompleto = nome;
	}
	
	private void setCpf(String cpf) {
		this.cpf = cpf;
	}

	void comprar(List<Servico> lista, Servico servico) {
		int servicoEscolhido = lista.indexOf(servico);
		if (servicoEscolhido != -1) {
			Servico s = lista.get(servicoEscolhido);
			listaDeCompras.add(s);
			lista.remove(servicoEscolhido);
			System.out.println("Compra efetuada com sucesso!");
			System.out.println("Parabéns, " + nomeCompleto+"! Você comprou o serviço " + s.getDescricao() + "(" + s.getCodigo()+")");
			System.out.println();
		} else {
			System.out.println("Não oferecemos esse Serviço");
			System.out.println();
		}
		System.out.println();
	}
	
	void exibirCompras() {
		System.out.println("Lista de Compras do(a) " + nomeCompleto + "("+ cpf+")");
		for (int i = 0; i < listaDeCompras.size(); i++) {
			String descricao = listaDeCompras.get(i).getDescricao();
			float preco = listaDeCompras.get(i).getPreco();
			String cod = listaDeCompras.get(i).getCodigo();

			System.out.printf("%s (cod.%s)- R$%.2f%n", descricao, cod, preco);
		}
		System.out.println();	
	}
}
