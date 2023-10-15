import LRUChach.LRUChachData;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int maxSize = 2;//Chachのサイズ。この値を超えるとアクセスが古いデータから消えていく
    static List<LRUChachData> LRUChachs = new ArrayList<>();//LRUChachを格納するリスト

    /**
    *keyとvalueをLRUChachDataの型に変換してListのLRUChachsに追加する
    */
    public void put(String key, String value)
    {
        Main _main = new Main();
        LRUChachData _LRUChachData;
        _LRUChachData = new LRUChachData(key,value);
        LRUChachs.add(_LRUChachData);//リストにデータの追加
        if(_main.overMaxSize())
        {
            deleteEldestData();     //リストが最大数を超えた場合古いデータを削除
        }
    }

    /**
     * getDataを行いデータを返すと共にsortListの両方行う
     */
    public  LRUChachData get(String getKey)
    {
        Main _main = new Main();
        _main.sortList(getKey);
        return _main.getData(getKey);
    }

    /**
    *引数のkeyで指定したデータがLRUChachsの中にあればデータを返す
    */
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

    /**
    *LRUChachsの要素数が最大数以上ならtrue値を返す
    */
    public  boolean overMaxSize()
    {
        return (long) LRUChachs.size() > maxSize;
    }

    /**
    *一番古いデータを削除する
    */
    public  void deleteEldestData()
    {
        LRUChachs.remove(0);
    }

    /**
    *使用した場合に使用したデータを先頭に持ってくる
    */
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