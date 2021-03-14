package View;

public class LogarFuncionarioSimpleFactory{

	public void logarFuncionario(String cargo, int codigo) {
		switch(cargo) {
		case"Atendente":
			new TelaAtendente(codigo);
			break;
		case"Gerente":
			new TelaGerente(codigo);
			break;
		case"Pizzaiolo":
			new TelaPizzaiolo(codigo);
			break;
		case"Motoboy":
			new TelaMotoBoy(codigo);
			break;
		}
	}
}
