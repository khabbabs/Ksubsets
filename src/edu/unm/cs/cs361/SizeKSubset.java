// TODO: add documentation comments.
// TODO: fill in all missing parts.

// TODO: place in suitable package.
package edu.unm.cs.cs361;
import java.math.BigInteger;
import java.util.*;     // (Collections framework)

/** A non-mutable set class.
 * Each instance is defined by a backing set, and a size, k.
 * It contains all k-element subsets of the backing set.
 * original interface by Tom Hayes.
 * @author khabbab Saleem
 */
public class SizeKSubset<E> extends AbstractSet<Set<E>> {

	

	Set<E> backingSet;  
	int k;

	public Iterator<Set<E>> iterator() {
		return new SizeKSubsetIterator<E>(this);
	}
/*
 * 
 * Calls the choose method that takes the size k, and returns max size based on 
 * the max number of elements and k.
 * (non-Javadoc)
 * @see java.util.AbstractCollection#size()
 */
	public int size( ) {
		return ((int)(choose(this.backingSet.size(),this.k)));
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


/*
 * Main
 * by khabbab Saleem
 */
	public static void main ( String[ ] args ) {
				
		//test for the lowest
		runTests(1,args);
		// mid range
		runTests(3,args);
		// high k range
		runTests(7,args);

	}
	/*
	 * same has the old main but specified k, and size testing.
	 */
	private static void runTests(int size,String[] args){
		
		SizeKSubset<String> temp = new SizeKSubset<String>(new TreeSet<String>(Arrays.asList(args)),size);
		System.out.println("Running Test K = "+temp.k+" Set Size : "+temp.size());
		for ( Set<String> x : temp ) {
			System.out.println(x);
		}
	}

}
