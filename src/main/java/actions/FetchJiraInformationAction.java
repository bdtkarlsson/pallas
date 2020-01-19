package actions;

import client.JiraClient;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FetchJiraInformationAction extends AbstractAction {

    JiraClient client = new JiraClient();

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public boolean accept(Object sender) {
        return false;
    }
}
