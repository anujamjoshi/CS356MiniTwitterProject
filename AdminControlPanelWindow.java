import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;


@SuppressWarnings("serial")
public class AdminControlPanelWindow extends JFrame implements AdminPanel{
    private static AdminControlPanelWindow instance;
    /**
     * constructor to implement the Singleton class
     */
    public static AdminControlPanelWindow getInstance(){
        if (instance==null){
            instance = new AdminControlPanelWindow();
        }
        return instance;
    }
    private JTree tree;
    /**
     * @return the tree
     */
    public JTree getTree() {
        return tree;
    }
    private JButton addGroup;
    private JButton addUser;
    private JButton seeUserPanel;
    private JButton seeNumUser;
    private JButton seeNumGroup;
    private JButton seeNumMessage;
    private JButton seePercentage;
    private JPanel panel;
    private JPanel treePanel;
    private JPanel userPanel;
    private JPanel groupPanel;
    private JTextField groupID;
    private JTextField userID;
    private TreeImplementation treeImplementation;
    /**
     * @return the treeImplementation
     */
    public TreeImplementation getTreeImplementation() {
        return treeImplementation;
    }
    private popUpWindow popUp = new popUpWindow();
    
    /**
     * @return the addGroup
     */
    public JButton getAddGroup() {
        return addGroup;
    }
    /**
     * @return the addUser
     */
    public JButton getAddUser() {
        return addUser;
    }
    /**
     * @return the seeUserPanel
     */
    public JButton getSeeUserPanel() {
        return seeUserPanel;
    }
    /**
     * @return the seeNumUser
     */
    public JButton getSeeNumUser() {
        return seeNumUser;
    }
    /**
     * @return the seeNumGroup
     */
    public JButton getSeeNumGroup() {
        return seeNumGroup;
    }
    /**
     * @return the seeNumMessage
     */
    public JButton getSeeNumMessage() {
        return seeNumMessage;
    }
    /**
     * @return the seePercentage
     */
    public JButton getSeePercentage() {
        return seePercentage;
    }
    /**
     * @return the groupPanel
     */
    public JPanel getGroupPanel() {
        return groupPanel;
    }
    /**
     * @return the groupID
     */
    public JTextField getGroupID() {
        return groupID;
    }
    /**
     * @return the userID
     */
    public JTextField getUserID() {
        return userID;
    }
    private AdminControlPanelWindow(){
        createPanel();
        treeImplement();
        createButtons();
        createTextArea();
        this.setVisible(true);
    }
    private void createTextArea() {
        userPanel=new JPanel();
        userPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "User ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        userPanel.setBounds(300, 130, 230, 70);
        panel.add(userPanel);
        userPanel.setLayout(null);
        userID = new JTextField();
        userID.setBounds(10, 15, 210, 50);
        userPanel.add(userID);
        groupPanel=new JPanel();
        groupPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Group ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        groupPanel.setBounds(300, 30, 230, 70);
        panel.add(groupPanel);
        groupPanel.setLayout(null);
        groupID = new JTextField();
        groupID.setBounds(10, 15, 210, 50);
        groupPanel.add(groupID);
        
    }
    private void createPanel(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin Control Panel");
        setBounds(100, 100, 760, 710);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(panel);
        panel.setLayout(null);
    }
    private void treeImplement(){
        /**
         * add the Tree Panel
         */
        treePanel = new JPanel();
        treePanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tree View", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        treePanel.setBounds(0, 10, 250, 670);
        panel.add(treePanel);
        treePanel.setLayout(null);
        treeImplementation=new TreeImplementation();
        tree =new JTree(treeImplementation.getModel());
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setBounds(0, 0, 235, 680);
        JScrollPane scrollPane = new JScrollPane(tree);
        scrollPane.setBounds(10, 21, 231, 638);
        treePanel.add(scrollPane);
        /**
         * set icons to distinguish between the nodes
         */
        Icon leafIcon = UIManager.getIcon("FileView.fileIcon");
        Icon nonLeafIcon=UIManager.getIcon("FileView.directoryIcon");
        tree.setCellRenderer(new DisplayTreeDesign(leafIcon,nonLeafIcon));
    }
    private void createButtons(){
        /**
         * buttons
         */
        /*
         * User
         */
        addUser = new JButton("Add User");
        Handler handler = new Handler();
        addUser.addActionListener((ActionListener) handler);
        addUser.setBounds(540, 135, 170, 70);
        panel.add(addUser);
        /*
         * Group
         */
        addGroup=new JButton("Add Group");
        addGroup.addActionListener((ActionListener) handler);
        addGroup.setBounds(540, 34, 170, 70);
        panel.add(addGroup);
        /*
         * Open User View
         */
        seeUserPanel=new JButton("Open Twitter User data View");
        seeUserPanel.addActionListener((ActionListener) handler);
        seeUserPanel.setBounds(300, 245, 384, 70);
        panel.add(seeUserPanel);
        /*
         * User total
         */
        seeNumUser=new JButton("Show User Total");
        seeNumUser.addActionListener((ActionListener) handler);
        seeNumUser.setBounds(300, 460, 170, 70);
        panel.add(seeNumUser);
        /*
         * Group Total
         */
        seeNumGroup=new JButton("Show Group Total");
        seeNumGroup.addActionListener(handler);
        seeNumGroup.setBounds(540, 540, 170, 70);
        panel.add(seeNumGroup);
        /*
         * Message view
         */
        seeNumMessage=new JButton("Show Messages Total");
        seeNumMessage.addActionListener(handler);
        seeNumMessage.setBounds(300, 540, 170, 70);
        panel.add(seeNumMessage);
        /*
         * total percentage
         */
        seePercentage=new JButton("Show Positive Percentage");
        seePercentage.addActionListener(handler);
        seePercentage.setBounds(540, 460, 170, 70);
        panel.add(seePercentage);
    }
    @Override
    public void setIcon() {
        tree.setCellRenderer(new DefaultTreeCellRenderer() {
            private Icon groupIcon = UIManager.getIcon("FileView.directoryIcon");
            private Icon userIcon = UIManager.getIcon("FileView.fileIcon");
            
            @Override
            public Component getTreeCellRendererComponent(JTree tree,
                                                          Object value, boolean selected, boolean expanded,
                                                          boolean isLeaf, int row, boolean focused) {
                Component c = super.getTreeCellRendererComponent(tree, value,
                                                                 selected, expanded, isLeaf, row, focused);
                if (isLeaf)
                    setIcon(userIcon);
                else
                    setIcon(groupIcon);
                return c;
            }
        });
    }
    @Override
    public void OpenUserView(TwitterUser user) {
        TwitterUser node=getUser(this.tree);
        if(!(node instanceof User)){
            popUp.infoBox("Operation not supported! No user view for groups!","ERROR!");
            return;
        }
        else {
            new UserWindow((User)node,treeImplementation);
        }
    }
    @Override
    public TwitterUser getUser(JTree tree) {
        TreePath parentPath = tree.getSelectionPath();
        TwitterUser selectedNode=null;
        if (parentPath == null) {
            selectedNode = (TwitterUser) treeImplementation.getModel().getRoot();
        } else {
            selectedNode = (TwitterUser)(parentPath.getLastPathComponent());
        }
        return selectedNode;
    }
    
    private class Handler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            TwitterUser selectedNode=getUser(AdminControlPanelWindow.getInstance().getTree());
            
            if (e.getSource()==getAddGroup()){
                String groupId=groupID.getText().trim();
                TwitterUser newUserGroup=new UserGroup(groupId);
                if(groupId.isEmpty())
                    return;
                if(treeImplementation.addNode(selectedNode,newUserGroup)){
                    tree.scrollPathToVisible(new TreePath(newUserGroup.getPath()));
                }
                else {
                    return;
                }
            }
            else if (e.getSource()==getAddUser()){
                String userId=userID.getText().trim();
                TwitterUser newUser=new User(userId);
                selectedNode=getUser(tree);
                if(userId.isEmpty())
                    return;
                if(treeImplementation.addNode(selectedNode,newUser)){
                    tree.scrollPathToVisible(new TreePath(newUser.getPath()));
                }
                else {
                    return;
                }
            }
            
            else if (e.getSource()==AdminControlPanelWindow.getInstance().getSeeUserPanel()){
                OpenUserView(selectedNode);
            }
            else{
                popUpWindow p = new popUpWindow();
                if (e.getSource()==AdminControlPanelWindow.getInstance().getSeeNumGroup()){
                    NumUsers numUser= new NumUsers();
                    treeImplementation.invite(numUser);
                    p.infoBox( numUser.getCount() , "Number of Groups");
                    
                }
                else if (e.getSource()==AdminControlPanelWindow.getInstance().getSeeNumMessage()){
                    
                    Messages messages= new Messages();
                    treeImplementation.invite(messages);
                    p.infoBox(messages.getNumMessages(), "Number of Messages" );
                    
                }
                else if (e.getSource()==AdminControlPanelWindow.getInstance().getSeeNumUser()){
                    NumUsers userCount= new NumUsers();
                    treeImplementation.invite(userCount);
                    p.infoBox(userCount.getCount(), "Number of Users" );
                    
                }
                else if (e.getSource()==AdminControlPanelWindow.getInstance().getSeePercentage()){
                    PositiveMessages words= new PositiveMessages();
                    treeImplementation.invite(words);
                    p.infoBox(words.getPercent(),"Percent of Positive Words" );
                }
            }
            
        }
        
        
        
    }
}
