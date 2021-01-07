package com.boyitech.logstream.server;

import com.boyitech.logstream.core.cache.BaseCache;
import com.boyitech.logstream.core.factory.CacheFactory;
import com.boyitech.logstream.core.info.Event;
import com.boyitech.logstream.core.manager.indexer.BaseIndexerManager;
import com.boyitech.logstream.core.setting.Settings;
import com.boyitech.logstream.core.util.GsonHelper;
import com.boyitech.logstream.core.worker.indexer.BaseIndexer;
import com.boyitech.logstream.core.worker.indexer.BaseIndexerConfig;
import com.boyitech.logstream.core.worker.porter.BasePorterConfig;
import com.boyitech.logstream.core.worker.porter.elasticsearch.ElasticsearchPorter;
import com.boyitech.logstream.core.worker.porter.elasticsearch.ElasticsearchPorterConfig;
import com.boyitech.logstream.worker.indexer.MicrosoftWindowsAllV1Indexer;
import com.boyitech.logstream.worker.indexer.SquidSquidAccessV1Indexer;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author juzheng
 * @date 2019/10/31 5:58 PM
 * @Description: 这是为了管理平台的告警写的，把数据发送到es的测试类。
 */
public class AlertPortSquidToESTest {
    private BaseCache LV2cache;
    private String comName="alert-test-20191101-3-squid";
    private String indexerName="squid_squid_access_v1";
    private String FILEPATH="/Users/juzheng/Desktop/squid.txt";
    @Before
    public void buildEventTest() throws InterruptedException {
        LV2cache = CacheFactory.createCache();
        Map<String, String> map = new HashMap();
        map.put("logType", indexerName);
        BaseIndexerConfig baseIndexerConfig = new BaseIndexerConfig(map);
        BaseIndexer indexer = new SquidSquidAccessV1Indexer(baseIndexerConfig);
        indexer.register();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(new File(FILEPATH)));
            String s;
            while ((s = br.readLine()) != null)
            {
                Event e = new Event();
                e.setMessage(s);
                e.setIndex(comName+"-"+indexerName);
                e.setLogType(indexerName);
                indexer.format(e);
                for (int i = 0; i < 10000; i++) {
                    LV2cache.offer(e);
                }
            }
            br.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //是否能正确创建索引，以及是否能正确上传mapping和写入数据
    @Test
    public void testESPorter() throws InterruptedException {
        Settings.load();
        String jsonConfig = "{" +
                "\"moduleType\": \"elasticsearch\"," +
                "\"ip\": \"172.17.30.10\"," +
                "\"port\": \"9300\"" +
                "}";

        Map<String, String> map = GsonHelper.fromJson(jsonConfig);
        BasePorterConfig config = new ElasticsearchPorterConfig(map);
        ElasticsearchPorter elasticSearchPorter = new ElasticsearchPorter(config);
        BaseIndexerManager.putMapping(indexerName, SquidSquidAccessV1Indexer.class);
        elasticSearchPorter.setLv2Cache(LV2cache);
        elasticSearchPorter.setLv3Cache(null);
        elasticSearchPorter.doStart();
        while (true){
            Thread.sleep(1000);
        }
    }

}