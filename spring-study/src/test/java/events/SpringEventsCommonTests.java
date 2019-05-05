package events;

import com.events.RegisterEventPublisher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * events
 * <p>
 * Created by tianxin2 on 2019-05-03
 */

public class SpringEventsCommonTests {

    @Autowired
    private RegisterEventPublisher registerEventPublisher;

    @Test
    public void test1(){
        registerEventPublisher.publisher(" Danny is here.");
        try {
            Thread.sleep(10 * 1000);
        } catch (Exception e) {
//            log.error("{}", e);
        }
    }

}
