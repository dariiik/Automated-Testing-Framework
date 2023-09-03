import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.cache.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest 
@AutoConfigureCache 
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class ConcurrencyCachingTest {
    @Autowired 
    private MyDataService myDataService; 
    @Autowired 
    private CacheManager cacheManager; 

    private ExecutorService executorService;

    @BeforeEach 

    public void setup() {
        executorService = Executors.newFixedThreadPool(5); 
    }
    @RepeatedTest(10) 
    public void testConcurrentCacheAccess() throws Exception {
        int numberOfThreads = 5; 
        CountDownLatch = new CountDownLatch(numberOfThreads); 
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
                try {
                    String data = myDataService.getData("key1"); 
                    assertEquals("Data for key: key1", data1);
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await(5, TimeUnit.SECONDS);
    }

    @RepeatedTest(10)

    public void testConcurrentCacheEviction() throws Exception {
        int numberOfThreads = 5; 
        CountDownLatch latch = new CountDownLatch(numberOfThreads); 
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
                try {
                    // Simulate concurrent access to the cache
                    String data = myDataService.getData("key2");

                    // Ensure that the data is the same for all threads (cache hit)
                    assertEquals("Data for key: key2", data);
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await(5, TimeUnit.SECONDS);
    }
}
