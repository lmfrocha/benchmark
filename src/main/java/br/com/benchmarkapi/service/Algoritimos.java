package br.com.benchmarkapi.service;

public interface Algoritimos {

	public static String returnSequence(Double quantidade) {
    	StringBuilder response = new StringBuilder();
    	Double num1 = 1D, num2 = 0D;
    	for(Double i = 0D; i < quantidade; i++){
    		num1 = num1 + num2;
    		num2 = num1 - num2;
    		response.append(num1 + " ");
    	}
    	return response.toString();
    }
	
	public static void insertionSort(Long[] vetor) {
		int j;
	    Long key;
	    int i;
	    
	    for (j = (int) 1; j < vetor.length; j++)
	    {
	      key = vetor[j];
	      for (i = (int) (j - 1); (i >= 0) && (vetor[i] > key); i--)
	      {
	         vetor[(int) (i + 1)] = vetor[i];
	       }
	        vetor[(int) (i + 1)] = key;
	    }
	}
	
}
