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
