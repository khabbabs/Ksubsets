// TODO: add documentation comments.
// TODO: fill in all missing parts.

// TODO: place in suitable package.
package edu.unm.cs.cs361;
import java.math.BigInteger;
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
		return ((int)(choose(this.backingSet.size(),this.k)));
		// TODO: return the correct size.
	}

	public SizeKSubset ( Set<E> backingSet, int k ) {
		this.backingSet = backingSet;
		this.k = k;
	}
	
/*
 * choose(n,k) = n! / (n-k)! K!
 * 
 * 
 * 	
 */
	public static double choose(int x, int y) {
	    if (y < 0 || y > x) return 0;
	    if (y > x/2) {
	        // choose(n,k) == choose(n,n-k), 
	        // so this could save a little effort
	        y = x - y;
	    }

	    double denominator = 1.0, numerator = 1.0;
	    for (int i = 1; i <= y; i++) {
	        denominator *= i;
	        numerator *= (x + 1 - i);
	    }
	    return numerator / denominator;
	}



	public static void main ( String[ ] args ) {
		// TODO: add your own tests.
		//System.out.println(Arrays.asList(args));
		SizeKSubset<String> s = new SizeKSubset<String>( new TreeSet<String>( Arrays.asList( args ) ), 1 ) ;
		for ( Set<String> x : s ) {
			System.out.println(x);
		}
	}

}
