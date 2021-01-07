package com.zjf.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-11-28 16:31  //时间
 *
 *
 * LRU全称是Least Recently Used，即最近最久未使用的意思。
 *
 * LRU算法的设计原则是：如果一个数据在最近一段时间没有被访问到，
 * 那么在将来它被访问的可能性也很小。也就是说，当限定的空间已存满数据时，
 * 应当把最久没有被访问到的数据淘汰。
 *
 * 实现LRU：
 * 1.用一个数组来存储数据，给每一个数据项标记一个访问时间戳，每次插入新数据项的时候，
 * 先把数组中存在的数据项的时间戳自增，并将新数据项的时间戳置为0并插入到数组中。
 * 每次访问数组中的数据项的时候，将被访问的数据项的时间戳置为0
 * 。当数组空间已满时，将时间戳最大的数据项淘汰。
 *
 * 2.利用一个链表来实现，每次新插入数据的时候将新数据插到链表的头部；
 * 每次缓存命中（即数据被访问），则将数据移到链表头部；那么当链表满的时候，
 * 就将链表尾部的数据丢弃。
 *
 * 3.利用链表和hashmap
 * 。当需要插入新的数据项的时候，如果新数据项在链表中存在（一般称为命中），
 * 则把该节点移到链表头部，如果不存在，则新建一个节点，放到链表头部，
 * 若缓存满了，则把链表最后一个节点删除即可。在访问数据的时候，如果数据项在链表中存在，
 * 则把该节点移到链表头部，否则返回-1。这样一来在链表尾部的节点就是最近最久未访问的数据项。
 *
 * 比较三种方法优劣：
 * 对于第一种方法，需要不停地维护数据项的访问时间戳，另外，在插入数据、
 * 删除数据以及访问数据时，时间复杂度都是O(n)。
 * 对于第二种方法，链表在定位数据的时候时间复杂度为O(n)。
 * 所以在一般使用第三种方式来是实现LRU算法。
 *
 * 使用LinkedHashMap实现
 * LinkedHashMap底层就是用的HashMap加双链表实现的，而且本身已经实现了按照访问顺序的存储。
 * 此外，LinkedHashMap中本身就实现了一个方法removeEldestEntry
 * 用于判断是否需要移除最不常读取的数，方法默认是直接返回false，不会移除元素，
 * 所以需要重写该方法。即当缓存满后就移除最不常用的数。
 * LinkedHashMap每次get的时候把访问的到的数据移动到最后一个位置,
 * 在put的时候如果已经满了,删除第一个 afterNodeInsertion方法
 */
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {

	private final int maxCapacity;

	private static final float DEFAULT_LOAD_FACTOR = 0.75f;

	private final Lock lock = new ReentrantLock();

	public LRULinkedHashMap(int maxCapacity) {
		super(maxCapacity, DEFAULT_LOAD_FACTOR, true);
		this.maxCapacity = maxCapacity;
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > maxCapacity;
	}
	@Override
	public boolean containsKey(Object key) {
		try {
			lock.lock();
			return super.containsKey(key);
		} finally {
			lock.unlock();
		}
	}


	@Override
	public V get(Object key) {
		try {
			lock.lock();
			return super.get(key);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public V put(K key, V value) {
		try {
			lock.lock();
			return super.put(key, value);
		} finally {
			lock.unlock();
		}
	}

	@Override
	public int size() {
		try {
			lock.lock();
			return super.size();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void clear() {
		try {
			lock.lock();
			super.clear();
		} finally {
			lock.unlock();
		}
	}

	public Collection<Map.Entry<K, V>> getAll() {
		try {
			lock.lock();
			return new ArrayList<Map.Entry<K, V>>(super.entrySet());
		} finally {
			lock.unlock();
		}
	}

}
