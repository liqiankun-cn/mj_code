/**
 * 
 */
package com.for22.mjcp.concurrency.delayqueue;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 * @author liqiankun
 *
 */
public class Cache<K, V> {

	private final Logger LOG = Logger.getLogger(Cache.class);

	private ConcurrentMap<K, V> cacheObjMap = new ConcurrentHashMap<K, V>();

	private DelayQueue<DelayedItem<Pair<K, V>>> q = new DelayQueue<DelayedItem<Pair<K, V>>>();

	private Thread daemonThread;

	public Cache() {

		Runnable daemonTask = new Runnable() {
			public void run() {
				daemonCheck();
			}
		};

		daemonThread = new Thread(daemonTask);
		daemonThread.setDaemon(true);
		daemonThread.setName("Cache Daemon");
		daemonThread.start();
	}

	private void daemonCheck() {

		LOG.info("cache service started.");

		for (;;) {
			try {
				DelayedItem<Pair<K, V>> delayItem = q.take();
				if (delayItem != null) {
					// 超时对象处理
					Pair<K, V> pair = delayItem.getItem();
					cacheObjMap.remove(pair.first, pair.second); // compare and
																	// remove
				}
			} catch (InterruptedException e) {
				break;
			}
		}
		LOG.info("cache service stopped.");
	}

	// 添加缓存对象
	public void put(K key, V value, long time, TimeUnit unit) {
		V oldValue = cacheObjMap.put(key, value);
		if (oldValue != null)
			q.remove(key);

		long nanoTime = TimeUnit.NANOSECONDS.convert(time, unit);
		q.put(new DelayedItem<Pair<K, V>>(new Pair<K, V>(key, value), nanoTime));
	}

	public V get(K key) {
		return cacheObjMap.get(key);
	}

}
