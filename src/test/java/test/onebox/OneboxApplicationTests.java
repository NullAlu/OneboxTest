package test.onebox;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "/application.properties")
public class OneboxApplicationTests {
        @Test
        public void applicationContextTest() {
            OneboxApplication.main(new String[]{});
        }
    }

