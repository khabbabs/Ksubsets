// Helper class for SizeKSubset.

// TODO: place in same package as SizeKSubset class.
package edu.unm.cs.cs361;
import java.util.*;   // (Collections framework)

public class SizeKSubsetIterator<E> implements Iterator<Set<E>> { 

	private E[] mainSet;
	private int[] combinations;
	private int index;
	private int k;
	private int n;
	private int i;
	private boolean hasNext = true;


	/** Construct a new iterator for "theSet", a SizeKSubset.
	 * 
	 * initialize the backingSet has a generic array which includes all 
	 * the members of the backing set.
	 * 
	 * sets up a combinations array which is the size of k.
	 * 
	 * @author khabbab Saleem
	 * khabbabs@unm.edu
	 */
	public SizeKSubsetIterator ( SizeKSubset<E> theSet ) {

		this.mainSet = (E[])theSet.backingSet.toArray();
		this.k=theSet.k;
		this.n=theSet.backingSet.size();
		combinations = new int[k];
		if(k==0 || n==0){
			hasNext=false;
		}
		else{

			//helps produce the next correct combination

			for(int j=0;j<k;j++){
				combinations[j]= j;
			}
			combinations[k-1]--;
		}

	}

	public boolean hasNext() {
		return this.hasNext;
	}
	
	/*
	 * the next method mostly is working with the combinations array.
	 * based on if theres any other combinatios left (hasNext). it keeps
	 * building on the array. at the end, takes the elements of the combinations
	 * array, and matches the ones from the backing array, building a subset each time.
	 * 
	 * 
	 * (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */

	public Set<E> next() {
		index = k-1;

		if(combinations[k-1]<n-1){
			combinations[k-1]++;
		}
		else
		{
			i=1;
			if(hasNext==true){
				while(combinations[index]== n-i++){

					index--;
				}
			}


			for(i=combinations[index]+1;index<k;i++){
				combinations[index++]=i;
			}
		}
		if(combinations[0]==n-k){
			hasNext=false;
		}
		TreeSet<E> newSet = new TreeSet<E>();
		for(i=0;i<combinations.length;i++){

			newSet.add(mainSet[combinations[i]]);

		}

		return newSet;
	}

	/*
	 *remove is not part of the specification. do not use.
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException();	
	} 
}