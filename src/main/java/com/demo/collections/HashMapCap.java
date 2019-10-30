package com.demo.collections;

/**
 * @author LiHaitao
 * @description HashMapCap:
 * @date 2019/10/16 18:02
 **/
public class HashMapCap {
    /**
     * hashMap容量问题：
     *hashMap是通过key的hash运算，解决key在哪？
     * 在java8中，key的位置下标通过(n - 1) & hash计算所得。
     * 下标计算方法设计好，将会为查询带来很多好处。
     * 1，为什么要保证容量n为2的整数倍？
     *   n为2的整数倍，那么n-1就是一个奇数，奇数的最后一位肯定为1.
     *   为1的好处就是(n-1) & hash的值后一位为0或者为1，如果n不是2的
     *   整数幂，那么(n-1) & hash的运算结果后一位始终为0，这样下标结果肯定为偶数
     *   导致所有的数据都只能存放在偶数位置。
     * 好处： 1，使元素分布均匀
     *       2，&的运算速度比%快
     *       3，保证结果在n以内，不会超出它的容量
     *  2，关于hash值？
     *   hashMap的默认容量为16.
     *   hashMap中的hash作了特殊处理，将key的hashCode值h进行右移16位（h >>> 16）
     *   然后将h与右移后的h做异或运算。实际就是把一个数的低16位和高16位做异或运算。
     *   在(n - 1) & hash 的计算中，hash变量只有末x位会参与到运算。使高16位也参与到hash的运算能减少冲突。
     *
     *
     *   3，n永远是2次幂？
     *   如果初始化的容量不是2的整数次幂，回通过方法tableSizeFor返回一个2的整数次幂。
     */


    //    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
    //                   boolean evict) {
    //        HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;
    //        if ((tab = table) == null || (n = tab.length) == 0)
    //            n = (tab = resize()).length;
    //        if ((p = tab[i = (n - 1) & hash]) == null)
    //            tab[i] = newNode(hash, key, value, null);
    //        else {
    //            HashMap.Node<K,V> e; K k;
    //            if (p.hash == hash &&
    //                    ((k = p.key) == key || (key != null && key.equals(k))))
    //                e = p;
    //            else if (p instanceof HashMap.TreeNode)
    //                e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
    //            else {
    //                for (int binCount = 0; ; ++binCount) {
    //                    if ((e = p.next) == null) {
    //                        p.next = newNode(hash, key, value, null);
    //                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
    //                            treeifyBin(tab, hash);
    //                        break;
    //                    }
    //                    if (e.hash == hash &&
    //                            ((k = e.key) == key || (key != null && key.equals(k))))
    //                        break;
    //                    p = e;
    //                }
    //            }
    //            if (e != null) { // existing mapping for key
    //                V oldValue = e.value;
    //                if (!onlyIfAbsent || oldValue == null)
    //                    e.value = value;
    //                afterNodeAccess(e);
    //                return oldValue;
    //            }
    //        }
    //        ++modCount;
    //        if (++size > threshold)
    //            resize();
    //        afterNodeInsertion(evict);
    //        return null;
    //    }


    //    static final int hash(Object key) {
    //        int h;
    //        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    //    }
    //


    //    /**
    //     * Returns a power of two size for the given target capacity.
    //     */
    //    static final int tableSizeFor(int cap) {
    //        int n = cap - 1;
    //        n |= n >>> 1;
    //        n |= n >>> 2;
    //        n |= n >>> 4;
    //        n |= n >>> 8;
    //        n |= n >>> 16;
    //        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    //    }
}
