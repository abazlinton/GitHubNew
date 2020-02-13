import java.util.HashMap;

public class GitHubAccount {

    private String username;
    private String name;
    private AccountType accountType;
    private HashMap<String, Repository> repositories;


    public GitHubAccount(String username, String name) {
        this.username = username;
        this.name = name;
        this.repositories = new HashMap<>();
        this.accountType = AccountType.FREE;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public void upgradeAccount() {
        this.accountType = AccountType.PRO;
    }

    public void downgradeAccount() {
        this.accountType = AccountType.FREE;
    }

    public void addRepository(Repository repositoryToAdd){
        this.repositories.put(repositoryToAdd.getName(), repositoryToAdd);
    }

    public Repository getRepositoryByName(String repoName){
        return this.repositories.get(repoName);
    }


    public Repository getRepositoryWithMostCommits(){
        Repository repositoryWithMostCommits = null;
        int mostCommitsSoFar = -1;
        for (Repository currentRepository : this.repositories.values()){
            int commitsForCurrentRepository = currentRepository.getNoOfCommits();
            if (commitsForCurrentRepository > mostCommitsSoFar){
                repositoryWithMostCommits = currentRepository;
                mostCommitsSoFar = commitsForCurrentRepository;
            }
        }
        return repositoryWithMostCommits;
    }

}
