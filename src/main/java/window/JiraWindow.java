/*
 * Created by JFormDesigner on Sun Jan 19 14:58:35 CET 2020
 */

package window;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Daniel Karlsson
 */
public class JiraWindow  {

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Daniel Karlsson
        myToolWindowContent = new JPanel();
        jiraIdentifierField = new JTextField();
        fetchJiraButton = new JButton();
        statusBox = new JComboBox();
        tabbedPane = new JTabbedPane();
        infoPane = new JPanel();
        scrollPane2 = new JScrollPane();
        infoTextArea = new JTextArea();
        commentPane = new JPanel();
        commentScrollPane = new JScrollPane();
        commentEditorPane = new JEditorPane();
        commentButton = new JButton();

        //======== myToolWindowContent ========
        {
            myToolWindowContent.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
            0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
            . BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
            red) ,myToolWindowContent. getBorder( )) ); myToolWindowContent. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
            beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //---- fetchJiraButton ----
            fetchJiraButton.setText("Fetch JIRA");

            //======== tabbedPane ========
            {

                //======== infoPane ========
                {

                    //======== scrollPane2 ========
                    {

                        //---- infoTextArea ----
                        infoTextArea.setEditable(false);
                        infoTextArea.setLineWrap(true);
                        scrollPane2.setViewportView(infoTextArea);
                    }

                    GroupLayout infoPaneLayout = new GroupLayout(infoPane);
                    infoPane.setLayout(infoPaneLayout);
                    infoPaneLayout.setHorizontalGroup(
                        infoPaneLayout.createParallelGroup()
                            .addGroup(infoPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    infoPaneLayout.setVerticalGroup(
                        infoPaneLayout.createParallelGroup()
                            .addGroup(infoPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                }
                tabbedPane.addTab("Info", infoPane);

                //======== commentPane ========
                {

                    //======== commentScrollPane ========
                    {
                        commentScrollPane.setViewportView(commentEditorPane);
                    }

                    //---- commentButton ----
                    commentButton.setText("Send2");

                    GroupLayout commentPaneLayout = new GroupLayout(commentPane);
                    commentPane.setLayout(commentPaneLayout);
                    commentPaneLayout.setHorizontalGroup(
                        commentPaneLayout.createParallelGroup()
                            .addGroup(commentPaneLayout.createSequentialGroup()
                                .addGroup(commentPaneLayout.createParallelGroup()
                                    .addGroup(commentPaneLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(commentScrollPane, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(commentPaneLayout.createSequentialGroup()
                                        .addGap(158, 158, 158)
                                        .addComponent(commentButton)))
                                .addContainerGap(8, Short.MAX_VALUE))
                    );
                    commentPaneLayout.setVerticalGroup(
                        commentPaneLayout.createParallelGroup()
                            .addGroup(commentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(commentScrollPane, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(commentButton)
                                .addContainerGap(14, Short.MAX_VALUE))
                    );
                }
                tabbedPane.addTab("Comment", commentPane);
            }

            GroupLayout myToolWindowContentLayout = new GroupLayout(myToolWindowContent);
            myToolWindowContent.setLayout(myToolWindowContentLayout);
            myToolWindowContentLayout.setHorizontalGroup(
                myToolWindowContentLayout.createParallelGroup()
                    .addGroup(myToolWindowContentLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, myToolWindowContentLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(12, Short.MAX_VALUE)))
                    .addGroup(myToolWindowContentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jiraIdentifierField, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fetchJiraButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(statusBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
            );
            myToolWindowContentLayout.setVerticalGroup(
                myToolWindowContentLayout.createParallelGroup()
                    .addGroup(myToolWindowContentLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, myToolWindowContentLayout.createSequentialGroup()
                            .addContainerGap(42, Short.MAX_VALUE)
                            .addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(20, Short.MAX_VALUE)))
                    .addGroup(myToolWindowContentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(myToolWindowContentLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(statusBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jiraIdentifierField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(fetchJiraButton))
                        .addContainerGap(227, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        fetchJiraButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("JAnne");
            }
        });


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Daniel Karlsson
    private JPanel myToolWindowContent;
    private JTextField jiraIdentifierField;
    private JButton fetchJiraButton;
    private JComboBox statusBox;
    private JTabbedPane tabbedPane;
    private JPanel infoPane;
    private JScrollPane scrollPane2;
    private JTextArea infoTextArea;
    private JPanel commentPane;
    private JScrollPane commentScrollPane;
    private JEditorPane commentEditorPane;
    private JButton commentButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public JComponent getContent() {
        return myToolWindowContent;
    }
}
