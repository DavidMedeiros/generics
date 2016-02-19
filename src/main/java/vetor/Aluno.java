package vetor;

public class Aluno implements Comparable <Aluno> {
	private String nome;
	private double media;
	
	public Aluno(String nome, double media) {
		super();
		this.nome = nome;
		this.media = media;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	@Override
	public int compareTo(Aluno outroAluno) {
		if(this.media < outroAluno.getMedia()) {
			return -1;
		} else if (this.media > outroAluno.getMedia()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(media);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (Double.doubleToLongBits(media) != Double
				.doubleToLongBits(other.media))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno: " + nome + ", media: " + media;
	}
	
	
}
