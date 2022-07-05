package br.com.fuctura;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

public class TestTable {

    private Connection con;

    public static void main(String[] args) {
        new TestTable();
    }

    public TestTable() {
        try {
            Class.forName("org.h2.Driver");
            String url = "jdbc:h2:mem:InMemoryTest";
            con = DriverManager.getConnection(url);

            createShoppingListTable();
            fillShoppingListTable();

            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }

                    JFrame frame = new JFrame("Testing");
                    frame.setLayout(new GridLayout());
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(new MenuSuperior());
                    frame.add(new TestPane());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            });
        } catch (ClassNotFoundException | SQLException exp) {
            exp.printStackTrace();
        }
    }

    protected void createShoppingListTable() throws SQLException {
        String query = "create table shoppingList (id int, item varchar(255), quantity int)";
        try (Statement stmt = con.createStatement()) {
            stmt.execute(query);
        }
    }

    protected void fillShoppingListTable() throws SQLException {

        String[] items = {"Bananas", "Apples", "Grapes", "Pears", "Oranges"};
        Random rnd = new Random();
        try (PreparedStatement ps = con.prepareStatement("insert into shoppingList (item, quantity) values (?, ?)")) {
            for (String item : items) {
                ps.setString(1, item);
                ps.setInt(2, rnd.nextInt(100));
                ps.addBatch();
            }

            ps.executeBatch();
        }

    }
    
    public class MenuSuperior extends JPanel{
    	
    	public MenuSuperior() {
            setLayout(new BorderLayout());
            
            add(new Button("Adicionar"));
            
        }
    	
    }
    
    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());
            TestTableModel model = new TestTableModel();
            JTable table = new JTable(model);
            
            add(new JScrollPane(table));
            
            

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        model.refresh();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }

    }

    public class TestTableModel extends AbstractTableModel {

        private List<ShoppingList> shoppingList = new ArrayList<>(25);
        private List<String> columnNames = new ArrayList<>(25);

        @Override
        public int getRowCount() {
            return shoppingList.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.size();
        }

        @Override
        public String getColumnName(int column) {
            return columnNames.get(column);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            ShoppingList rowValue = shoppingList.get(rowIndex);
            Object value = null;
            switch (columnIndex) {
                case 0:
                    value = rowValue.getId();
                    break;
                case 1:
                    value = rowValue.getItem();
                    break;
                case 2:
                    value = rowValue.getQuanity();
                    break;
            }
            return value;
        }

        public void refresh() throws SQLException {

            List<String> values = new ArrayList<>(25);
            try (PreparedStatement ps = con.prepareStatement("select * from shoppingList")) {
                try (ResultSet rs = ps.executeQuery()) {
                    ResultSetMetaData md = rs.getMetaData();
                    for (int col = 0; col < md.getColumnCount(); col++) {
                        values.add(md.getColumnName(col + 1));
                    }
                    while (rs.next()) {
                        ShoppingList list = new ShoppingList(rs.getLong(1), rs.getString(2), rs.getInt(3));
                        shoppingList.add(list);
                    }
                }
            } finally {
                if (columnNames.size() != values.size()) {
                    columnNames = values;
                    fireTableStructureChanged();
                } else {
                    fireTableDataChanged();
                }
            }

        }

        public class ShoppingList {

            private long id;
            private String item;
            private int quanity;

            public ShoppingList(long id, String item, int quanity) {
                this.id = id;
                this.item = item;
                this.quanity = quanity;
            }

            public long getId() {
                return id;
            }

            public String getItem() {
                return item;
            }

            public int getQuanity() {
                return quanity;
            }

        }
        
        public void addRow(ShoppingList s) {
        	this.shoppingList.add(s);
        	this.fireTableDataChanged();
        }
        
    }

}
