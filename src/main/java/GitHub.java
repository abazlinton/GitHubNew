import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GitHub {

    private HashMap<String, GitHubAccount> gitHubAccounts;

    public GitHub() {
        this.gitHubAccounts = new HashMap<>();
    }

    public void addGitHubAccount(GitHubAccount gitHubAccount){
        this.gitHubAccounts.put(gitHubAccount.getUsername(), gitHubAccount);
    }

    public ArrayList<GitHubAccount> getAccountsAlphabetically(){
        ArrayList<String> usernames = new ArrayList<>(this.gitHubAccounts.keySet());
        Collections.sort(usernames);
        ArrayList<GitHubAccount> sortedAccounts = new ArrayList<>();
        for (String username : usernames ){
            sortedAccounts.add(this.gitHubAccounts.get(username));
        }
        return sortedAccounts;
    }


}



