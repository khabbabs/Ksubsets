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
		processSubSet((Set<E>) theSet,k);
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
	
	private void process(E[] set){
		System.out.println(set);
	}
	private void processSubSet(Set<E> set, int k){
		E subSet[] = (E[]) new Object[k];
		processLargerSubSet((E[]) set.toArray(),subSet,0,0);
		
	}
	private void processLargerSubSet(E[] set, E[] subSet,int subSetSize, int nextIndex){
		if(subSet.length == subSetSize){
			process(subSet);
			return;
		}
		else{
			for(int j=nextIndex;j<set.length;j++){
			processLargerSubSet(set,subSet,++subSetSize,++nextIndex);	
			}
		
		}			
	}
	/*
	 *remove is not part of the specification. do not use.
	 */
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();	
	} 
}