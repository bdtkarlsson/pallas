package client;

import api.JiraInformation;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

public class JiraClient {

    private static final Logger LOGGER = getLogger(JiraClient.class);
    private static final String JIRA_URL = "https://project-pallas.atlassian.net/rest/api/latest/issue/";
    private static final String SUPER_SECRET_LOL = "YmR0a2FybHNzb25AZ21haWwuY29tOmN6ekJzMFlEeWEwS2dLYmVSR1k1OUVCMg";
    private CloseableHttpClient httpClient;
    private Gson gson;

    public JiraClient() {
        gson = new Gson();
        httpClient = HttpClients.createDefault();
    }

    public Optional<JiraInformation> fetchJiraInformation(String jiraName) {

        try {
            HttpGet request = new HttpGet(JIRA_URL + jiraName);

            // add request headers
            request.addHeader("Authorization", "Basic " + SUPER_SECRET_LOL);
            CloseableHttpResponse response = httpClient.execute(request);

            InputStream content = response.getEntity().getContent();
            StringWriter writer = new StringWriter();
            IOUtils.copy(content, writer, "UTF-8");
            String info = writer.toString();
            JsonObject jsonObject = gson.fromJson(info, JsonObject.class);
            String title =jsonObject.getAsJsonObject("fields").get("summary").getAsString();
            String description = jsonObject.getAsJsonObject("fields").get("description").getAsString();
            String assignee = jsonObject.getAsJsonObject("fields").getAsJsonObject("assignee").get("displayName").getAsString();
            String reporter = jsonObject.getAsJsonObject("fields").getAsJsonObject("reporter").get("displayName").getAsString();

            String key =jsonObject.get("key").getAsString();

            return Optional.of(new JiraInformation(key, title, description, assignee, reporter));

        } catch (IOException e) {
            LOGGER.error("Nu gick det åt skogen", e);
            return Optional.empty();
        }
    }

}