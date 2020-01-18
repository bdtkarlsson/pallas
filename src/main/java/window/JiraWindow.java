package window;

import api.JiraInformation;
import client.JiraClient;
import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.util.Optional;

public class JiraWindow {
    private JButton fetchJiraButton;
    private JButton hideToolWindowButton;
    private JTextArea jiraText;
    private JTextField chosenJira;
    private JPanel myToolWindowContent;
    private JiraClient client;

    public JiraWindow(ToolWindow toolWindow) {
        hideToolWindowButton.addActionListener(e -> toolWindow.hide(null));
        fetchJiraButton.addActionListener(e -> fetchJira());
        client = new JiraClient();
    }

    public void fetchJira() {
        Optional<JiraInformation> info = client.fetchJiraInformation(chosenJira.getText());
        info.ifPresent(jiraInformation -> jiraText.setText(jiraInformation.getDescription()));
    }

    public JPanel getContent() {
        return myToolWindowContent;
    }
}
