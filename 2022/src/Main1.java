import java.util.*;

class Student {
    private String id;
    private String name;
    private int age;

    public Student(String id,String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if ((o == null) || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return Objects.equals(this.id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        return id + ":" + name + ":" + age + "岁";
    }
}

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String str = scanner.nextLine();
            String[] split = str.trim().split("\\s+");
            students.add(new Student(split[0], split[1], Integer.parseInt(split[2])));
        }
        Set<Student> set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            set.add(students.get(i));
        }
        set.forEach(student -> System.out.println(student.toString()));
    }
}
