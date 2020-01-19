package client;

import api.JiraInformation;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Optional;

public class JiraClient {

    private static final String JIRA_URL = "https://project-pallas.atlassian.net";
    private static final String SUPER_SECRET_LOL = "YmR0a2FybHNzb25AZ21haWwuY29tOmN6ekJzMFlEeWEwS2dLYmVSR1k1OUVCMg";
    private CloseableHttpClient httpClient;
    private Gson gson;

    public JiraClient() {
        gson = new Gson();
        httpClient = HttpClients.createDefault();
    }


    public int addComment(String jiraIdentifier, String comment) {
        try {
            HttpPost request = new HttpPost(JIRA_URL + "/rest/api/2/issue/" + jiraIdentifier + "/comment" );
            String body = "{" +
                    "\"body\":\"" + comment + "\",\"visibility\": {\"type\": \"role\", \"value\": \"Administrators\"}}";
            StringEntity entity = new StringEntity(body);
            request.setEntity(entity);

            request.addHeader("Authorization", "Basic " + SUPER_SECRET_LOL);
            request.addHeader("content-type", "application/json; charset=UTF-8");

            CloseableHttpResponse rsp = httpClient.execute(request);
            return rsp.getStatusLine().getStatusCode();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nu gick det åt skogen");
            return -1;
        }
    }

    public void getTransitions(String jiraIdentifier) {
        HttpGet req = new HttpGet(JIRA_URL + "/rest/api/2/issue/" + jiraIdentifier + "transitions");
        req.addHeader("Authorization", "Basic " + SUPER_SECRET_LOL);
        req.addHeader("content-type", "application/json; charset=UTF-8");

        try {
            CloseableHttpResponse rsp = httpClient.execute(req);
            String responseAsString = getResponseAsString(rsp);
            // Parse transitions into a list and call at init in JiraToolWindow

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int changeStatus(String jiraIdentifier, String comment) {
        try {
            // http://localhost:8080/jira/rest/api/2/issue/JC-11/transitions?expand=transitions.fields
            HttpPost request = new HttpPost(JIRA_URL + "/rest/api/2/issue/" + jiraIdentifier + "/transitions?expand=transitions.fields" );
            // UPDATE the body to be correct
            String body = "{" +
                    "\"body\":\"" + comment + "\",\"visibility\": {\"type\": \"role\", \"value\": \"Administrators\"}}";
            StringEntity entity = new StringEntity(body);
            request.setEntity(entity);

            request.addHeader("Authorization", "Basic " + SUPER_SECRET_LOL);
            request.addHeader("content-type", "application/json; charset=UTF-8");

            CloseableHttpResponse rsp = httpClient.execute(request);
            return rsp.getStatusLine().getStatusCode();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nu gick det åt skogen");
            return -1;
        }
    }

    public Optional<JiraInformation> fetchJiraInformation(String jiraIdentifier) {

        try {
            HttpGet request = new HttpGet(JIRA_URL + "/rest/api/latest/issue/" + jiraIdentifier);

            request.addHeader("Authorization", "Basic " + SUPER_SECRET_LOL);
            CloseableHttpResponse response = httpClient.execute(request);
            String info = getResponseAsString(response);
            JiraInformation jiraInformation = convertToJiraInformation(info);
            return Optional.of(jiraInformation);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nu gick det åt skogen");
            return Optional.empty();
        }
    }

    private JiraInformation convertToJiraInformation(String info) {
        JsonObject jsonObject = gson.fromJson(info, JsonObject.class);
        String title = getAsString(jsonObject.getAsJsonObject("fields").get("summary"));
        String description = getAsString(jsonObject.getAsJsonObject("fields").get("description"));
        String assignee = getAsString(jsonObject.getAsJsonObject("fields").getAsJsonObject("assignee").get("displayName"));
        String reporter = getAsString(jsonObject.getAsJsonObject("fields").getAsJsonObject("reporter").get("displayName"));
        String key = getAsString(jsonObject.get("key"));
        return new JiraInformation(key, title, description, assignee, reporter);
    }

    private String getResponseAsString(CloseableHttpResponse response) throws IOException {
        InputStream content = response.getEntity().getContent();
        StringWriter writer = new StringWriter();
        IOUtils.copy(content, writer, "UTF-8");
        return writer.toString();
    }

    private String getAsString(JsonElement element) {
        try {
            return element.getAsString();
        } catch (UnsupportedOperationException e) {
            return "";
        }
    }

}