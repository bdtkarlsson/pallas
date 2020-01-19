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
    public void testGetTransitions() {
        JiraClient client = new JiraClient();
        client.getTransitions("PAL-4");
    }

    @Test
    public void testComment() {
        JiraClient client = new JiraClient();
        int rsp = client.addComment("PAL-2", "Hejsan mamma och pappa2");
        System.out.println(rsp);
    }

    @Test
    public void testChangeStatus() {
        JiraClient client = new JiraClient();
        int rsp = client.performTransition("PAL-4", 41);
        System.out.println(rsp);
    }
}
