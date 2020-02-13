import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GitHubAccountTest {

    private GitHubAccount alex;

    @Before
    public void before(){
        alex = new GitHubAccount("abazlinton", "Alex Bazlinton");
    }

    @Test
    public void has_username(){
        assertEquals("abazlinton", alex.getUsername());
    }

    @Test
    public void has_name(){
        assertEquals("Alex Bazlinton", alex.getName());
    }

    @Test
    public void all_accounts_start_free(){
        assertEquals(AccountType.FREE, alex.getAccountType());
    }

    @Test
    public void can_upgrade_account(){
        alex.upgradeAccount();
        assertEquals(AccountType.PRO, alex.getAccountType());
    }

    @Test
    public void can_downgrade_account(){
        alex.upgradeAccount();
        alex.downgradeAccount();
        assertEquals(AccountType.FREE, alex.getAccountType());
    }

    @Test
    public void can_get_repo_by_name(){
        Repository hotelRepository = new Repository("hotel", "great hotel!", RepositoryType.PUBLIC);
        alex.addRepository(hotelRepository);
        Repository foundRepository = alex.getRepositoryByName("hotel");
        assertEquals("hotel", foundRepository.getName());
    }

    @Test
    public void can_get_repo_with_most_commits(){
        Repository hotelRepository = new Repository("hotel", "great hotel!", RepositoryType.PUBLIC);
        alex.addRepository(hotelRepository);
        Repository libraryRepository = new Repository("library", "all the books!", RepositoryType.PUBLIC);
        libraryRepository.addCommit(new Commit("first commit", "a2514"));
        alex.addRepository(libraryRepository);
        Repository repoWithMostCommits = alex.getRepositoryWithMostCommits();
        assertEquals("library", repoWithMostCommits.getName());
    }

}
