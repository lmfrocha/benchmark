package br.com.benchmarkapi.service;

public interface Algoritimos {

	public static String returnSequence(Integer quantidade) {
    	StringBuilder response = new StringBuilder();
    	
    	int n1 = 0;
        int n2 = 1;

        for ( int i = 0; i < quantidade; i++ ) {
            response.append( n1 + " ");
            n2 = n1 + n2 + ( n1 = n2 ) - n2;
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
