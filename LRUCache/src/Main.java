import LRUChach.LRUChachData;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private static final int maxSize = 2;
    static List<LRUChachData> LRUChachs = new ArrayList<>();
    public static void main(String[] args) {
        Main _main = new Main();
        _main.setData("a","DataA");
        System.out.println("key:" + _main.getData("a").key+"  value:" +  _main.getData("a").value);
        _main.setData("b","DataB");
        System.out.println("key:" + _main.getData("b").key+"  value:" +  _main.getData("b").value);

        LRUChachs.forEach(item ->{
            System.out.println("ALLDATA => key:" + item.key+"  value:" +  item.value);
        });
    }

    ///summary
    ///keyとvalueをLRUChachDataの型に変換してListのLRUChachsに追加する
    ///summary
    public void setData(String key,String value)
    {
        LRUChachData _LRUChachData;
        _LRUChachData = new LRUChachData(key,value);
        LRUChachs.add(_LRUChachData);
    }

    ///summary
    ///引数のkeyで指定したデータがLRUChachsの中にあればデータを返す；
    ///summary
    public  LRUChachData getData(String getKey)
    {
        final LRUChachData[] _LRUChachData = new LRUChachData[1];
        _LRUChachData[0] = new LRUChachData(getKey, "Null!");//指定したkeyが無ければNull!のvalueを返す
        LRUChachs.forEach(item ->
        {
            if(item.key.equals(getKey))
            {
                _LRUChachData[0] = new LRUChachData(item.key, item.value);
            }
        });
        return _LRUChachData[0];
    }
}