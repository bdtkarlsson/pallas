package client;

import api.JiraInformation;
import org.junit.Test;

public class JiraClientTest {

    @Test
    public void testFetchInformation() {
        JiraClient client = new JiraClient();
        JiraInformation jiraInformation = client.fetchJiraInformation("PAL-4").get();
        System.out.println(jiraInformation);
    }

    @Test
    public void testComment() {
        JiraClient client = new JiraClient();
        client.addComment("PAL-2", "Hejsan mamma och pappa");
    }
}
