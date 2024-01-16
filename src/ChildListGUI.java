import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ChildListGUI extends JFrame {
    private JList<String> childList;
    private DefaultListModel<String> listModel;

    public ChildListGUI() {
        setTitle("Child List");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        childList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(childList);
        add(scrollPane, BorderLayout.CENTER);

        JButton loadButton = new JButton("Load Children");
        loadButton.addActionListener(e -> loadAndDisplayChildren());
        add(loadButton, BorderLayout.SOUTH);
    }

    private void loadAndDisplayChildren() {
        listModel.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("children.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listModel.addElement(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}