import LRUChach.LRUChachData;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static final int maxSize = 2;//Chachのサイズ。この値を超えるとアクセスが古いデータから消えていく
    static List<LRUChachData> LRUChachs = new ArrayList<>();
    public static void main(String[] args) {
        Main lru = new Main();
        LRUChachData LRUChachData;

        lru.put("a","dataA");
        System.out.println("lru.put(" + lru.get("a").key+"),(" +  lru.get("a").value + ")");

        lru.put("b","dataB");
        System.out.println("lru.put(" + lru.get("b").key+"),(" +  lru.get("b").value + ")");

        LRUChachData = lru.get("a");
        System.out.println("lru.get(" + LRUChachData.key+"),(" +  LRUChachData.value + ")");

        lru.put("c","dataC");
        System.out.println("lru.get(" + lru.get("c").key+"),(" +  lru.get("c").value+ ")");

        LRUChachData = lru.get("b");
        System.out.println("lru.get(" + LRUChachData.key+"),(" +  LRUChachData.value+ ")");
    }

    ///summary
    ///keyとvalueをLRUChachDataの型に変換してListのLRUChachsに追加する
    ///summary
    public void put(String key, String value)
    {
        Main _main = new Main();
        LRUChachData _LRUChachData;
        _LRUChachData = new LRUChachData(key,value);
        LRUChachs.add(_LRUChachData);
        if(_main.overMaxSize())
        {
            deleteEldestData();
        }
    }

    ///summary
    ///getDataを行いデータを返すと共にsortListの両方行う
    ///summary
    public  LRUChachData get(String getKey)
    {
        Main _main = new Main();
        _main.sortList(getKey);
        return _main.getData(getKey);
    }

    ///summary
    ///引数のkeyで指定したデータがLRUChachsの中にあればデータを返す
    ///summary
    public  LRUChachData getData(String getKey)
    {
        final LRUChachData[] _LRUChachData = new LRUChachData[1];
        _LRUChachData[0] = new LRUChachData(getKey, "null");//指定したkeyが無ければNull!のvalueを返す
        LRUChachs.forEach(item ->
        {
            if(item.key.equals(getKey))
            {
                _LRUChachData[0] = new LRUChachData(item.key, item.value);
            }
        });
        return _LRUChachData[0];
    }

    ///summary
    ///LRUChachsの要素数が最大数以上ならtrue値を返す
    ///summary
    public  boolean overMaxSize()
    {
        return (long) LRUChachs.size() > maxSize;
    }

    ///summary
    ///一番古いデータを削除する
    ///summary
    public  void deleteEldestData()
    {
        LRUChachs.remove(0);
    }

    ///summary
    ///使用した場合に使用したデータを先頭に持ってくる
    ///summary
    public  void sortList(String useDataKey)
    {
        Main _main = new Main();
        List<LRUChachData> tempLRUChachs = new ArrayList<>();
        LRUChachs.forEach(item ->{
            if(!item.key.equals(useDataKey)){
                tempLRUChachs.add(item);
            }
        });
        tempLRUChachs.add(_main.getData(useDataKey));
        LRUChachs = tempLRUChachs;
    }
}