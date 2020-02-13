import java.util.ArrayList;

public class Repository {

    private ArrayList<Commit> commits;
    private String name;
    private String description;
    private RepositoryType repositoryType;


    public Repository(String name, String description, RepositoryType repositoryType) {
        this.commits = new ArrayList<>();
        this.name = name;
        this.description = description;
        this.repositoryType = repositoryType;
    }

    public int getNoOfCommits() {
        return commits.size();
    }

    public ArrayList<Commit> getCommits() {
        return commits;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public RepositoryType getRepositoryType() {
        return repositoryType;
    }

    public void addCommit(Commit commit){
        this.commits.add(commit);
    }

    public Commit getCommitByUniqueId(String uniqueIDToFind){
        for (Commit commit : this.commits){
            if (commit.getUniqueId() == uniqueIDToFind){
                return commit;
            }
        }
        return null;
    }


    public void revertToCommit(String commitUniqueId){
        ArrayList<Commit> revertedCommits = new ArrayList<>();
        for (Commit currentCommit : this.commits){
            revertedCommits.add(currentCommit);
            if (currentCommit.getUniqueId() == commitUniqueId){
                this.commits = revertedCommits;
                return;
            }
        }
    }
}
