package client;

import api.JiraInformation;
import org.junit.Test;

public class JiraClientTest {

    @Test
    public void testClient() {
        JiraClient client = new JiraClient();
        JiraInformation jiraInformation = client.fetchJiraInformation("PAL-2").get();
        System.out.println(jiraInformation);
    }
}
