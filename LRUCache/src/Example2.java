/**
 * サイズが2の時の例2。
 * getされたら使われたとみなす
 */
public class Example2 {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache();
        LRUCacheData LRUChachData;

        lru.put("a","dataA");
        System.out.println("lru.put(" + lru.get("a").key+"),(" +  lru.get("a").value + ")");

        lru.put("b","dataB");
        System.out.println("lru.put(" + lru.get("b").key+"),(" +  lru.get("b").value + ")");

        lru.put("c","dataC");
        System.out.println("lru.put(" + lru.get("c").key+"),(" +  lru.get("c").value+ ")");

        LRUChachData = lru.get("a");
        System.out.println("lru.get(" + LRUChachData.key+"),(" +  LRUChachData.value+ ")");
    }
}
