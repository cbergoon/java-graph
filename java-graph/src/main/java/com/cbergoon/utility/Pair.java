package com.cbergoon.utility;

public class Pair<S, T> {

	private S first;
	private T second;
	
	public Pair(){
		this.first = null;
		this.second = null;
	}
	
	public Pair(S first, T second){
		this.first = first;
		this.second = second;
	}
	
	public S getFirst(){
		return this.first;
	}
	
	public void setFirst(S first){
		this.first = first;
	}
	
	public T getSecond(){
		return this.second;
	}
	
	public void setSecond(T second){
		this.second = second;
	}
	
	public String toString(){
		return "[" + this.first + ", " + this.second + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
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
		Pair other = (Pair) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}
	
}
