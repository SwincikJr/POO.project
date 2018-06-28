package POO.project;

/*
 * The class "Fila" is a Queue, so the first item in is the first out.
 */

class Fila {
	private int max; //Maximum size of Queue
	private int total; //Current number of items in Queue
	private int inicio; //The index of first item in Queue
	private int fim; //The index of last item in Queue
	private int[] fila; //It's a integer numbers queue. The items are stored in an array
	
	public Fila() {
		this(256); //The constructor without parameters instantiate a queue with 256 items size 
	}
	public Fila(int m) {
		max = m;
		total = 0;
		inicio = 0;
		fim = 0;
		fila = new int[m];
	}
	public boolean vaziaf() { //Check if the queue is empty
		return total == 0;
	}
	public boolean cheiaf() { //Check if the queue is full
		return total == max;
	}
	public void enfileira(int x) { //Lines the parameter on queue
		if(!cheiaf()) { //Allows the action just if queue is not full
			fila[fim] = x;
			if(fim == max - 1)fim = 0; //If the index of last item is the last index of array, the index becomes 0 again;
			else fim++; //If not, just increment
			total++;
		}
		else throw new RuntimeException("Fila cheia.");
	}
	public int desenfileira() { //Remove next item from queue
		if(!vaziaf()) { //Allows the action just if queue is not empty
			int x = fila[inicio];
			if(inicio == max - 1) inicio = 0; //Like "enfileira" method, keeps the queue inside range of array
			else inicio++;
			total--;
			return x;
		}
		else throw new RuntimeException("Fila vazia.");
	}
}
