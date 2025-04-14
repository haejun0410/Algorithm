import java.util.*;
import java.io.*;

public class Main {
  
    public static class Person {
      int age;
      String name;
      
      public Person(int age, String name) {
        this.age = age;
        this.name = name;
      }
      
      @Override
      public String toString() {
        return age + " " + name + "\n";
      }
    }
  
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      
      Person[] p = new Person[n];
      
      for (int i=0; i<n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int age = Integer.parseInt(st.nextToken());
        String name = st.nextToken();
        p[i] = new Person(age, name);
      }
      
      Arrays.sort(p, new Comparator<Person>() {
        
        @Override
        public int compare(Person s1, Person s2) {
          return Integer.compare(s1.age, s2.age);
        }
      });
      
      StringBuilder sb = new StringBuilder();
      
      for (int i=0; i<n; i++) {
        sb.append(p[i]);
      }
      
      System.out.println(sb);
  }
}