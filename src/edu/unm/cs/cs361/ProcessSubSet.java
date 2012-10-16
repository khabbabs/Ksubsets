package edu.unm.cs.cs361;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ProcessSubSet<E> {

	/*static void process(int [] subset) {
		System.out.println(Arrays.toString(subset));
	}
	static void processSubsets(int[] set, int k) {
		int[] subset = new int[k];
		processLargerSubsets(set, subset, 0, 0);
	}
	static void processLargerSubsets(int[] set, int[] subset, int subsetSize, int nextIndex) {
		if (subsetSize == subset.length) {
			//System.out.println("subsetSize == subset.length");
			process(subset);
		} else {
			for (int j = nextIndex; j < set.length; j++) {
				subset[subsetSize] = set[j];
				processLargerSubsets(set, subset, subsetSize + 1, j + 1);
			}
		}
	}*/

	private E[] combination;
	private Set<E> set;
	private int k;



	private void processSet(E[] subSet){
		//System.out.println(subSet);
		for(int i=0;i<subSet.length;i++){
			System.out.print(subSet[i]+" ");
		}
		System.out.println(" ");
	}
	public ProcessSubSet(Set<E> set, int k){
		combination = (E[]) new Object[k];
		this.set=set;
		this.k=k;
		System.out.println("in constructor, set:"+set+" K: "+k);
		System.out.println("size of the combination "+combination.length);
		processLargerSubSet((E[])set.toArray(),combination,0,0);
	}
	int idx=k;
	int hasnext=k+1;
	private void processLargerSubSet(E[] mainSet, E[]combination,int subSetSize, int nextIndex){
		if(idx<k+2){
			idx++;
			if(subSetSize == combination.length){
				processSet(combination);
				//return;
			}
			else{
				for(int i=nextIndex;i<mainSet.length;i++){
					combination[subSetSize] = mainSet[i];
					processLargerSubSet(mainSet,combination,subSetSize+1,i+1);
				}
			}	
		}

		/*	
		for(int i=0;i<mainSet.length;i++){
			System.out.print(mainSet[i]+" ");
		}*/

		//return subSet;
	}
	public static void main(String[] args) {
		ProcessSubSet<String> subSet = new ProcessSubSet<String>(new TreeSet<String>(Arrays.asList(args)),7);

	}

}
