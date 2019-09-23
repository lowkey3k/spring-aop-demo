package hliu.demo.collections;

/**
 * @author LiHaitao
 * @description Main:
 * @date 2019/8/19 15:13
 **/
public class Main {
    public static void main(String[] args) {
//
//        /**
//         * The default initial capacity - MUST be a power of two.
//         */
//        static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
//
//        /**
//         * The maximum capacity, used if a higher value is implicitly specified
//         * by either of the constructors with arguments.
//         * MUST be a power of two <= 1<<30.
//         */
//        static final int MAXIMUM_CAPACITY = 1 << 30;

        /**
         * The load factor used when none specified in constructor.
         */
//        static final float DEFAULT_LOAD_FACTOR = 0.75f;

        /**
         * The bin count threshold for using a tree rather than list for a
         * bin.  Bins are converted to trees when adding an element to a
         * bin with at least this many nodes. The value must be greater
         * than 2 and should be at least 8 to mesh with assumptions in
         * tree removal about conversion back to plain bins upon
         * shrinkage.
         */
//        static final int TREEIFY_THRESHOLD = 8;

        /**
         * The bin count threshold for untreeifying a (split) bin during a
         * resize operation. Should be less than TREEIFY_THRESHOLD, and at
         * most 6 to mesh with shrinkage detection under removal.
         */
//        static final int UNTREEIFY_THRESHOLD = 6;

        /**
         * The smallest table capacity for which bins may be treeified.
         * (Otherwise the table is resized if too many nodes in a bin.)
         * Should be at least 4 * TREEIFY_THRESHOLD to avoid conflicts
         * between resizing and treeification thresholds.
         */
//        static final int MIN_TREEIFY_CAPACITY = 64;

        /**
         * Node：静态内部类，节点存储
         * key ：类似指针
         * value： 值
         * nest： 下个节点
         * hash：哈希值
         */
//        static class Node<K,V> implements Map.Entry<K,V> {
//            final int hash;
//            final K key;
//            V value;
//            HashMap.Node<K,V> next;
//
//            Node(int hash, K key, V value, HashMap.Node<K,V> next) {
//                this.hash = hash;
//                this.key = key;
//                this.value = value;
//                this.next = next;
//            }
//
//            public final K getKey()        { return key; }
//            public final V getValue()      { return value; }
//            public final String toString() { return key + "=" + value; }
//
//            public final int hashCode() {
//                return Objects.hashCode(key) ^ Objects.hashCode(value);
//            }
//            //set新的值返回旧值
//            public final V setValue(V newValue) {
//                V oldValue = value;
//                value = newValue;
//                return oldValue;
//            }
//
//            public final boolean equals(Object o) {
//                if (o == this)
//                    return true;
//                if (o instanceof Map.Entry) {
//                    Map.Entry<?,?> e = (Map.Entry<?,?>)o;
//                    if (Objects.equals(key, e.getKey()) &&
//                            Objects.equals(value, e.getValue()))
//                        return true;
//                }
//                return false;
//            }
//        }


        /**
         * initialCapacity： 初始容量
         * loadFactor: 负载因子
         * MAXIMUM_CAPACITY：最大容量
         * threshold：The next size value at which to resize (capacity * load factor)调整大小的下一个值（容量*负载因子)
         * 注意：如果大于最大容量MAXIMUM_CAPACITY，还是MAXIMUM_CAPACITY。
         */
//        public HashMap(int initialCapacity, float loadFactor) {
//            if (initialCapacity < 0)
//                throw new IllegalArgumentException("Illegal initial capacity: " +
//                        initialCapacity);
//            if (initialCapacity > MAXIMUM_CAPACITY)
//                initialCapacity = MAXIMUM_CAPACITY;
//            if (loadFactor <= 0 || Float.isNaN(loadFactor))
//                throw new IllegalArgumentException("Illegal load factor: " +
//                        loadFactor);
//            this.loadFactor = loadFactor;
//            this.threshold = tableSizeFor(initialCapacity);
//        }

        /**
         * 构造一个空的HashMap，具有指定的初始容量和缺省负载因子(0.75)。
         */
//         public HashMap(int initialCapacity) {
//            this(initialCapacity, DEFAULT_LOAD_FACTOR);
//        }
        /**
         * 构造器重载：负载因子为0.75f，容量为默认容量 16
         */
//         public HashMap() {
//            this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
//        }
        /**
         * 使用与指定的Map相同的映射构造一个新的HashMap。
         * 创建HashMap时使用了默认的负载因子(0.75)和足够容纳指定Map中的映射的初始容量。
         *  putMapEntries(m, false): 将指定map构造出来，内部实现了扩容等操作
         */
//         public HashMap(Map<? extends K, ? extends V> m) {
//            this.loadFactor = DEFAULT_LOAD_FACTOR;
//            putMapEntries(m, false);
//        }

        /**
         *  将指定map构造出来，内部实现了扩容等操作
         */
//        final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
//            int s = m.size();
//            if (s > 0) {
        //当前table为null，没有数据
//                if (table == null) { // pre-size
//                    float ft = ((float)s / loadFactor) + 1.0F; //根据负载因子计算要存储的容量
//                    int t = ((ft < (float)MAXIMUM_CAPACITY) ?
//                            (int)ft : MAXIMUM_CAPACITY);
//                    if (t > threshold)
//                        threshold = tableSizeFor(t); //根据计算得出要扩容的大小，为初始threshold的二次幂
//                }
        //如果table不为null，则根据要新存储的map容量来计算是否需要扩容
//                else if (s > threshold)
//                    resize();//扩容
        //put进数据
//                for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
//                    K key = e.getKey();
//                    V value = e.getValue();
//                    putVal(hash(key), key, value, false, evict);
//                }
//            }
//        }

        /**
         * 返回map的大小
         */
//        public int size() {
//            return size;
//        }

        /**
         *根据size来判断是否map为空
         */
//        public boolean isEmpty() {
//            return size == 0;
//        }

        /**
         * 根据key获取value
         */
//        public V get(Object key) {
//            HashMap.Node<K,V> e;
//            return (e = getNode(hash(key), key)) == null ? null : e.value;
//        }

    }
}
