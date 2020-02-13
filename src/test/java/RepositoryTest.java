import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RepositoryTest {

    private Repository hotelRepository;
    private Commit firstCommit;
    private Commit secondCommit;


    @Before
    public void before(){
        hotelRepository = new Repository("hotel", "my great hotel", RepositoryType.PRIVATE);
        firstCommit = new Commit("First Commit", "a4343");
        secondCommit = new Commit("Fix typo", "a4734");
        hotelRepository.addCommit(firstCommit);
        hotelRepository.addCommit(secondCommit);
    }

    @Test
    public void has_name(){
        assertEquals("hotel", hotelRepository.getName());
    }

    @Test
    public void has_description(){
        assertEquals("my great hotel", hotelRepository.getDescription());
    }

    @Test
    public void has_repo_type(){
        assertEquals(RepositoryType.PRIVATE, hotelRepository.getRepositoryType());
    }


    @Test
    public void starts_with_zero_commits(){
        hotelRepository = new Repository("hotel", "my great hotel", RepositoryType.PRIVATE);
        assertEquals(0, hotelRepository.getNoOfCommits());
    }

    @Test
    public void can_add_commit(){
        hotelRepository = new Repository("hotel", "my great hotel", RepositoryType.PRIVATE);
        hotelRepository.addCommit(firstCommit);
        assertEquals(1, hotelRepository.getNoOfCommits());
    }

    @Test
    public void can_get_commit_by_uniqueId(){
        Commit foundCommit = hotelRepository.getCommitByUniqueId("a4343");
        assertEquals("a4343", foundCommit.getUniqueId());
    }

    @Test
    public void commit_not_found_returns_null(){
        Commit foundCommit = hotelRepository.getCommitByUniqueId("e");
        assertNull(foundCommit);
    }

    @Test
    public void can_revert(){
        Commit thirdCommit = new Commit("Refactor", "a2382");
        hotelRepository.addCommit(thirdCommit);
        hotelRepository.revertToCommit("a4734");
        ArrayList<Commit> expectedCommits = new ArrayList<>();
        expectedCommits.add(firstCommit);
        expectedCommits.add(secondCommit);
        assertArrayEquals(expectedCommits.toArray(), hotelRepository.getCommits().toArray());
    }

    @Test
    public void does_not_revert_if_commit_not_found(){
        hotelRepository.revertToCommit("d");
        ArrayList<Commit> expectedCommits = new ArrayList<>();
        expectedCommits.add(firstCommit);
        expectedCommits.add(secondCommit);
        assertArrayEquals(expectedCommits.toArray(), hotelRepository.getCommits().toArray());
    }


}
