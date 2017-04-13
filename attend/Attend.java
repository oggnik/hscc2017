import java.util.*;

public class Attend {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<Student> students = new ArrayList<Student>();
		for (int i = 0; i <= n; i++) {
			students.add(new Student(s.nextLine()));
		}
		Collections.sort(students);
		for (Student st : students) {
			System.out.println(st.name);
		}
	}
}

class Student implements Comparable<Student> {
	String name;
	String last;
	public Student(String name) {
		String[] parts = name.split(" ");
		this.name = name;
		last = parts[parts.length - 1].toLowerCase();
	}

	public int compareTo(Student t) {
		int ret = this.last.compareTo(t.last);
		if (ret == 0) 
			return this.name.toLowerCase().compareTo(t.name.toLowerCase());
		else
			return (this.last.compareTo(t.last));
	}
}
