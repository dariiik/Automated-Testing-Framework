import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.test.autoconfigure.cache.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

@SpringBootTest 
@AutoConfigureCache 

public class CachingTest { 

    @Autowired 
    private MyDataService myDataService;
    @Autowired 
    private CacheManager cacheManager; 

    @BeforeEach 
    public void clearCacher() {
        Cache cache = cacheManager.getCache("cache-name"); 
        if (cache != null) {
            cache.clear();
        }
    }

    @Test 
    public void TestCachingEnabled() { 
        Cache cache = cacheManager.getCache("cache-name"); 


    }

    @Test 
    public void TestCacheHit() {
        String data1 = myDataService.getData("key1"); 
        String data2 = myDataService.getData("key1"); 
        assertEquals(data1, data2);                                                                                                                                                        
    }
    @Test 
    public void TestCahceMiss() {
        String data1 = myDataService.getData("key1"); 
        String data2 = myDataService.getData("key2"); 
        assertEquals("data for key: key1", data1); 
        assertEquals("data for key: key2", data2);
    }
}
