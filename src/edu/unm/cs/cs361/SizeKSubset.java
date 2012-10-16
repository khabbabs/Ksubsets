// TODO: add documentation comments.
// TODO: fill in all missing parts.

// TODO: place in suitable package.
package edu.unm.cs.cs361;
import java.util.*;     // (Collections framework)

/** A non-mutable set class.
 * Each instance is defined by a backing set, and a size, k.
 * It contains all k-element subsets of the backing set.
 */
public class SizeKSubset<E> extends AbstractSet<Set<E>> {

	// The AbstractSet class provides defaults for all
	// methods of the Set interface.  We only need to 
	// supply the size and iterator methods.

	Set<E> backingSet;  
	// We will assume that backingSet is unchanging, at least
	// for the lifetime of our SizeKSubset object.
	int k;

	public Iterator<Set<E>> iterator() {
		return new SizeKSubsetIterator<E>(this);
	}

	public int size( ) {
		return backingSet.size();
		// TODO: return the correct size.
	}

	public SizeKSubset ( Set<E> backingSet, int k ) {
		this.backingSet = backingSet;
		this.k = k;
	}

	public static void main ( String[ ] args ) {
		// TODO: add your own tests.
		System.out.println(Arrays.asList(args));
		SizeKSubset<String> s = new SizeKSubset<String>( new TreeSet<String>( Arrays.asList( args ) ), 3 ) ;
		for ( Set<String> x : s ) {
			System.out.println( x );
			x.iterator().next();
		}
	}

}
