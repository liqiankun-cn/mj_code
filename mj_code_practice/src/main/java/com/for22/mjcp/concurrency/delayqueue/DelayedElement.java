/**
 * 
 */
package com.for22.mjcp.concurrency.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author liqiankun
 *
 */
public class DelayedElement implements Delayed {

	private int usedCount;

	private final Long useTime;
	private final Long timeOut;
	public DelayedElement() {
		useTime = System.nanoTime();
		timeOut = TimeUnit.SECONDS.toNanos(5);
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Delayed delayed) {
		if(this == delayed)
			return 0;
		if(delayed instanceof DelayedElement){
			DelayedElement d = (DelayedElement)delayed;
			int dr = this.usedCount - d.usedCount;
			return dr<0?-1:((dr==0)?0:1);
		}
		return 0;
	}

	/**
	 * 
	 * @see java.util.concurrent.Delayed#getDelay(java.util.concurrent.TimeUnit)
	 */
	@Override
	public long getDelay(TimeUnit unit) {
		Long delay = unit.convert(useTime+timeOut-System.nanoTime(), TimeUnit.NANOSECONDS);
		return delay;
	}

	public int getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(int usedCount) {
		this.usedCount = usedCount;
	}
	
	

}
