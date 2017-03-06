/**
 * 
 */
package com.for22.mjcp.concurrency.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * The DelayQueue blocks the elements internally until a certain delay has expired. 
 * The elements must implement the interface java.util.concurrent.Delayed.
 * 
 * @author liqiankun
 *
 */
public class DelayedItem<T> implements Delayed {

	/** Base of nanosecond timings, to avoid wrapping */
	private static final long NANO_ORIGIN = System.nanoTime();

	/**
	 * Returns nanosecond time offset by origin
	 */
	final static long now() {
		return System.nanoTime() - NANO_ORIGIN;
	}

	/**
	 * Sequence number to break scheduling ties, and in turn to guarantee FIFO
	 * order among tied entries.
	 */
	private static final AtomicLong sequencer = new AtomicLong(0);

	/** Sequence number to break ties FIFO */
	private final long sequenceNumber;

	/** The time the task is enabled to execute in nanoTime units */
	private final long time;

	private final T item;

	public DelayedItem(T submit, long timeout) {
        this.time = now() + timeout;
        this.item = submit;
        this.sequenceNumber = sequencer.getAndIncrement();
    }

	public T getItem() {
		return this.item;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int compareTo(Delayed other) {

		if (other == this) // compare zero ONLY if same object
			return 0;
		if (other instanceof DelayedItem) {
			DelayedItem x = (DelayedItem) other;
			long diff = time - x.time;
			if (diff < 0)
				return -1;
			else if (diff > 0)
				return 1;
			else if (sequenceNumber < x.sequenceNumber)
				return -1;
			else
				return 1;
		}
		long d = (getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS));
		return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
	}

	/**
	 * The value returned by the getDelay() method should be the delay remaining before this element can be released.
	 *  If 0 or a negative value is returned, the delay will be considered expired, 
	 *  and the element released at the next take() etc.
	 * 
	 * @see java.util.concurrent.Delayed#getDelay(java.util.concurrent.TimeUnit)
	 */
	@Override
	public long getDelay(TimeUnit unit) {
		long d = unit.convert(time - now(), TimeUnit.NANOSECONDS);
		return d;
	}

}
