import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class GitHubTest {

    @Test
    public void can_sort_accounts_by_username(){
        GitHub github = new GitHub();
        GitHubAccount alex = new GitHubAccount("alex", "alex");
        GitHubAccount john = new GitHubAccount("john", "john");
        GitHubAccount del = new GitHubAccount("del", "del");
        GitHubAccount colin = new GitHubAccount("colin", "colin");
        github.addGitHubAccount(colin);
        github.addGitHubAccount(alex);
        github.addGitHubAccount(del);
        github.addGitHubAccount(john);
        ArrayList<GitHubAccount> sortedAccounts = github.getAccountsAlphabetically();
        ArrayList<GitHubAccount> expected = new ArrayList<>(Arrays.asList(alex, colin, del, john));
        assertArrayEquals(expected.toArray(), sortedAccounts.toArray());
    }

}
