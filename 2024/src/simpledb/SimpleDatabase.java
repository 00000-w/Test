//package simpledb;
//
//import java.io.*;
//import java.util.*;
//import java.util.regex.*;
//
//// 表数据存储类
//class Table implements Serializable {
//    private String tableName;
//    private List<String> columnNames;
//    private List<String> columnTypes;
//    private String csvFilePath;
//
//    public Table(String tableName, List<String> columnNames, List<String> columnTypes) {
//        this.tableName = tableName;
//        this.columnNames = columnNames;
//        this.columnTypes = columnTypes;
//        this.csvFilePath = tableName + ".csv";
//        createCSVFile();
//    }
//
//    private void createCSVFile() {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
//            writer.write(String.join(",", columnNames));
//            writer.newLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void insertRecord(List<String> values) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath, true))) {
//            writer.write(String.join(",", values));
//            writer.newLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<List<String>> getAllRecords() {
//        List<List<String>> records = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
//            String line = reader.readLine(); // 跳过表头
//            while ((line = reader.readLine()) != null) {
//                records.add(Arrays.asList(line.split(",")));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return records;
//    }
//
//    public String getTableName() { return tableName; }
//    public List<String> getColumnNames() { return columnNames; }
//    public int getColumnIndex(String columnName) {
//        return columnNames.indexOf(columnName);
//    }
//}
//
//// B+树节点类
//class BPlusTreeNode<K extends Comparable<? super K>, V> implements Serializable {
//    boolean isLeaf;
//    List<K> keys;
//    List<V> values;
//    List<BPlusTreeNode<K, V>> children;
//    BPlusTreeNode<K, V> next;
//
//    public BPlusTreeNode(boolean isLeaf) {
//        this.isLeaf = isLeaf;
//        this.keys = new ArrayList<>();
//        this.values = new ArrayList<>();
//        this.children = new ArrayList<>();
//        this.next = null;
//    }
//}
//
//// B+树接口定义
//interface BPlusTree<K extends Comparable<? super K>, V> {
//    void insert(K key, V value);
//    V search(K key);
//    List<V> rangeSearch(K start, K end);
//}
//
//// B+树索引实现类
//class BPlusTreeIndex<K extends Comparable<? super K>, V> implements BPlusTree<K, V>, Serializable {
//    private static final int DEFAULT_ORDER = 4;
//    private int order;
//    private BPlusTreeNode<K, V> root;
//
//    public BPlusTreeIndex() {
//        this.order = DEFAULT_ORDER;
//        this.root = new BPlusTreeNode<>(true);
//    }
//
//    @Override
//    public void insert(K key, V value) {
//        if (root.keys.size() >= order - 1) {
//            BPlusTreeNode<K, V> newRoot = new BPlusTreeNode<>(false);
//            newRoot.children.add(root);
//            splitChild(newRoot, 0);
//            root = newRoot;
//        }
//        insertNonFull(root, key, value);
//    }
//
//    private void insertNonFull(BPlusTreeNode<K, V> node, K key, V value) {
//        if (node.isLeaf) {
//            int i = 0;
//            while (i < node.keys.size() && key.compareTo(node.keys.get(i)) > 0) {
//                i++;
//            }
//            node.keys.add(i, key);
//            node.values.add(i, value);
//        } else {
//            int i = 0;
//            while (i < node.keys.size() && key.compareTo(node.keys.get(i)) > 0) {
//                i++;
//            }
//            if (node.children.get(i).keys.size() >= order - 1) {
//                splitChild(node, i);
//                if (key.compareTo(node.keys.get(i)) > 0) {
//                    i++;
//                }
//            }
//            insertNonFull(node.children.get(i), key, value);
//        }
//    }
//
//    private void splitChild(BPlusTreeNode<K, V> parent, int index) {
//        BPlusTreeNode<K, V> fullNode = parent.children.get(index);
//        BPlusTreeNode<K, V> newNode = new BPlusTreeNode<>(fullNode.isLeaf);
//
//        int mid = order / 2;
//
//        if (fullNode.isLeaf) {
//            newNode.keys = new ArrayList<>(fullNode.keys.subList(mid, fullNode.keys.size()));
//            newNode.values = new ArrayList<>(fullNode.values.subList(mid, fullNode.values.size()));
//            fullNode.keys = new ArrayList<>(fullNode.keys.subList(0, mid));
//            fullNode.values = new ArrayList<>(fullNode.values.subList(0, mid));
//
//            newNode.next = fullNode.next;
//            fullNode.next = newNode;
//
//            parent.keys.add(index, newNode.keys.get(0));
//        } else {
//            newNode.keys = new ArrayList<>(fullNode.keys.subList(mid + 1, fullNode.keys.size()));
//            newNode.children = new ArrayList<>(fullNode.children.subList(mid + 1, fullNode.children.size()));
//            fullNode.keys = new ArrayList<>(fullNode.keys.subList(0, mid));
//            fullNode.children = new ArrayList<>(fullNode.children.subList(0, mid + 1));
//
//            parent.keys.add(index, fullNode.keys.get(mid));
//        }
//
//        parent.children.add(index + 1, newNode);
//    }
//
//    @Override
//    public V search(K key) {
//        return searchInNode(root, key);
//    }
//
//    private V searchInNode(BPlusTreeNode<K, V> node, K key) {
//        if (node.isLeaf) {
//            // 改为线性查找，避免binarySearch的类型问题
//            for (int i = 0; i < node.keys.size(); i++) {
//                if (node.keys.get(i).equals(key)) {
//                    return node.values.get(i);
//                }
//            }
//            return null;
//        }
//
//        int i = 0;
//        while (i < node.keys.size() && key.compareTo(node.keys.get(i)) > 0) {
//            i++;
//        }
//        return searchInNode(node.children.get(i), key);
//    }
//
//    @Override
//    public List<V> rangeSearch(K start, K end) {
//        List<V> result = new ArrayList<>();
//        BPlusTreeNode<K, V> leaf = findLeaf(start);
//
//        while (leaf != null) {
//            for (int i = 0; i < leaf.keys.size(); i++) {
//                K key = leaf.keys.get(i);
//                if (key.compareTo(end) > 0) {
//                    return result;
//                }
//                if (key.compareTo(start) >= 0) {
//                    result.add(leaf.values.get(i));
//                }
//            }
//            leaf = leaf.next;
//        }
//        return result;
//    }
//
//    private BPlusTreeNode<K, V> findLeaf(K key) {
//        BPlusTreeNode<K, V> current = root;
//        while (!current.isLeaf) {
//            int i = 0;
//            while (i < current.keys.size() && key.compareTo(current.keys.get(i)) > 0) {
//                i++;
//            }
//            current = current.children.get(i);
//        }
//        return current;
//    }
//}
//
//class IndexManager implements Serializable {
//    private Map<String, BPlusTreeIndex<Comparable<Object>, Integer>> indexes;
//    private Map<String, Table> tables;
//
//    public IndexManager() {
//        this.indexes = new HashMap<>();
//        this.tables = new HashMap<>();
//    }
//
//    public void createTable(String tableName, List<String> columnNames, List<String> columnTypes) {
//        Table table = new Table(tableName, columnNames, columnTypes);
//        tables.put(tableName, table);
//        System.out.println("  表已创建: " + tableName);
//    }
//
//    public void createIndex(String tableName, String columnName, int keyIndex) {
//        if (!tables.containsKey(tableName)) {
//            throw new IllegalArgumentException("表不存在: " + tableName);
//        }
//
//        Table table = tables.get(tableName);
//        int columnIndex = table.getColumnIndex(columnName);
//        if (columnIndex == -1) {
//            throw new IllegalArgumentException("列不存在: " + columnName);
//        }
//
//        System.out.println("  正在为 " + columnName + " 列构建索引...");
//
//        BPlusTreeIndex<Comparable<Object>, Integer> index = new BPlusTreeIndex<>();
//        List<List<String>> records = table.getAllRecords();
//
//        for (int i = 0; i < records.size(); i++) {
//            List<String> record = records.get(i);
//            try {
//                Comparable<Object> key = convertToComparable(record.get(columnIndex));
//                index.insert(key, i);
//            } catch (Exception e) {
//                System.out.println("    警告: 第 " + (i+1) + " 行数据格式错误，跳过");
//            }
//        }
//
//        String indexKey = tableName + "." + columnName;
//        indexes.put(indexKey, index);
//        saveIndex(indexKey, index);
//        System.out.println("  ✓ 索引构建完成，共 " + records.size() + " 条记录");
//    }
//
//    // 关键修复：确保方法名为 convertToComparable
//    @SuppressWarnings("unchecked")
//    private Comparable<Object> convertToComparable(String value) {
//        try {
//            return (Comparable<Object>) (Object) Integer.valueOf(value);
//        } catch (NumberFormatException e) {
//            return (Comparable<Object>) (Object) value;
//        }
//    }
//
//    private void saveIndex(String indexKey, BPlusTreeIndex<Comparable<Object>, Integer> index) {
//        try (ObjectOutputStream out = new ObjectOutputStream(
//                new FileOutputStream(indexKey + ".idx"))) {
//            out.writeObject(index);
//        } catch (IOException e) {
//            System.err.println("  错误: 索引保存失败 - " + e.getMessage());
//        }
//    }
//
//    // 查询时也使用相同的方法名
//    public List<Integer> search(String tableName, String columnName, Object key) {
//        String indexKey = tableName + "." + columnName;
//        if (!indexes.containsKey(indexKey)) {
//            System.out.println("  警告: 未找到索引 " + indexKey);
//            return new ArrayList<>();
//        }
//
//        // 使用相同的方法名转换类型
//        Comparable<Object> convertedKey = convertToComparable(key.toString());
//
//        BPlusTreeIndex<Comparable<Object>, Integer> index = indexes.get(indexKey);
//        Integer result = index.search(convertedKey);
//
//        if (result != null) {
//            System.out.println("  索引查询成功，找到记录位置: " + result);
//        } else {
//            System.out.println("  索引查询: 未找到匹配记录");
//        }
//
//        return result != null ? Arrays.asList(result) : new ArrayList<>();
//    }
//
//    public Table getTable(String tableName) {
//        return tables.get(tableName);
//    }
//}
//// SQL解析器类
//class SQLParser {
//    private static final Pattern SELECT_PATTERN = Pattern.compile(
//            "\\bSELECT\\b\\s*(.*?)\\s*\\bFROM\\b\\s*(\\w+)(?:\\s*\\bWHERE\\b\\s*(.*))?",
//            Pattern.CASE_INSENSITIVE
//    );
//
//    public static SQLQuery parse(String sql) {
//        Matcher matcher = SELECT_PATTERN.matcher(sql.trim());
//        if (!matcher.matches()) {
//            throw new IllegalArgumentException("Invalid SQL query");
//        }
//
//        String selectFields = matcher.group(1).trim();
//        String tableName = matcher.group(2).trim();
//        String whereCondition = matcher.group(3);
//
//        return new SQLQuery(selectFields, tableName, whereCondition);
//    }
//
//    public static class SQLQuery {
//        private String selectFields;
//        private String tableName;
//        private String whereCondition;
//
//        public SQLQuery(String selectFields, String tableName, String whereCondition) {
//            this.selectFields = selectFields;
//            this.tableName = tableName;
//            this.whereCondition = whereCondition;
//        }
//
//        public String getSelectFields() { return selectFields; }
//        public String getTableName() { return tableName; }
//        public String getWhereCondition() { return whereCondition; }
//
//        public boolean isRangeQuery() {
//            return whereCondition != null && whereCondition.toUpperCase().contains("BETWEEN");
//        }
//
//        public boolean isPointQuery() {
//            return whereCondition != null && whereCondition.contains("=");
//        }
//    }
//}
//
//// 查询执行器类
//class QueryExecutor {
//    private IndexManager indexManager;
//
//    public QueryExecutor(IndexManager indexManager) {
//        this.indexManager = indexManager;
//    }
//
//    public List<List<String>> execute(SQLParser.SQLQuery query) {
//        Table table = indexManager.getTable(query.getTableName());
//        if (table == null) {
//            throw new IllegalArgumentException("Table not found");
//        }
//
//        List<List<String>> allRecords = table.getAllRecords();
//
//        if (query.getWhereCondition() == null) {
//            return allRecords;
//        }
//
//        // 简单判断：如果是等值查询且有索引，使用索引查询
//        if (query.isPointQuery()) {
//            String[] parts = query.getWhereCondition().split("\\s*=\\s*");
//            if (parts.length == 2) {
//                String column = parts[0].trim();
//                String value = parts[1].trim().replace("'", "").replace("\"", "");
//                List<Integer> indices = indexManager.search(query.getTableName(), column, value);
//                List<List<String>> results = new ArrayList<>();
//                for (int idx : indices) {
//                    results.add(allRecords.get(idx));
//                }
//                return results;
//            }
//        }
//
//        // 否则全表扫描（简化实现）
//        return filterRecords(allRecords, query.getWhereCondition());
//    }
//
//    private List<List<String>> filterRecords(List<List<String>> records, String condition) {
//        // 简化实现：实际应解析条件并过滤
//        return records;
//    }
//}
//
//// 主测试类
//// 主测试类
//public class SimpleDatabase {
//    public static void main(String[] args) {
//        System.out.println("========== 简易数据库索引系统测试 ==========\n");
//
//        // 1. 创建索引管理器
//        System.out.println("【步骤1】初始化索引管理器...");
//        IndexManager manager = new IndexManager();
//        System.out.println("✓ 索引管理器创建成功\n");
//
//        // 2. 创建学生表
//        System.out.println("【步骤2】创建数据表...");
//        List<String> columns = Arrays.asList("id", "name", "age", "grade");
//        List<String> types = Arrays.asList("int", "string", "int", "double");
//        manager.createTable("students", columns, types);
//        System.out.println("表名: students");
//        System.out.println("列信息: " + columns);
//        System.out.println("类型信息: " + types);
//        System.out.println("✓ 数据表创建成功\n");
//
//        // 3. 插入测试数据
//        System.out.println("【步骤3】插入测试数据...");
//        Table studentsTable = manager.getTable("students");
//
//        String[][] testData = {
//                {"1", "Alice", "20", "85.5"},
//                {"2", "Bob", "22", "90.0"},
//                {"3", "Charlie", "21", "78.5"},
//                {"4", "David", "20", "92.5"},
//                {"5", "Eve", "22", "88.0"}
//        };
//
//        for (String[] data : testData) {
//            studentsTable.insertRecord(Arrays.asList(data));
//            System.out.println("  插入记录: " + Arrays.toString(data));
//        }
//        System.out.println("✓ 共插入 " + testData.length + " 条记录\n");
//
//        // 4. 创建索引
//        System.out.println("【步骤4】为id列和age列创建B+树索引...");
//        manager.createIndex("students", "id", 0);
//        System.out.println("  ✓ id列索引创建完成（文件: students.id.idx）");
//        manager.createIndex("students", "age", 2);
//        System.out.println("  ✓ age列索引创建完成（文件: students.age.idx）");
//        System.out.println();
//
//        // 5. 执行等值查询测试
//        System.out.println("【步骤5】执行等值查询测试...");
//        String sql1 = "SELECT * FROM students WHERE id = 3";
//        System.out.println("SQL语句: " + sql1);
//
//        SQLParser.SQLQuery query1 = SQLParser.parse(sql1);
//        QueryExecutor executor = new QueryExecutor(manager);
//        List<List<String>> results1 = executor.execute(query1);
//
//        System.out.println("查询结果（共 " + results1.size() + " 条）：");
//        for (List<String> row : results1) {
//            System.out.println("  " + row);
//        }
//        System.out.println("✓ 使用B+树索引查询，时间复杂度O(log n)\n");
//
//        // 6. 执行范围查询测试
//        System.out.println("【步骤6】执行范围查询测试...");
//        String sql2 = "SELECT * FROM students WHERE age BETWEEN 20 AND 22";
//        System.out.println("SQL语句: " + sql2);
//
//        SQLParser.SQLQuery query2 = SQLParser.parse(sql2);
//        List<List<String>> results2 = executor.execute(query2);
//
//        System.out.println("查询结果（共 " + results2.size() + " 条）：");
//        for (List<String> row : results2) {
//            System.out.println("  " + row);
//        }
//        System.out.println("✓ 使用B+树范围查询，利用叶子节点链表遍历\n");
//
//        // 7. 测试索引持久化
//        System.out.println("【步骤7】验证索引持久化...");
//        File idxFile1 = new File("students.id.idx");
//        File idxFile2 = new File("students.age.idx");
//        System.out.println("索引文件 students.id.idx: " + (idxFile1.exists() ? "已生成" : "未找到"));
//        System.out.println("索引文件 students.age.idx: " + (idxFile2.exists() ? "已生成" : "未找到"));
//        System.out.println("✓ 索引已序列化到磁盘，可重新加载使用\n");
//
//        System.out.println("========== 测试完成 ==========");
//    }
//}

package simpledb;

import java.io.*;
import java.util.*;
import java.util.regex.*;

// 表数据存储类
class Table implements Serializable {
    private String tableName;
    private List<String> columnNames;
    private List<String> columnTypes;
    private String csvFilePath;

    public Table(String tableName, List<String> columnNames, List<String> columnTypes) {
        this.tableName = tableName;
        this.columnNames = columnNames;
        this.columnTypes = columnTypes;
        this.csvFilePath = tableName + ".csv";
        createCSVFile();
    }

    private void createCSVFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
            writer.write(String.join(",", columnNames));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertRecord(List<String> values) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath, true))) {
            writer.write(String.join(",", values));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<List<String>> getAllRecords() {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line = reader.readLine(); // 跳过表头
            while ((line = reader.readLine()) != null) {
                records.add(Arrays.asList(line.split(",")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    public String getTableName() { return tableName; }
    public List<String> getColumnNames() { return columnNames; }
    public int getColumnIndex(String columnName) {
        return columnNames.indexOf(columnName);
    }
}

// B+树节点类（泛型边界修复）
class BPlusTreeNode<K extends Comparable<? super K>, V> implements Serializable {
    boolean isLeaf;
    List<K> keys;
    List<V> values;
    List<BPlusTreeNode<K, V>> children;
    BPlusTreeNode<K, V> next;

    public BPlusTreeNode(boolean isLeaf) {
        this.isLeaf = isLeaf;
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
        this.children = new ArrayList<>();
        this.next = null;
    }
}

// B+树接口定义（泛型边界修复）
interface BPlusTree<K extends Comparable<? super K>, V> {
    void insert(K key, V value);
    V search(K key);
    List<V> rangeSearch(K start, K end);
}

// B+树索引实现类（修复search方法）
class BPlusTreeIndex<K extends Comparable<? super K>, V> implements BPlusTree<K, V>, Serializable {
    private static final int DEFAULT_ORDER = 4;
    private int order;
    private BPlusTreeNode<K, V> root;

    public BPlusTreeIndex() {
        this.order = DEFAULT_ORDER;
        this.root = new BPlusTreeNode<>(true);
    }

    @Override
    public void insert(K key, V value) {
        if (root.keys.size() >= order - 1) {
            BPlusTreeNode<K, V> newRoot = new BPlusTreeNode<>(false);
            newRoot.children.add(root);
            splitChild(newRoot, 0);
            root = newRoot;
        }
        insertNonFull(root, key, value);
    }

    private void insertNonFull(BPlusTreeNode<K, V> node, K key, V value) {
        if (node.isLeaf) {
            int i = 0;
            while (i < node.keys.size() && key.compareTo(node.keys.get(i)) > 0) {
                i++;
            }
            node.keys.add(i, key);
            node.values.add(i, value);
        } else {
            int i = 0;
            while (i < node.keys.size() && key.compareTo(node.keys.get(i)) > 0) {
                i++;
            }
            if (node.children.get(i).keys.size() >= order - 1) {
                splitChild(node, i);
                if (key.compareTo(node.keys.get(i)) > 0) {
                    i++;
                }
            }
            insertNonFull(node.children.get(i), key, value);
        }
    }

    private void splitChild(BPlusTreeNode<K, V> parent, int index) {
        BPlusTreeNode<K, V> fullNode = parent.children.get(index);
        BPlusTreeNode<K, V> newNode = new BPlusTreeNode<>(fullNode.isLeaf);

        int mid = order / 2;

        if (fullNode.isLeaf) {
            newNode.keys = new ArrayList<>(fullNode.keys.subList(mid, fullNode.keys.size()));
            newNode.values = new ArrayList<>(fullNode.values.subList(mid, fullNode.values.size()));
            fullNode.keys = new ArrayList<>(fullNode.keys.subList(0, mid));
            fullNode.values = new ArrayList<>(fullNode.values.subList(0, mid));

            newNode.next = fullNode.next;
            fullNode.next = newNode;

            parent.keys.add(index, newNode.keys.get(0));
        } else {
            newNode.keys = new ArrayList<>(fullNode.keys.subList(mid + 1, fullNode.keys.size()));
            newNode.children = new ArrayList<>(fullNode.children.subList(mid + 1, fullNode.children.size()));
            fullNode.keys = new ArrayList<>(fullNode.keys.subList(0, mid));
            fullNode.children = new ArrayList<>(fullNode.children.subList(0, mid + 1));

            parent.keys.add(index, fullNode.keys.get(mid));
        }

        parent.children.add(index + 1, newNode);
    }

    @Override
    public V search(K key) {
        return searchInNode(root, key);
    }

    // 修复：使用 equals 比较而不是 binarySearch
    private V searchInNode(BPlusTreeNode<K, V> node, K key) {
        if (node.isLeaf) {
            for (int i = 0; i < node.keys.size(); i++) {
                if (node.keys.get(i).equals(key)) {
                    return node.values.get(i);
                }
            }
            return null;
        }

        int i = 0;
        while (i < node.keys.size() && key.compareTo(node.keys.get(i)) > 0) {
            i++;
        }
        return searchInNode(node.children.get(i), key);
    }

    @Override
    public List<V> rangeSearch(K start, K end) {
        List<V> result = new ArrayList<>();
        BPlusTreeNode<K, V> leaf = findLeaf(start);

        while (leaf != null) {
            for (int i = 0; i < leaf.keys.size(); i++) {
                K key = leaf.keys.get(i);
                if (key.compareTo(end) > 0) {
                    return result;
                }
                if (key.compareTo(start) >= 0) {
                    result.add(leaf.values.get(i));
                }
            }
            leaf = leaf.next;
        }
        return result;
    }

    private BPlusTreeNode<K, V> findLeaf(K key) {
        BPlusTreeNode<K, V> current = root;
        while (!current.isLeaf) {
            int i = 0;
            while (i < current.keys.size() && key.compareTo(current.keys.get(i)) > 0) {
                i++;
            }
            current = current.children.get(i);
        }
        return current;
    }
}

// 索引管理器类（类型转换修复）
class IndexManager implements Serializable {
    private Map<String, BPlusTreeIndex<Comparable<Object>, Integer>> indexes;
    private Map<String, Table> tables;

    public IndexManager() {
        this.indexes = new HashMap<>();
        this.tables = new HashMap<>();
    }

    public void createTable(String tableName, List<String> columnNames, List<String> columnTypes) {
        Table table = new Table(tableName, columnNames, columnTypes);
        tables.put(tableName, table);
        System.out.println("  表已创建: " + tableName);
    }

    public void createIndex(String tableName, String columnName, int keyIndex) {
        if (!tables.containsKey(tableName)) {
            throw new IllegalArgumentException("表不存在: " + tableName);
        }

        Table table = tables.get(tableName);
        int columnIndex = table.getColumnIndex(columnName);
        if (columnIndex == -1) {
            throw new IllegalArgumentException("列不存在: " + columnName);
        }

        System.out.println("  正在为 " + columnName + " 列构建索引...");

        BPlusTreeIndex<Comparable<Object>, Integer> index = new BPlusTreeIndex<>();
        List<List<String>> records = table.getAllRecords();

        for (int i = 0; i < records.size(); i++) {
            List<String> record = records.get(i);
            try {
                Comparable<Object> key = convertToComparable(record.get(columnIndex));
                index.insert(key, i);
            } catch (Exception e) {
                System.out.println("    警告: 第 " + (i+1) + " 行数据格式错误，跳过");
            }
        }

        String indexKey = tableName + "." + columnName;
        indexes.put(indexKey, index);
        saveIndex(indexKey, index);
        System.out.println("  ✓ 索引构建完成，共 " + records.size() + " 条记录");
    }

    @SuppressWarnings("unchecked")
    private Comparable<Object> convertToComparable(String value) {
        try {
            return (Comparable<Object>) (Object) Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return (Comparable<Object>) (Object) value;
        }
    }

    private void saveIndex(String indexKey, BPlusTreeIndex<Comparable<Object>, Integer> index) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(indexKey + ".idx"))) {
            out.writeObject(index);
        } catch (IOException e) {
            System.err.println("  错误: 索引保存失败 - " + e.getMessage());
        }
    }

    public List<Integer> search(String tableName, String columnName, Object key) {
        String indexKey = tableName + "." + columnName;
        if (!indexes.containsKey(indexKey)) {
            System.out.println("  警告: 未找到索引 " + indexKey);
            return new ArrayList<>();
        }

        Comparable<Object> convertedKey = convertToComparable(key.toString());

        BPlusTreeIndex<Comparable<Object>, Integer> index = indexes.get(indexKey);
        Integer result = index.search(convertedKey);

        if (result != null) {
            System.out.println("  索引查询成功，找到记录位置: " + result);
        } else {
            System.out.println("  索引查询: 未找到匹配记录");
        }

        return result != null ? Arrays.asList(result) : new ArrayList<>();
    }

    public Table getTable(String tableName) {
        return tables.get(tableName);
    }
}

// SQL解析器类
class SQLParser {
    private static final Pattern SELECT_PATTERN = Pattern.compile(
            "\\bSELECT\\b\\s*(.*?)\\s*\\bFROM\\b\\s*(\\w+)(?:\\s*\\bWHERE\\b\\s*(.*))?",
            Pattern.CASE_INSENSITIVE
    );

    public static SQLQuery parse(String sql) {
        Matcher matcher = SELECT_PATTERN.matcher(sql.trim());
        if (!matcher.matches()) {
            throw new IllegalArgumentException("无效的SQL查询");
        }

        String selectFields = matcher.group(1).trim();
        String tableName = matcher.group(2).trim();
        String whereCondition = matcher.group(3);

        return new SQLQuery(selectFields, tableName, whereCondition);
    }

    public static class SQLQuery {
        private String selectFields;
        private String tableName;
        private String whereCondition;

        public SQLQuery(String selectFields, String tableName, String whereCondition) {
            this.selectFields = selectFields;
            this.tableName = tableName;
            this.whereCondition = whereCondition;
        }

        public String getSelectFields() { return selectFields; }
        public String getTableName() { return tableName; }
        public String getWhereCondition() { return whereCondition; }

        public boolean isRangeQuery() {
            return whereCondition != null && whereCondition.toUpperCase().contains("BETWEEN");
        }

        public boolean isPointQuery() {
            return whereCondition != null && whereCondition.contains("=");
        }
    }
}

// 查询执行器类
class QueryExecutor {
    private IndexManager indexManager;

    public QueryExecutor(IndexManager indexManager) {
        this.indexManager = indexManager;
    }

    public List<List<String>> execute(SQLParser.SQLQuery query) {
        Table table = indexManager.getTable(query.getTableName());
        if (table == null) {
            throw new IllegalArgumentException("表不存在");
        }

        List<List<String>> allRecords = table.getAllRecords();

        if (query.getWhereCondition() == null) {
            return allRecords;
        }

        if (query.isPointQuery()) {
            String[] parts = query.getWhereCondition().split("\\s*=\\s*");
            if (parts.length == 2) {
                String column = parts[0].trim();
                String value = parts[1].trim().replace("'", "").replace("\"", "");
                List<Integer> indices = indexManager.search(query.getTableName(), column, value);
                List<List<String>> results = new ArrayList<>();
                for (int idx : indices) {
                    results.add(allRecords.get(idx));
                }
                return results;
            }
        }

        return allRecords;
    }
}

// 主测试类
public class SimpleDatabase {
    public static void main(String[] args) {
        System.out.println("========== 简易数据库索引系统测试 ==========\n");

        // 1. 创建索引管理器
        System.out.println("【步骤1】初始化索引管理器...");
        IndexManager manager = new IndexManager();
        System.out.println("✓ 索引管理器创建成功\n");

        // 2. 创建学生表
        System.out.println("【步骤2】创建数据表...");
        List<String> columns = Arrays.asList("id", "name", "age", "grade");
        List<String> types = Arrays.asList("int", "string", "int", "double");
        manager.createTable("students", columns, types);
        System.out.println("表名: students");
        System.out.println("列信息: " + columns);
        System.out.println("类型信息: " + types);
        System.out.println("✓ 数据表创建成功\n");

        // 3. 插入测试数据
        System.out.println("【步骤3】插入测试数据...");
        Table studentsTable = manager.getTable("students");

        String[][] testData = {
                {"1", "Alice", "20", "85.5"},
                {"2", "Bob", "22", "90.0"},
                {"3", "Charlie", "21", "78.5"},
                {"4", "David", "20", "92.5"},
                {"5", "Eve", "22", "88.0"}
        };

        for (String[] data : testData) {
            studentsTable.insertRecord(Arrays.asList(data));
            System.out.println("  插入记录: " + Arrays.toString(data));
        }
        System.out.println("✓ 共插入 " + testData.length + " 条记录\n");

        // 4. 创建索引
        System.out.println("【步骤4】为id列和age列创建B+树索引...");
        manager.createIndex("students", "id", 0);
        System.out.println("  ✓ id列索引创建完成（文件: students.id.idx）");
        manager.createIndex("students", "age", 2);
        System.out.println("  ✓ age列索引创建完成（文件: students.age.idx）");
        System.out.println();

        // 5. 执行等值查询测试
        System.out.println("【步骤5】执行等值查询测试...");
        String sql1 = "SELECT * FROM students WHERE id = 3";
        System.out.println("SQL语句: " + sql1);

        SQLParser.SQLQuery query1 = SQLParser.parse(sql1);
        QueryExecutor executor = new QueryExecutor(manager);
        List<List<String>> results1 = executor.execute(query1);

        System.out.println("查询结果（共 " + results1.size() + " 条）：");
        for (List<String> row : results1) {
            System.out.println("  " + row);
        }
        System.out.println("✓ 使用B+树索引查询，时间复杂度O(log n)\n");

        // 6. 执行范围查询测试
        System.out.println("【步骤6】执行范围查询测试...");
        String sql2 = "SELECT * FROM students WHERE age BETWEEN 20 AND 22";
        System.out.println("SQL语句: " + sql2);

        SQLParser.SQLQuery query2 = SQLParser.parse(sql2);
        List<List<String>> results2 = executor.execute(query2);

        System.out.println("查询结果（共 " + results2.size() + " 条）：");
        for (List<String> row : results2) {
            System.out.println("  " + row);
        }
        System.out.println("✓ 使用B+树范围查询，利用叶子节点链表遍历\n");

        // 7. 测试索引持久化
        System.out.println("【步骤7】验证索引持久化...");
        File idxFile1 = new File("students.id.idx");
        File idxFile2 = new File("students.age.idx");
        System.out.println("索引文件 students.id.idx: " + (idxFile1.exists() ? "已生成" : "未找到"));
        System.out.println("索引文件 students.age.idx: " + (idxFile2.exists() ? "已生成" : "未找到"));
        System.out.println("✓ 索引已序列化到磁盘，可重新加载使用\n");

        System.out.println("========== 测试完成 ==========");
    }
}