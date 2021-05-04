package it.polito.tdp.extflightdelays.model;

public class Connessione {
	
	private Airport a;
	private Airport b;
	private int voli;
	private int dTot;
	public Connessione(Airport a, Airport b, int voli, int dTot) {
		super();
		this.a = a;
		this.b = b;
		this.voli = voli;
		this.dTot = dTot;
	}
	public Airport getA() {
		return a;
	}
	public void setA(Airport a) {
		this.a = a;
	}
	public Airport getB() {
		return b;
	}
	public void setB(Airport b) {
		this.b = b;
	}
	public int getVoli() {
		return voli;
	}
	public void setVoli(int voli) {
		this.voli = voli;
	}
	public int getdTot() {
		return dTot;
	}
	public void setdTot(int dTot) {
		this.dTot = dTot;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
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
		Connessione other = (Connessione) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		return true;
	}
	
	

}
