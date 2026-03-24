import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<String> subjects = new ArrayList<>();
    static ArrayList<Double> credits = new ArrayList<>();
    static ArrayList<Double> scores = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        subjects = new ArrayList<>();
        credits = new ArrayList<>();
        scores = new ArrayList<>();

        for(int i=0; i<20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            subjects.add(st.nextToken());
            credits.add(Double.parseDouble(st.nextToken()));
            scores.add(gradeToScore(st.nextToken()));
        }

        bw.write(solution()+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static double solution() {
        double answer = 0.0;
        double creditSum = 0.0;

        for(int i=0; i<credits.size();i++) {
            if(scores.get(i) < 5.0) {
                answer += (credits.get(i)*scores.get(i));
                creditSum += credits.get(i);
            }
        }

        answer = answer/creditSum;

        return answer;
    }

    public static double gradeToScore(String grade) {
        double score = 5.0;

        switch (grade) {
            case "A+":
                score = 4.5;
                break;
            case "A0":
                score = 4.0;
                break;
            case "B+":
                score = 3.5;
                break;
            case "B0":
                score = 3.0;
                break;
            case "C+":
                score = 2.5;
                break;
            case "C0":
                score = 2.0;
                break;
            case "D+":
                score = 1.5;
                break;
            case "D0":
                score = 1.0;
                break;
            case "F":
                score = 0.0;
                break;
            default:
                score = 5.0; // P
        }
        return score;
    }
}