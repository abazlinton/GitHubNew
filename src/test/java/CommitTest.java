import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommitTest {

    private Commit commit;

    @Before
    public void before() {
        commit = new Commit("first commit", "a1234");
    }

    @Test
    public void has_message() {
        assertEquals("first commit", commit.getMessage());
    }

    @Test
    public void has_unique_id() {
        assertEquals("a1234", commit.getUniqueId());
    }
}
