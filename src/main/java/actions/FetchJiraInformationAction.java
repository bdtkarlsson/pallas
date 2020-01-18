package actions;

import client.JiraClient;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class FetchJiraInformationAction extends AnAction {

    JiraClient client = new JiraClient();


    @Override
    public void actionPerformed(AnActionEvent e) {

        client.fetchJiraInformation("PAL-2");
    }
}
