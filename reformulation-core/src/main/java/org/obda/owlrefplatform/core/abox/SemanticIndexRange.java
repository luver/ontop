package org.obda.owlrefplatform.core.abox;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// FIXME: maybe should be renamed to Range

/**
 * Represents a set of continues intervals
 */
public class SemanticIndexRange {

	private List<Interval> intervals = new LinkedList<Interval>();

	public SemanticIndexRange() {

	}

	public SemanticIndexRange(int start, int end) {
		intervals.add(new Interval(start, end));
	}

	public SemanticIndexRange addInterval(int start, int end) {
		intervals.add(new Interval(start, end));
		merge();

		return this;
	}

	public SemanticIndexRange addRange(SemanticIndexRange other) {
		for (Interval it : other.intervals) {
			intervals.add(it);
		}
		merge();
		return this;
	}

	/**
	 * Sort in accending order and collapse overlapping intervals
	 */
	private void merge() {

		Collections.sort(intervals);
		List<Interval> new_intervals = new LinkedList<Interval>();

		int min = intervals.get(0).start;
		int max = intervals.get(0).end;

		for (int i = 1; i < intervals.size(); ++i) {
			Interval item = intervals.get(i);
			if (item.end > max + 1 && item.start > max + 1) {
				new_intervals.add(new Interval(min, max));
				min = item.start;
			}
			max = (max > item.end) ? max : item.end;
		}
		new_intervals.add(new Interval(min, max));
		intervals = new_intervals;
	}

	@Override
	public boolean equals(Object other) {

		if (other == null)
			return false;
		if (other == this)
			return true;
		if (this.getClass() != other.getClass())
			return false;
		SemanticIndexRange otherRange = (SemanticIndexRange) other;

		return this.intervals.equals(otherRange.intervals);
	}

	@Override
	public String toString() {
		return intervals.toString();
	}

	/**
	 * Continues interval between 2 points
	 * 
	 * @author Sergejs Pugacs
	 * 
	 */
	class Interval implements Comparable<Interval> {

		private int start, end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public boolean equals(Object other) {

			if (other == null)
				return false;
			if (other == this)
				return true;
			if (this.getClass() != other.getClass())
				return false;
			Interval otherInterval = (Interval) other;

			return (this.start == otherInterval.start && this.end == otherInterval.end);
		}

		@Override
		public int hashCode() {
			int result = 17;
			result += 37 * result + start;
			result += 37 * result + end;
			return result;
		}

		@Override
		public int compareTo(Interval o) {
			return this.start - o.start;
		};

		@Override
		public String toString() {
			return String.format("[%s:%s]", start, end);
		}

	}

}
