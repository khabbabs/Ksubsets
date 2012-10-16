// Helper class for SizeKSubset.

// TODO: place in same package as SizeKSubset class.
package edu.unm.cs.cs361;
import java.util.*;   // (Collections framework)

public class SizeKSubsetIterator<E> implements Iterator<Set<E>> { 

	private SizeKSubset<E> theSet;
	private int k;
	// TODO: add additional private variables to keep track of 
	// where you are in the iteration of all subsets.

	/** Construct a new iterator for "theSet", a SizeKSubset.
	 */
	public SizeKSubsetIterator ( SizeKSubset<E> theSet ) {
		//System.out.println("K= "+theSet.backingSet);
		this.theSet = theSet;
		this.k=theSet.k;
		
	}

	public boolean hasNext() {
		return false;
		// Returns true if the iteration has more elements.
		// TODO: implement this.
	}

	public Set<E> next() {
		return null;
		// Returns the next element in the iteration.
		// This will always be a size-k subset of the Set<E>
		// that is backing theSet.
		// TODO: implement this.
	}
/*	
	private SizeKSubset<E> generateSubSet(SizeKSubset<E> set, int k){
		if(set.size()==k){
			return set;
		}
		return null;
	}
	*/
	
	
	/*
	 *remove is not part of the specification. do not use.
	 */
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();	
	} 
}