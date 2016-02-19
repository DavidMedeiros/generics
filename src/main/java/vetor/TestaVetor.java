package vetor;

import static org.junit.Assert.fail;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaVetor {

	private Vetor vetor;

	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	private Aluno aluno4;
	private Aluno aluno5;
	private Aluno aluno6;
	
	private Comparator<Aluno> comparadorMinimo;
	private Comparator<Aluno> comparadorMaximo;

	@Before
	public void setUp() {
		vetor = new Vetor(4);

		aluno1 = new Aluno("David", 8.5);
		aluno2 = new Aluno("Gabriela", 10.0);
		aluno3 = new Aluno("Hiago", 9.0);
		aluno4 = new Aluno("Gabriel", 8.0);
		aluno5 = new Aluno("Bianca", 9.5);
		aluno6 = new Aluno("Ana", 10.0);
		
		comparadorMinimo = new Comparator<Aluno>() {

			@Override
			public int compare(Aluno o1, Aluno o2) {
				if (o1.getMedia() < o2.getMedia()) {
					return 1;
				} else if (o1.getMedia() > o2.getMedia()) {
					return -1;
				} else {
					return 0;
				}
			}
			
		};
		
		comparadorMaximo = new Comparator<Aluno>() {

			@Override
			public int compare(Aluno o1, Aluno o2) {
				if (o1.getMedia() < o2.getMedia()) {
					return -1;
				} else if (o1.getMedia() > o2.getMedia()) {
					return 1;
				} else {
					return 0;
				}
			}
			
		};
	}

	@Test
	public void testInserir() {

		// INSERE ELEMENTOS DE FORMA CORRETA.
		try {
			vetor.inserir(aluno1);
			vetor.inserir(aluno2);
			vetor.inserir(aluno3);
			vetor.inserir(aluno4);

		} catch (Exception e) {
			// NAO DEVE CAPTURAR EXCESSAO.
			Assert.fail();
		}

		// TENTA INSERIR ELEMENTOS EM UM ARRAY CHEIO
		try {
			vetor.inserir(aluno5);
			// NAO DEVE CHEGAR NESTA LINHA. VETOR CHEIO.
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals(
					"Nao foi possivel adicionar o elemento. O vetor esta cheio.",
					e.getMessage());
		}
	}

	@Test
	public void testRemover() {
		// INSERE ELEMENTOS DE FORMA CORRETA.
		try {
			vetor.inserir(aluno1);
			vetor.inserir(aluno2);
			vetor.inserir(aluno3);
			vetor.inserir(aluno4);

		} catch (Exception e) {
			// NAO DEVE CAPTURAR EXCESSAO.
			Assert.fail();
		}

		// REMOVE ELEMENTO DO VETOR
		vetor.remover(aluno1);

		// VERIFICA SE O ELEMENTO FOI REMOVIDO
		Assert.assertEquals(aluno2, vetor.getVetor()[0]);

		// REMOVE TODOS OS ELEMENTOS DO VETOR
		vetor.remover(aluno2);
		vetor.remover(aluno3);
		vetor.remover(aluno4);

		// VERIFICA SE OS ELEMENTOS FORAM REMOVIDO
		Assert.assertTrue(vetor.isVazio());
	}

	@Test
	public void testProcurar() {
		// INSERE ELEMENTOS DE FORMA CORRETA.
		try {
			vetor.inserir(aluno1);
			vetor.inserir(aluno2);
			vetor.inserir(aluno3);
			vetor.inserir(aluno4);

		} catch (Exception e) {
			// NAO DEVE CAPTURAR EXCESSAO.
			Assert.fail();
		}

		// VERIFICA O INDICE DO ELEMENTO PROCURADO
		Assert.assertEquals(0, vetor.procurar(aluno1));
		Assert.assertEquals(1, vetor.procurar(aluno2));
		Assert.assertEquals(2, vetor.procurar(aluno3));
		Assert.assertEquals(3, vetor.procurar(aluno4));

		vetor.remover(aluno1);
		Assert.assertEquals(-1, vetor.procurar(aluno1));
		Assert.assertEquals(2, vetor.procurar(aluno4));
	}

	@Test
	public void testIsVazio() {
		// VERIFICA SE É VAZIO
		Assert.assertTrue(vetor.isVazio());

		// INSERE ELEMENTOS DE FORMA CORRETA.
		try {
			vetor.inserir(aluno1);

		} catch (Exception e) {
			// NAO DEVE CAPTURAR EXCESSAO.
			Assert.fail();
		}

		// VERIFICA SE NÃO É MAIS VAZIO
		Assert.assertFalse(vetor.isVazio());

	}

	@Test
	public void testIsCheio() {
		// VERIFICA SE É VAZIO
		Assert.assertTrue(vetor.isVazio());

		// INSERE ELEMENTOS DE FORMA CORRETA.
		try {
			vetor.inserir(aluno1);
			vetor.inserir(aluno2);
			vetor.inserir(aluno3);
			vetor.inserir(aluno4);

		} catch (Exception e) {
			// NAO DEVE CAPTURAR EXCESSAO.
			Assert.fail();
		}

		// VERIFICA SE VETOR ESTÁ CHEIO
		Assert.assertFalse(vetor.isVazio());
		Assert.assertTrue(vetor.isCheio());

		vetor.remover(aluno3);

		Assert.assertFalse(vetor.isCheio());

	}

	@Test
	public void testMaximo() {
		// INSERE ELEMENTOS DE FORMA CORRETA.
		try {
			vetor.inserir(aluno1);
			vetor.inserir(aluno2);
			vetor.inserir(aluno3);
			vetor.inserir(aluno6);

		} catch (Exception e) {
			// NAO DEVE CAPTURAR EXCESSAO.
			Assert.fail();
		}

		// VERIFICA O MAXIMO
		vetor.setComparadorMaximo(comparadorMaximo);
		Assert.assertEquals(aluno2, vetor.maximo());

		// MUDA O MAXIMO
		vetor.remover(aluno2);

		// VERIFICA O NOVO MAXIMO
		Assert.assertEquals(aluno6, vetor.maximo());

	}

	@Test
	public void testMinimo() {
		// INSERE ELEMENTOS DE FORMA CORRETA.
		try {
			vetor.inserir(aluno1);
			vetor.inserir(aluno2);
			vetor.inserir(aluno3);
			vetor.inserir(aluno4);

		} catch (Exception e) {
			// NAO DEVE CAPTURAR EXCESSAO.
			Assert.fail();
		}

			
		// VERIFICA O MINIMO
		vetor.setComparadorMinimo(comparadorMinimo);
		Assert.assertEquals(aluno4, vetor.minimo());

		// MUDA O MINIMO
		vetor.remover(aluno4);
		
		// VERIFICA O NOVO MINIMO
		Assert.assertEquals(aluno1, vetor.minimo());
	}

}
