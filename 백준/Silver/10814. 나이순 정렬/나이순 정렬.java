import java.util.*;
import java.io.*;

public class Main {

    static public class Person {
        int age;
        int order;
        String name;

        Person(int age, int order, String name) {
            this.age = age;
            this.order = order;
            this.name = name;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Person[] club = new Person[N];
        // 사람 객체 club 배열에 넣어주기
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            club[i] = new Person(Integer.parseInt(st.nextToken()), i, st.nextToken());
        }

        Arrays.sort(club, (a, b) -> {
           if(a.age == b.age) return a.order - b.order;
           return a.age - b.age;
        });

        for(Person p : club) {
            bw.write(p.age+" "+p.name+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}