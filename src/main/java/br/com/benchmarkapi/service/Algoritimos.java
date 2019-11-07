package br.com.benchmarkapi.service;

public interface Algoritimos {

	public static String returnSequence(Integer quantidade) {
    	StringBuilder response = new StringBuilder();
    	response.append(fibonacci(quantidade.longValue()));
    	return response.toString();
    }
	
	static Long fibonacci(Long num) {
		
		if(num == 0 || num == 1) {
			return num;
		}
		return fibonacci(num - 1) + fibonacci(num - 2); 
	}
	
	public static void insertionSort(Integer tamanho) {
		
		Long[] vetor = new Long[tamanho.intValue()];
		for (int c = 0; c < vetor.length; c++) {
			vetor[c] = (long) (Math.random() * tamanho);
		}
		
		int j,i;
	    Long key;
	    
	    for (j = 1; j < vetor.length; j++)
	    {
	      key = vetor[j];
	      for (i =  (j - 1); (i >= 0) && (vetor[i] > key); i--)
	      {
	         vetor[(i + 1)] = vetor[i];
	       }
	        vetor[(i + 1)] = key;
	    }
	}
	
}
