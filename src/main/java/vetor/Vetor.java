package vetor;

import java.util.Comparator;

/**
 * Implementacao de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 *
 */
public class Vetor<T extends Comparable<T>> {

	// O array interno onde os objetos manipulados sao guardados
	private T[] arrayInterno;

	// O tamanho que o array interno tera
	private int tamanho;

	// Indice que guarda a proxima posicao vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator<T> comparadorMaximo;
	private Comparator<T> comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = 0;
		this.arrayInterno = (T[]) new Comparable[tamanho];
	}

	public void setComparadorMaximo(Comparator<T> comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator<T> comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T elemento) throws Exception {
		if (this.indice >= this.tamanho) {
			throw new Exception(
					"Nao foi possivel adicionar o elemento. O vetor esta cheio.");
		}
		this.arrayInterno[this.indice] = elemento;
		this.indice = this.indice + 1;
	}

	// Remove um objeto do vetor
	public void remover(T elemento) {
		int indice = procurar(elemento);
		if (indice != -1) {
			for (int i = indice; i < arrayInterno.length - 1; i++) {
				arrayInterno[i] = arrayInterno[i + 1];
			}
			arrayInterno[tamanho - 1] = null;
			indice--;
		}
	}

	// Procura um elemento no vetor
	public int procurar(T elemento) {
		for (int i = 0; i < indice; i++) {
			if (arrayInterno[i] != null) {
				if (arrayInterno[i].compareTo(elemento) == 0) {
					return i;
				}
			}
		}
		return -1;
	}

	// Diz se o vetor esta vazio
	public boolean isVazio() {
		int quantidadeDeVazios = 0;
		for (T elemento : arrayInterno) {
			if (elemento == null) {
				quantidadeDeVazios++;
			}
		}
		if (quantidadeDeVazios == tamanho) {
			return true;
		}
		return false;
	}

	// Diz se o vetor esta cheio
	public boolean isCheio() {
		for (T elemento : arrayInterno) {
			if (elemento == null) {
				return false;
			}
		}
		return true;
	}

	// Encontra Maximo elemento do vetor
	public T maximo() {
		return compara(comparadorMaximo);
	}

	// Encontra Minimo elemento do vetor
	public T minimo() {
		return compara(comparadorMinimo);
	}

	public T compara(Comparator<T> comparador) {
		T maximo = arrayInterno[0];
		for (int i = 1; i < indice; i++) {
			if(arrayInterno[i] != null) {
				if (comparador.compare(maximo, arrayInterno[i]) == -1){
					maximo = arrayInterno[i];
				}
			}
			
		}
		return maximo;
	}
	
	// Obtem o vetor
	public T[] getVetor() {
		return arrayInterno;
	}
}