import java.util.ArrayList;
import java.util.List;

public class LRUCache {
    private static final int maxSize = 2;//Cacheのサイズ。この値を超えるとアクセスが古いデータから消えていく
    static List<LRUCacheData> LRUCacheList = new ArrayList<>();//LRUCacheを格納するリスト

    /**
    *keyとvalueをLRUCacheDataの型に変換してListのLRUCachesに追加する。
    */
    public void put(String key, String value)
    {
        LRUCache _lrucache = new LRUCache();
        LRUCacheData _lruCachedata;
        _lruCachedata = new LRUCacheData(key,value);
        LRUCacheList.add(_lruCachedata);//リストにデータの追加
        if(_lrucache.overMaxSize())
        {
            deleteEldestData();     //リストが最大数を超えた場合古いデータを削除
        }
    }

    /**
     * getDataを行いデータを返すと共にsortListの両方行う。
     */
    public LRUCacheData get(String getKey)
    {
        LRUCache _main = new LRUCache();
        _main.sortList(getKey);
        return _main.getData(getKey);
    }

    /**
    *引数のkeyで指定したデータがLRUCacheListの中にあればデータを返す。
    */
    public LRUCacheData getData(String getKey)
    {
        final LRUCacheData[] _lruCacheData = new LRUCacheData[1];
        _lruCacheData[0] = new LRUCacheData(getKey, "null");//指定したkeyが無ければNull!のvalueを返す
        LRUCacheList.forEach(item ->
        {
            if(item.key.equals(getKey))
            {
                _lruCacheData[0] = new LRUCacheData(item.key, item.value);
            }
        });
        return _lruCacheData[0];
    }

    /**
    *LRUCacheの要素数が最大数以上ならtrue値を返す。
    */
    public  boolean overMaxSize()
    {
        return (long) LRUCacheList.size() > maxSize;
    }

    /**
    *一番古いデータを削除する。
    */
    public  void deleteEldestData()
    {
        LRUCacheList.remove(0);
    }

    /**
    *使用した場合に使用したデータを先頭に持ってくる。
    */
    public  void sortList(String useDataKey)
    {
        LRUCache _lruCache = new LRUCache();
        List<LRUCacheData> _tempLRUCache = new ArrayList<>();
        LRUCacheList.forEach(item ->{
            if(!item.key.equals(useDataKey)){
                _tempLRUCache.add(item);
            }
        });
        _tempLRUCache.add(_lruCache.getData(useDataKey));
        LRUCacheList = _tempLRUCache;
    }
}